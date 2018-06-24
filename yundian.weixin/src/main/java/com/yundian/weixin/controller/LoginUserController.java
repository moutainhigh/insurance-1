package com.yundian.weixin.controller;

import com.yundian.fssapi.domain.FssDealerModel;
import com.yundian.fssapi.domain.FssDealerUserModel;
import com.yundian.fssapi.domain.FssUserModel;
import com.yundian.fssapi.enums.FssDealerUserStatusEnum;
import com.yundian.fssapi.service.FssDealerService;
import com.yundian.fssapi.service.FssDealerUserService;
import com.yundian.fssapi.service.FssUserService;
import com.yundian.result.Result;
import com.yundian.weixin.util.WeixinWebConstants;
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
public class LoginUserController {

	/**
	 * 日志写入对象
	 */
	private static final Logger logger = Logger
			.getLogger(LoginUserController.class);

	/**
	 * 经销商用户服务
	 */
	@Autowired
	private FssUserService fssUserService;

	@Autowired
	private FssDealerService fssDealerService;
	/**
	 * 跳转到登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String login(HttpSession session) {
		Object userInfo = session
				.getAttribute(WeixinWebConstants.SYS.WEB_USER_SESSION);
		if (userInfo != null) {
			return "redirect:/Loan.html";
		}
		return "Login";
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
	public Result doLogin(@RequestParam("username") String loginName,
							  @RequestParam("password") String loginPassword,
							  HttpSession session, HttpServletResponse httpResponse) {
		try {
//			// 判断是否存在该用户
			FssUserModel fssUserModel = fssUserService.fssFssUserLogin(loginName,
							loginPassword);

			// fssDealerUserModel，空值表示不存在该用户
			if (null != fssUserModel) {

				fssUserModel.setUserPwd(null);
//				FssDealerModel fssDealerModel = fssDealerService.getFssDealer(fssDealerUserModel.getDealerId());
//				fssDealerUserModel.setDealerName(fssDealerModel.getDealerName());
				// 将用户登录信息放入session中
				session.setAttribute(
						WeixinWebConstants.SYS.WEB_USER_SESSION, fssUserModel);
				 // 记录本次登陆的时间
				return Result.success(null);
			} else {
				return Result.fail("","用户名或密码错误");
			}
		} catch (Exception ex) {
			logger.error("登录出错" + ExceptionUtils.getFullStackTrace(ex));
			ex.printStackTrace();
			return Result.fail("","登录异常，稍后再试");
		}
	}

	/**
	 * 跳转到登录页面
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/loginOut", method = RequestMethod.GET)
	public Result logout(HttpSession session) {
		session.removeAttribute(WeixinWebConstants.SYS.WEB_USER_SESSION);
		return Result.success(true);
	}
}
