package com.yundian.dealerweb.controller;

import com.yundian.dealerweb.util.DealerWebConstants;
import com.yundian.fssapi.domain.FssDealerUserModel;
import com.yundian.fssapi.enums.FssDealerUserStatusEnum;
import com.yundian.fssapi.service.FssDealerUserService;
import com.yundian.toolkit.utils.MD5;
import com.yundian.toolkit.utils.WebUtil;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginDealerController {

	/**
	 * 日志写入对象
	 */
	private static final Logger logger = Logger
			.getLogger(LoginDealerController.class);

	/**
	 * 经销商用户服务
	 */
	@Autowired
	private FssDealerUserService fssDealerUserService;

	/**
	 * 跳转到登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String login(HttpSession session) {
		Object userInfo = session
				.getAttribute(DealerWebConstants.SYS.WEB_USER_SESSION);
		if (userInfo != null) {
			return "redirect:/index.html";
		}
		return "login";
	}

	/**
	 * 登录成功后跳转到主页面
	 * 
	 * @param loginName
	 *            用户信息类
	 * @param loginPassword
	 *            request 对象
	 * @param httpResponse
	 *            response对象
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String doLogin(@RequestParam("username") String loginName,
			@RequestParam("password") String loginPassword,
			HttpSession session, HttpServletResponse httpResponse) {
		try {
//			// 判断是否存在该用户
			FssDealerUserModel fssDealerUserModel = fssDealerUserService
					.fssFssDealerUserLogin(loginName,
							loginPassword);

			// fssDealerUserModel，空值表示不存在该用户
			if (null != fssDealerUserModel) {
				// 判断该用户是否被停用
				  if (fssDealerUserModel.getStatus() == FssDealerUserStatusEnum.DISABLE.code()){
				  	return WebUtil.getFailureJson("账号无效") .toString();
				  }
				fssDealerUserModel.setUserPwd("");

				// 将用户登录信息放入session中
				session.setAttribute(
						DealerWebConstants.SYS.WEB_USER_SESSION, fssDealerUserModel);
				 // 记录本次登陆的时间
				return WebUtil.getSuccessJson().toString();
			} else {
				return WebUtil.getFailureJson("用户名或密码错误").toString();
			}
		} catch (Exception ex) {
			logger.error("登录出错" + ExceptionUtils.getFullStackTrace(ex));
			ex.printStackTrace();
			return WebUtil.getFailureJson("登录出错" + ex.getMessage()).toString();
		}
	}

	/**
	 * 跳转到登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/logout.html", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute(DealerWebConstants.SYS.WEB_USER_SESSION);
		return "redirect:/login.html";
	}
}
