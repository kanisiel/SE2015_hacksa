package kr.ac.mju.service;

import java.sql.SQLException;

import javax.annotation.Resource;

import kr.ac.mju.Dao.CourseDao;
import kr.ac.mju.Dao.SubjectDao;
import kr.ac.mju.model.CourseInfo;
import kr.ac.mju.model.Subject;
import kr.ac.mju.model.SubjectInfo;

import org.springframework.stereotype.Service;

@Service
public class SugangService {
	
	
	@Resource(name="courseDao")
	private CourseDao courseDao;
	
	public CourseInfo getAllCourse(){
		return courseDao.getAllCourse();
	}
	public CourseInfo getCollegeCourse(int college){
		return courseDao.getCollegeCourse(college);
	}
	
}
