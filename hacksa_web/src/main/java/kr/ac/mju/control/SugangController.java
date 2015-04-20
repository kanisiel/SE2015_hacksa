package kr.ac.mju.control;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import kr.ac.mju.Conf.Configuration.ErrorCodes;
import kr.ac.mju.model.Gangjwa;
import kr.ac.mju.model.GangjwaInfo;
import kr.ac.mju.model.Gwamok;
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
	
private static final Logger logger = LoggerFactory.getLogger(SugangController.class);
	
	@Autowired
	SugangService sugangService;
	
	
	ModelAndView modelAndView = new ModelAndView();
	
	@RequestMapping(value = "/sugangController/gwamokList", method = RequestMethod.GET)
	public ModelAndView gwamokList(HttpServletRequest request, RedirectAttributes redir) throws UnsupportedEncodingException {

		request.setCharacterEncoding("UTF-8");
		GwamokInfo gwamokInfo = sugangService.getGwamoks();
		request.getSession().setAttribute("userInfo",request.getSession().getAttribute("userInfo"));

		logger.info("에러코드 :" + gwamokInfo.getErrorCode());
		if(gwamokInfo.getErrorCode().equals("Success")){
			request.getSession().setAttribute("gwamokInfo", gwamokInfo);
			modelAndView.setViewName("gwamok");
			redir.addFlashAttribute("Info", gwamokInfo);
			return modelAndView;
		} else {
			ErrorCodes errorCodes = ErrorCodes.valueOf(gwamokInfo.getErrorCode());
			request.getSession().setAttribute("gwamokInfo", errorCodes);
			modelAndView.setViewName("sugang");
			return modelAndView;
		}
	}
	@RequestMapping(value = "/sugangController/gangjwaList", method = RequestMethod.GET)
	public ModelAndView gangjwaList(HttpServletRequest request, RedirectAttributes redir) throws UnsupportedEncodingException {

		request.setCharacterEncoding("UTF-8");
		GangjwaInfo gangjwaInfo = sugangService.getGangjwas();
		request.getSession().setAttribute("userInfo",request.getSession().getAttribute("userInfo"));

		logger.info("에러코드 :" + gangjwaInfo.getErrorCode());
		if(gangjwaInfo.getErrorCode().equals("Success")){
			request.getSession().setAttribute("gangjwaInfo", gangjwaInfo);
			modelAndView.setViewName("gangjwa");
			redir.addFlashAttribute("Info", gangjwaInfo);
			return modelAndView;
		} else {
			ErrorCodes errorCodes = ErrorCodes.valueOf(gangjwaInfo.getErrorCode());
			request.getSession().setAttribute("gangjwaInfo", errorCodes);
			modelAndView.setViewName("sugang");
			return modelAndView;
		}
	}
	/*@RequestMapping(value = "/sugangController/gaeseol", method = RequestMethod.POST)
	public ModelAndView gaeseol(HttpServletRequest request, RedirectAttributes redir) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		//logger.info("에러코드 :" + gwamokInfo.getErrorCode());
		String gwamokID = request.getParameter("gwamokID");
		Gwamok gwamok = null;
		String gangjwa_id = null;
		
		if(gwamokID.isEmpty()){
			redir.addFlashAttribute("userInfo", request.getSession().getAttribute("userInfo"));
			modelAndView.setViewName("redirect:/sugangController/gwamokList");
			return modelAndView;
		} else {
			GwamokInfo gwamokInfo = (GwamokInfo) request.getSession().getAttribute("gwamokInfo");
			for(Gwamok g : gwamokInfo.getList()){
				if(g.getGwamok_id() == Integer.parseInt(gwamokID)){
					 gwamok = g;
				}
			}
			GangjwaInfo gangjwaInfo = sugangService.getGangjwas();
			if(gangjwaInfo.getList().isEmpty()){
				gangjwa_id = gwamok.getGwamok_id()+"01";
			} else {
				for(Gangjwa g : gangjwaInfo.getList()){
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
