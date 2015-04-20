package kr.ac.mju.control;

import kr.ac.mju.Conf.Configuration.ErrorCodes;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.model.LoginInfo;
import kr.ac.mju.model.UserInfo;
import kr.ac.mju.service.LoginService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("userInfo")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	LoginService loginService;
	
	@Resource(name="loginInfo")
	LoginInfo loginInfo;
	
	
	ModelAndView modelAndView = new ModelAndView();
	
	@RequestMapping(value = "/loginController/login.do", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, RedirectAttributes redir) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");
		
		loginInfo.setUserId(userID);
		loginInfo.setUserPassword(userPassword);
		logger.info("ID :" + userID);
		logger.info("Password :" + userPassword);
		UserInfo userInfo = this.loginService.login(loginInfo);
		
		
		logger.info("에러코드 :" + userInfo.getErrorCode());
		if(userInfo.getErrorCode().equals("Success")){
			request.getSession().setAttribute("userInfo", userInfo);
			modelAndView.setViewName("logged");
			//redir.addFlashAttribute("userInfo", userInfo);
			return modelAndView;
		} else {
			ErrorCodes errorCodes = ErrorCodes.valueOf(userInfo.getErrorCode());
			modelAndView.setViewName("redirect:/");
			redir.addFlashAttribute("userInfo", errorCodes);
			return modelAndView;
		}
	}
	@RequestMapping(value = "/loginController/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) throws UnsupportedEncodingException {
		request.getSession().setAttribute("userInfo", null);
		return "redirect:/";
	}
}
