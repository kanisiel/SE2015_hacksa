package kr.ac.mju.control;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.Conf.Configuration;
import kr.ac.mju.Conf.Configuration.ErrorCodes;
import kr.ac.mju.model.CourseInfo;
import kr.ac.mju.model.Sugang;
import kr.ac.mju.model.SugangInfo;
import kr.ac.mju.model.UserInfo;
import kr.ac.mju.service.SugangService;

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
public class SugangController {
	
private static final Logger logger = LoggerFactory.getLogger(SugangController.class);
	
	@Autowired
	SugangService sugangService;
	
	@ModelAttribute("userInfo")  
    public UserInfo userInfo() {  
        return new UserInfo();  
    } 
	
	ModelAndView modelAndView;
	
	
	@RequestMapping(value = "/sugangController/register", method = RequestMethod.GET)
	public ModelAndView courseList(@ModelAttribute("userInfo") UserInfo userInfo,HttpServletRequest request) throws UnsupportedEncodingException, SQLException {
		modelAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		CourseInfo courseInfo = sugangService.getAllCourse();
		request.getSession().setAttribute("userInfo",request.getSession().getAttribute("userInfo"));

		logger.info("에러코드 :" + courseInfo.getErrorCode());
		if(courseInfo.getErrorCode().equals("Success")){
			modelAndView.addObject("courseInfo", courseInfo);
			modelAndView.setViewName("student/course");
			return modelAndView;
		} else {
			ErrorCodes errorCodes = ErrorCodes.valueOf(courseInfo.getErrorCode());
			modelAndView.addObject("courseInfo", errorCodes);
			modelAndView.setViewName("logged");
			return modelAndView;
		}
	}
	@RequestMapping(value = "/sugangController/grade", method = RequestMethod.GET)
	public ModelAndView showGrade(@ModelAttribute("userInfo") UserInfo userInfo,HttpServletRequest request) throws UnsupportedEncodingException, SQLException {
		modelAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		SugangInfo sugangInfo = sugangService.getRegList(userInfo);
		request.getSession().setAttribute("userInfo",request.getSession().getAttribute("userInfo"));
		
		logger.info("에러코드 :" + sugangInfo.getErrorCode());
		if(sugangInfo.getErrorCode().equals("Success")){
			modelAndView.addObject("sugangInfo", sugangInfo);
			modelAndView.setViewName("student/reglist");
			return modelAndView;
		} else {
			ErrorCodes errorCodes = ErrorCodes.valueOf(sugangInfo.getErrorCode());
			modelAndView.addObject("sugangInfo", errorCodes);
			modelAndView.setViewName("logged");
			return modelAndView;
		}
	}
	@RequestMapping(value = "/sugangController/register.do", method = RequestMethod.POST)
	public ModelAndView createSubjectQuery(@ModelAttribute("userInfo") UserInfo userInfo, HttpServletRequest request) throws UnsupportedEncodingException, SQLException {
		modelAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
	  
	    @SuppressWarnings("unchecked")
		Map<String, String[]> map = request.getParameterMap(); 
		
		int cid = Integer.parseInt(map.get("CID")[0]);
		int uidx = userInfo.getUIdx();
		Sugang sugang = new Sugang(uidx, cid);
		String errorCode = sugangService.register(sugang);
		if(errorCode == "Success"){
			return courseList(userInfo, request);
		} else{
			Map<String, String> error = new HashMap<String, String>();
			error.put("errorCode", errorCode);
			error.put("errorSub", Configuration.ErrorCodes.valueOf(errorCode).getSubtitleKor());
			modelAndView.addObject("error", error);
			modelAndView.setViewName("student/course");
			return modelAndView;
		}
		
	}
}
