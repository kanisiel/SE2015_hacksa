package kr.ac.mju.control;

import java.util.Locale;

import kr.ac.mju.model.CMember;
import kr.ac.mju.model.Hacksa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class loginFormController {
	private Hacksa hacksa;
	private Validator loginValidator;
	
	@Autowired
	public void setHacksa(Hacksa hacksa) {
		this.hacksa = hacksa;
	}
	
	@Autowired
	public void setLoginValidator(Validator loginValidator) {
		this.loginValidator = loginValidator;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String toLoginView(){
		return "login";
	}
	
	@ModelAttribute
	public CMember setUpForm(){
		return new CMember();
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		
		model.addAttribute("CMember", new CMember());
		return "login";
	}
	
	@RequestMapping (method = RequestMethod.POST)
	public ModelAndView onSubmit(CMember member, BindingResult bindingResult){
		
		this.loginValidator.validate(member, bindingResult);
		
		ModelAndView modelAndView = new ModelAndView();
		if(bindingResult.hasErrors()){
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;
		}
		
		try{
			//사용자 검색
			CMember loginMember = this.hacksa.getMember(member.getID(), member.getPassword());
			
			//사용자가 있을때
			modelAndView.setViewName("loginSuccess");
			modelAndView.addObject("loginMember", loginMember);
			return modelAndView;
		} catch (EmptyResultDataAccessException e) {
			//사용자가 없을때
			bindingResult.reject("error.login.Memeber");
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;
		}
	}
}