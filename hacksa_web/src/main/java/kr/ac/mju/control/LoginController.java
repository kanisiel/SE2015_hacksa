package kr.ac.mju.control;

import kr.ac.mju.Conf.Configuration.ErrorCodes;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.model.LoginInfo;
import kr.ac.mju.model.UserInfo;
import kr.ac.mju.service.LoginService;
import kr.ac.mju.service.LoginService2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	LoginService loginService;
	
	@Resource(name="loginInfo")
	LoginInfo loginInfo;
	
	
	ModelAndView modelAndView = new ModelAndView();
	
	@RequestMapping(value = "/loginController/login.do", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, RedirectAttributes redir) throws UnsupportedEncodingException, ClassNotFoundException, SQLException {
		UserInfo userInfo = null;
		this.modelAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");
		Map<String, Object> map = new HashMap<String, Object>();
		
		loginInfo.setUserId(userID);
		loginInfo.setUserPassword(userPassword);
		logger.info("ID :" + userID);
		logger.info("Password :" + userPassword);
		userInfo = this.loginService.login(loginInfo);
		request.setAttribute("userInfo", userInfo);
		redir.addFlashAttribute("userInfo", userInfo);
		
		logger.info("에러코드 :" + userInfo.getErrorCode());
		if(userInfo.getErrorCode().equals("Success")){
			this.modelAndView.setViewName("logged");
		} else {
			redir.addFlashAttribute("userInfo", userInfo);
			this.modelAndView.setViewName("redirect:/");
		}
		return this.modelAndView;
	}
	@RequestMapping(value = "/loginController/logout", method = RequestMethod.GET)
	public String logout( RedirectAttributes redir ) throws UnsupportedEncodingException {
		redir.addFlashAttribute("userInfo", null);
		return "redirect:/";
	}
	
}
