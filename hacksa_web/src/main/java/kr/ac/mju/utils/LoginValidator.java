package kr.ac.mju.utils;

import model.CMember;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LoginValidator implements Validator {
	public boolean supports(Class<?> clazz) {
		return CMember.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object command, Errors errors){
		
		CMember member = (CMember) command;
		if(!StringUtils.hasLength(member.getID())){
			errors.rejectValue("user_id", "error.required");
		}
		
		if(!StringUtils.hasLength(member.getPassword())){
			errors.rejectValue("password", "error.required");
		}
		
		if(errors.hasErrors()){
			errors.reject("error.input.user");
		}
	}
}
