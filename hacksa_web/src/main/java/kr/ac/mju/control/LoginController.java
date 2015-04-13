package kr.ac.mju.control;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.model.LoginInfo;
import kr.ac.mju.model.User;
import kr.ac.mju.model.UserInfo;
import kr.ac.mju.service.LoginService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	LoginService loginService;
	
	@Resource(name="loginInfo")
	LoginInfo loginInfo;
	
	@RequestMapping(value = "/loginController/login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");
		
		loginInfo.setUserId(userID);
		loginInfo.setUserPassword(userPassword);
		
		UserInfo userInfo = this.loginService.login(loginInfo);
		
		
		logger.info("에러코드 :" + userInfo.getErrorCode());
		if(userInfo.getErrorCode().equals("Success")){
			request.getSession().setAttribute("userInfo", userInfo);
			return "sugang";
		} else {
			request.getSession().setAttribute("userInfo", userInfo);
			return "redirect:/";
		}
	}
}
