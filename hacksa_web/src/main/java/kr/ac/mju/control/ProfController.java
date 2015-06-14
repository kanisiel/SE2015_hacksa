package kr.ac.mju.control;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.Conf.Configuration;
import kr.ac.mju.Conf.Configuration.ErrorCodes;
import kr.ac.mju.model.College;
import kr.ac.mju.model.Course;
import kr.ac.mju.model.CourseInfo;
import kr.ac.mju.model.Department;
import kr.ac.mju.model.GradeInfo;
import kr.ac.mju.model.Subject;
import kr.ac.mju.model.SubjectInfo;
import kr.ac.mju.model.Sugang;
import kr.ac.mju.model.SugangInfo;
import kr.ac.mju.model.UserInfo;
import kr.ac.mju.service.ProfService;
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
public class ProfController {

	private static final Logger logger = LoggerFactory.getLogger(ProfController.class);
	
	@Autowired
	ProfService profService;
	@Autowired
	SugangService sugangService;
	
	@ModelAttribute("userInfo")  
    public UserInfo userInfo() {  
        return new UserInfo();  
    }

	ModelAndView modelAndView;
	
	@RequestMapping(value = "/profController/subjectList", method = RequestMethod.GET)
	public ModelAndView subjectList(@ModelAttribute("userInfo") UserInfo userInfo, HttpServletRequest request) throws UnsupportedEncodingException, SQLException {
		modelAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		SubjectInfo subjectInfo = profService.getSList();
		modelAndView.addObject("userInfo",request.getSession().getAttribute("userInfo"));

		logger.info("에러코드 :" + subjectInfo.getErrorCode());
		if(subjectInfo.getErrorCode().equals("Success")){
			modelAndView.addObject("subjectInfo", subjectInfo);
			modelAndView.setViewName("prof/subjectlist");
			return modelAndView;
		} else {
			ErrorCodes errorCodes = ErrorCodes.valueOf(subjectInfo.getErrorCode());
			request.getSession().setAttribute("subjectInfo", errorCodes);
			modelAndView.setViewName("logged");
			return modelAndView;
		}
	}
	@RequestMapping(value = "/profController/courseList", method = RequestMethod.GET)
	public ModelAndView courseList(@ModelAttribute("userInfo") UserInfo userInfo, HttpServletRequest request) throws UnsupportedEncodingException, SQLException {
		modelAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		CourseInfo courseInfo = profService.getCList(userInfo.getUIdx());
		modelAndView.addObject("userInfo",request.getSession().getAttribute("userInfo"));

		logger.info("에러코드 :" + courseInfo.getErrorCode());
		if(courseInfo.getErrorCode().equals("Success")){
			modelAndView.addObject("courseInfo", courseInfo);
			modelAndView.setViewName("prof/courselist");
			return modelAndView;
		} else {
			ErrorCodes errorCodes = ErrorCodes.valueOf(courseInfo.getErrorCode());
			request.getSession().setAttribute("courseInfo", errorCodes);
			modelAndView.setViewName("logged");
			return modelAndView;
		}
	}
	@RequestMapping(value = "/profController/setGrade", method = RequestMethod.POST)
	public ModelAndView setGrade(@ModelAttribute("userInfo") UserInfo userInfo, HttpServletRequest request) throws UnsupportedEncodingException, SQLException {
		modelAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		
		@SuppressWarnings("unchecked")
		Map<String, String[]> map = request.getParameterMap(); 
		String cid = map.get("CID")[0];
		Course course = sugangService.getCourse(Integer.parseInt(cid)).clone();
		SugangInfo sugangInfo = sugangService.getCList(course);
		modelAndView.addObject("userInfo",request.getSession().getAttribute("userInfo"));

		logger.info("에러코드 :" + sugangInfo.getErrorCode());
		if(sugangInfo.getErrorCode().equals("Success")){
			GradeInfo gradeInfo = sugangService.getAllGrade();
			modelAndView.addObject("gradeInfo", gradeInfo);
			modelAndView.addObject("sugangInfo", sugangInfo);
			modelAndView.setViewName("prof/setgrade");
			return modelAndView;
		} else {
			ErrorCodes errorCodes = ErrorCodes.valueOf(sugangInfo.getErrorCode());
			request.getSession().setAttribute("sugangInfo", errorCodes);
			modelAndView.setViewName("logged");
			return modelAndView;
		}
	}
	@RequestMapping(value = "/profController/setGrade.do", method = RequestMethod.POST)
	public ModelAndView setGradeDo(@ModelAttribute("userInfo") UserInfo userInfo, HttpServletRequest request) throws UnsupportedEncodingException, SQLException {
		modelAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		
		@SuppressWarnings("unchecked")
		Map<String, String[]> map = request.getParameterMap(); 
		String score = map.get("SCORE")[0];
		String idx = map.get("IDX")[0];
		Sugang sugang = new Sugang();
		sugang.setIdx(Integer.parseInt(idx));
		sugang.setGrade(Integer.parseInt(score));
		String errorCode = sugangService.setGrade(sugang);
		modelAndView.addObject("userInfo",request.getSession().getAttribute("userInfo"));
		if(errorCode == "Success"){
			return courseList(userInfo, request);
		} else{
			Map<String, String> error = new HashMap<String, String>();
			error.put("errorCode", errorCode);
			error.put("errorSub", Configuration.ErrorCodes.valueOf(errorCode).getSubtitleKor());
			modelAndView.addObject("error", error);
			modelAndView.setViewName("prof/setgrade");
			return modelAndView;
		}
	}
	@RequestMapping(value = "/profController/createCourse", method = RequestMethod.POST)
	public ModelAndView createSubject(@ModelAttribute("userInfo") UserInfo userInfo, HttpServletRequest request) throws UnsupportedEncodingException, SQLException {
		modelAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		//request.getSession().setAttribute("userInfo",request.getSession().getAttribute("userInfo"));
		String sid = request.getParameter("SID");
		String name = request.getParameter("NAME");
		String unit = request.getParameter("UNIT");
		Subject subject = new Subject(sid, name, Integer.parseInt(unit));
		Department dept = profService.getDept(userInfo.getDept());
		College college = profService.getCollege(userInfo.getCollege());
		request.getSession().setAttribute("subject",request.getSession().getAttribute("subject"));
		modelAndView.addObject("dept", dept);
		modelAndView.addObject("college", college);
		modelAndView.addObject("subject", subject);
		modelAndView.setViewName("prof/createCourse");
		return modelAndView;
	}
	@RequestMapping(value = "/profController/createCourse.do", method = RequestMethod.POST)
	public ModelAndView createSubjectQuery(@ModelAttribute("userInfo") UserInfo userInfo, HttpServletRequest request) throws UnsupportedEncodingException, SQLException {
		modelAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
	  
	    @SuppressWarnings("unchecked")
		Map<String, String[]> map = request.getParameterMap(); 
		String sid = map.get("sid")[0];
		String cid = map.get("cid")[0];
		String name = map.get("name")[0];
		int year = Integer.parseInt(map.get("year")[0]);
		int max = Integer.parseInt(map.get("max")[0]);
		int grade = Integer.parseInt(map.get("grade")[0]);
		int unit = Integer.parseInt(map.get("unit")[0]);
		System.out.println(userInfo.getUserName());
		Course course = new Course(sid, cid, name, userInfo.getUIdx(),userInfo.getUserName(), year, max, grade, unit, userInfo.getDept(), userInfo.getCollege());
		String errorCode = profService.createCourse(course);
		if(errorCode == "Success"){
			return subjectList(userInfo, request);
		} else{
			Map<String, String> error = new HashMap<String, String>();
			error.put("errorCode", errorCode);
			error.put("errorSub", Configuration.ErrorCodes.valueOf(errorCode).getSubtitleKor());
			modelAndView.addObject("error", error);
			modelAndView.setViewName("prof/subjectlist");
			return modelAndView;
		}
		
	}
}
