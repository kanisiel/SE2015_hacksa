package kr.ac.mju.control;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.model.GwamokInfo;
import kr.ac.mju.service.LoginService;
import kr.ac.mju.service.SugangService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SugangController {
	
private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	SugangService sugangService;
	
	@Resource(name="gwamokInfo")
	GwamokInfo gwamokInfo;
	
	ModelAndView modelAndView = new ModelAndView();
	
	@RequestMapping(value = "/sugangController/gwamokList", method = RequestMethod.POST)
	public ModelAndView gwamokList(HttpServletRequest request, RedirectAttributes redir) throws UnsupportedEncodingException {
		
		return modelAndView;
	}
}
