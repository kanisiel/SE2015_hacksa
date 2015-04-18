package kr.ac.mju.service;

import javax.annotation.Resource;

import kr.ac.mju.Dao.GangjwaDao;
import kr.ac.mju.Dao.GwamokDao;
import kr.ac.mju.model.GangjwaInfo;
import kr.ac.mju.model.GwamokInfo;
import org.springframework.stereotype.Service;

@Service
public class SugangService {
	
	@Resource(name="gwamokDao")
	private GwamokDao gwamokDao;
	
	@Resource(name="gangjwaDao")
	private GangjwaDao gangjwaDao;
	
	public GwamokInfo getGwamoks(){
		return gwamokDao.getList();
	}
	
	public GangjwaInfo getGangjwas(){
		return gangjwaDao.getList();
	}
	
}
