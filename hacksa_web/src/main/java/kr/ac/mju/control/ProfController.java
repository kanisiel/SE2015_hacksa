package kr.ac.mju.control;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.Conf.Configuration.ErrorCodes;
import kr.ac.mju.model.SubjectInfo;
import kr.ac.mju.model.UserInfo;
import kr.ac.mju.service.AdminService;
import kr.ac.mju.service.ProfService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("userInfo")
public class ProfController {

	private static final Logger logger = LoggerFactory.getLogger(ProfController.class);
	
	@Autowired
	ProfService profService;
	

	ModelAndView modelAndView;
	
	@RequestMapping(value = "/profController/subjectList", method = RequestMethod.GET)
	public ModelAndView subjectList(@ModelAttribute("userInfo") UserInfo userInfo, HttpServletRequest request) throws UnsupportedEncodingException, SQLException {
		modelAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		SubjectInfo subjectInfo = profService.getList();
		modelAndView.addObject("userInfo",request.getSession().getAttribute("userInfo"));

		logger.info("에러코드 :" + subjectInfo.getErrorCode());
		if(subjectInfo.getErrorCode().equals("Success")){
			modelAndView.addObject("subjectInfo", subjectInfo);
			modelAndView.setViewName("subject");
			return modelAndView;
		} else {
			ErrorCodes errorCodes = ErrorCodes.valueOf(subjectInfo.getErrorCode());
			request.getSession().setAttribute("subjectInfo", errorCodes);
			modelAndView.setViewName("logged");
			return modelAndView;
		}
	}
}
