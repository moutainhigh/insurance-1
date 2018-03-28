package com.yundian.dealerweb.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yundian.fssapi.domain.FssUserModel;
import com.yundian.fssapi.service.FssGuaranteeUserService;
import com.yundian.dealerweb.util.GuaranteeWebConstants;
import com.yundian.result.Result;
import com.yundian.toolkit.utils.MD5;
import com.yundian.toolkit.utils.WebUtil;

@Controller
public class LoginGuaranteeController {

	/**
	 * 日志写入对象
	 */
	private static final Logger logger = Logger
			.getLogger(LoginGuaranteeController.class);

	// 注入登录模块服务
	@Autowired
	private FssGuaranteeUserService fssGuaranteeUserService;

	/**
	 * 跳转到登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String login(HttpSession session) {
		Object userInfo = session
				.getAttribute(GuaranteeWebConstants.SYS.WEB_USER_SESSION);
		if (userInfo != null) {
			return "redirect:/index.html";
		}
		return "login";
	}

	/**
	 * 登录成功后跳转到主页面
	 * 
	 * @param user
	 *            用户信息类
	 * @param httpRequest
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
			// 判断是否存在该用户
			Result<FssUserModel> result = fssGuaranteeUserService
					.guaranteeUserLogin(loginName,
							MD5.encodePassword(loginPassword));
			FssUserModel userInfo = result.getData();
			// 判断userinfo是否为空，空值表示不存在该用户
			if (null != userInfo) {
				// 判断该用户是否被停用
				/*
				 * if (userInfo.getState() == FssYesOrNoEnum.N.code()) { return
				 * WebUtil.getFailureJson("账号无效") .toString(); }
				 */
				// 将用户登录信息放入session中
				session.setAttribute(
						GuaranteeWebConstants.SYS.WEB_USER_SESSION, userInfo);

				// // 登录成功后获取用户的权限,并放入session中
				// String userPermission =
				// permissonService.getModuleInfoByUserID(
				// userInfo.getLoginName(), userInfo.getUserId());
				// httpRequest.getSession()
				// .setAttribute(Constants.SYS.WEB_USERALLRIGHTS_SESSION,
				// userPermission);
				//
				// // 记录本次登陆的时间
				// tpUserService.updateLoginTime(userInfo.getUserId());
				return WebUtil.getSuccessJson().toString();
			} else {
				return WebUtil.getFailureJson("用户名或密码错误").toString();
			}
		} catch (Exception ex) {
			session.setAttribute("登录失败", ExceptionUtils.getFullStackTrace(ex));
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
		session.removeAttribute(GuaranteeWebConstants.SYS.WEB_USER_SESSION);
		return "redirect:/login.html";
	}
}
