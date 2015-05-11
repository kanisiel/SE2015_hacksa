package kr.ac.mju.service;

import javax.annotation.Resource;

import kr.ac.mju.Dao.CourseDao;
import kr.ac.mju.Dao.GwamokDao;
import kr.ac.mju.model.CourseInfo;
import kr.ac.mju.model.SubjectInfo;
import org.springframework.stereotype.Service;

@Service
public class SugangService {
	
	@Resource(name="gwamokDao")
	private GwamokDao gwamokDao;
	
	@Resource(name="courseDao")
	private CourseDao courseDao;
	
	public SubjectInfo getGwamoks(){
		return gwamokDao.getList();
	}
	
	public CourseInfo getAllCourse(){
		return courseDao.getAllCourse();
	}
	public CourseInfo getCollegeCourse(int college){
		return courseDao.getCollegeCourse(college);
	}
	
}
