package kr.ac.mju.control;

import kr.ac.mju.Conf.Configuration.ErrorCodes;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.model.DepartmentInfo;
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
@SessionAttributes("userInfo")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	LoginService2 loginService2;
	
	@ModelAttribute("loginInfo")
	LoginInfo loginInfo(){
		return new LoginInfo();
	}
	
	
	ModelAndView modelAndView;
	
//	@RequestMapping(value = "/loginController/createAccount.do", method = RequestMethod.POST)
//	public ModelAndView createAccount(HttpServletRequest request, RedirectAttributes redir) throws UnsupportedEncodingException, ClassNotFoundException, SQLException {
//		this.modelAndView = new ModelAndView();
//		request.setCharacterEncoding("UTF-8");
//		loginService2.createAccount();
//		modelAndView.setViewName("redirect:/");
//		return modelAndView;
//	}
	@RequestMapping(value = "/loginController/createAccount.do", method = RequestMethod.POST)
	public ModelAndView createAccount(HttpServletRequest request, RedirectAttributes redir) throws UnsupportedEncodingException, ClassNotFoundException, SQLException {
		this.modelAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		return modelAndView;
	}
	@RequestMapping(value = "/loginController/registerAccount", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("loginInfo") LoginInfo loginInfo, HttpServletRequest request) throws UnsupportedEncodingException, ClassNotFoundException, SQLException {
		this.modelAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");
		loginInfo.setUserId(userID);
		loginInfo.setUserPassword(userPassword);
		DepartmentInfo departmentInfo = loginService.getList();
		modelAndView.addObject("loginInfo", loginInfo);
		modelAndView.addObject("departments", departmentInfo);
		modelAndView.setViewName("registerAccount");
		return modelAndView;
	}
	
	@RequestMapping(value = "/loginController/login.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("loginInfo") LoginInfo loginInfo, HttpServletRequest request, RedirectAttributes redir) throws UnsupportedEncodingException, ClassNotFoundException, SQLException {
		UserInfo userInfo = null;
		this.modelAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");
		
		loginInfo.setUserId(userID);
		loginInfo.setUserPassword(userPassword);
		logger.info("ID :" + userID);
		logger.info("Password :" + userPassword);
		userInfo = this.loginService.login(loginInfo);
		modelAndView.addObject("userInfo", userInfo);
		
		logger.info("에러코드 :" + userInfo.getErrorCode());
		if(userInfo.getErrorCode().equals("Success")){
			this.modelAndView.setViewName("logged");
		} else {
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
