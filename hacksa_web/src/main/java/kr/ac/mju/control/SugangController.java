package kr.ac.mju.control;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.Conf.Configuration;
import kr.ac.mju.Conf.Configuration.ErrorCodes;
import kr.ac.mju.model.CourseInfo;
import kr.ac.mju.model.Subject;
import kr.ac.mju.model.SubjectInfo;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping(value = "/sugangController/createCourse", method = RequestMethod.GET)
	public ModelAndView createSubject(@ModelAttribute("userInfo") UserInfo userInfo, HttpServletRequest request) throws UnsupportedEncodingException {
		modelAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		request.getSession().setAttribute("userInfo",request.getSession().getAttribute("userInfo"));
		modelAndView.setViewName("createSubject");
		return modelAndView;
	}

	
	
	@RequestMapping(value = "/sugangController/createSubject", method = RequestMethod.POST)
	public ModelAndView createForm(@ModelAttribute("userInfo") UserInfo userInfo, HttpServletRequest request) throws UnsupportedEncodingException {
		modelAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		modelAndView.addObject("userInfo", userInfo);
		modelAndView.setViewName("createSubject");
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/sugangController/register", method = RequestMethod.GET)
	public ModelAndView courseList(HttpServletRequest request, RedirectAttributes redir) throws UnsupportedEncodingException {
		modelAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		CourseInfo courseInfo = sugangService.getAllCourse();
		request.getSession().setAttribute("userInfo",request.getSession().getAttribute("userInfo"));

		logger.info("에러코드 :" + courseInfo.getErrorCode());
		if(courseInfo.getErrorCode().equals("Success")){
			request.getSession().setAttribute("courseInfo", courseInfo);
			modelAndView.setViewName("course");
			redir.addFlashAttribute("Info", courseInfo);
			return modelAndView;
		} else {
			ErrorCodes errorCodes = ErrorCodes.valueOf(courseInfo.getErrorCode());
			request.getSession().setAttribute("courseInfo", errorCodes);
			modelAndView.setViewName("logged");
			return modelAndView;
		}
	}
	/*@RequestMapping(value = "/sugangController/gaeseol", method = RequestMethod.POST)
	public ModelAndView gaeseol(HttpServletRequest request, RedirectAttributes redir) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		//logger.info("에러코드 :" + gwamokInfo.getErrorCode());
		String gwamokID = request.getParameter("gwamokID");
		Subject gwamok = null;
		String gangjwa_id = null;
		
		if(gwamokID.isEmpty()){
			redir.addFlashAttribute("userInfo", request.getSession().getAttribute("userInfo"));
			modelAndView.setViewName("redirect:/sugangController/gwamokList");
			return modelAndView;
		} else {
			SubjectInfo gwamokInfo = (SubjectInfo) request.getSession().getAttribute("gwamokInfo");
			for(Subject g : gwamokInfo.getList()){
				if(g.getGwamok_id() == Integer.parseInt(gwamokID)){
					 gwamok = g;
				}
			}
			CourseInfo gangjwaInfo = sugangService.getGangjwas();
			if(gangjwaInfo.getList().isEmpty()){
				gangjwa_id = gwamok.getGwamok_id()+"01";
			} else {
				for(Course g : gangjwaInfo.getList()){
					//if(g.getGangjwa_id().contains(gwamokID)){
						
				//	}
				}
			}
			request.getSession().setAttribute("gangjwa_id", gangjwa_id);
			request.getSession().setAttribute("gwamok", gwamok);
			modelAndView.setViewName("gaeseol");
			return modelAndView;
		}
	}*/
}
