package kr.ac.mju.control;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.Conf.Configuration;
import kr.ac.mju.Conf.Configuration.ErrorCodes;
import kr.ac.mju.model.Subject;
import kr.ac.mju.model.SubjectInfo;
import kr.ac.mju.model.UserInfo;
import kr.ac.mju.service.AdminService;
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
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	AdminService adminService;
	
	@ModelAttribute("userInfo")  
    public UserInfo userInfo() {  
        return new UserInfo();  
    }
	
	ModelAndView modelAndView;
	
	@RequestMapping(value = "/adminController/subjectList", method = RequestMethod.GET)
	public ModelAndView subjectList(@ModelAttribute("userInfo") UserInfo userInfo, HttpServletRequest request) throws UnsupportedEncodingException, SQLException {
		modelAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		SubjectInfo subjectInfo = adminService.getList();
		modelAndView.addObject("userInfo",request.getSession().getAttribute("userInfo"));

		logger.info("에러코드 :" + subjectInfo.getErrorCode());
		if(subjectInfo.getErrorCode().equals("Success")){
			modelAndView.addObject("subjectInfo", subjectInfo);
			modelAndView.setViewName("admin/subject");
			return modelAndView;
		} else {
			ErrorCodes errorCodes = ErrorCodes.valueOf(subjectInfo.getErrorCode());
			request.getSession().setAttribute("subjectInfo", errorCodes);
			modelAndView.setViewName("logged");
			return modelAndView;
		}
	}
	@RequestMapping(value = "/adminController/createSubject", method = RequestMethod.POST)
	public ModelAndView createForm(@ModelAttribute("userInfo") UserInfo userInfo, HttpServletRequest request) throws UnsupportedEncodingException {
		modelAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		modelAndView.addObject("userInfo", userInfo);
		modelAndView.setViewName("admin/createSubject");
		return modelAndView;
		
	}
	@RequestMapping(value = "/adminController/createSubject.do", method = RequestMethod.POST)
	public ModelAndView createSubjectQuery(@ModelAttribute("userInfo") UserInfo userInfo, HttpServletRequest request) throws UnsupportedEncodingException, SQLException {
		modelAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		String sid = request.getParameter("SID");
		String name = request.getParameter("NAME");
		String unitbuffer = request.getParameter("UNIT");
		int unit = Integer.parseInt(unitbuffer);
		Subject subject = new Subject(sid, name, unit);
		String errorCode = adminService.createSubject(subject);
		if(errorCode=="Success"){
			return subjectList(userInfo, request);
		}
		Map<String, String> error = new HashMap<String, String>();
		error.put("errorCode", errorCode);
		error.put("errorSub", Configuration.ErrorCodes.valueOf(errorCode).getSubtitleKor());
		modelAndView.addObject("error", error);
		modelAndView.setViewName("admin/createSubject");
		return modelAndView;
		
	}
}
