package kr.ac.mju.service;

import java.sql.SQLException;

import javax.annotation.Resource;

import kr.ac.mju.Dao.CourseDao;
import kr.ac.mju.Dao.GradeDao;
import kr.ac.mju.Dao.SugangDao;
import kr.ac.mju.Dao.UserDao;
import kr.ac.mju.model.Course;
import kr.ac.mju.model.CourseInfo;
import kr.ac.mju.model.Grade;
import kr.ac.mju.model.GradeInfo;
import kr.ac.mju.model.Sugang;
import kr.ac.mju.model.SugangInfo;
import kr.ac.mju.model.UserInfo;

import org.springframework.stereotype.Service;

@Service
public class SugangService {
	
	@Resource(name="userDao")
	private UserDao userDao;
	@Resource(name="courseDao")
	private CourseDao courseDao;
	@Resource(name="sugangDao")
	private SugangDao sugangDao;
	@Resource(name="gradeDao")
	private GradeDao gradeDao;
	
	public UserInfo getUser(int uidx) throws SQLException{
		return userDao.getUser(uidx);
	}
	public Course getCourse(int cid) throws SQLException{
		return courseDao.getCourse(cid).getList().get(0);
	}
	public CourseInfo getAllCourse() throws SQLException{
		return courseDao.getAllCourse();
	}
	public CourseInfo getCollegeCourse(int college){
		return courseDao.getCollegeCourse(college);
	}
	public Grade getGrade(int idx) throws SQLException{
		return gradeDao.getGrade(idx);
	}
	public GradeInfo getAllGrade() throws SQLException{
		return gradeDao.getList();
	}
	public String register(Sugang sugang) throws SQLException{
		return sugangDao.register(sugang);
	}
	public String setGrade(Sugang sugang) throws SQLException{
		return sugangDao.setGrade(sugang);
	}
	public SugangInfo getCList(Course course) throws SQLException{
		SugangInfo sugangInfo = sugangDao.getCList(course);
		for(Sugang sugang : sugangInfo.getList()){
			sugang.setGrade_en(getGrade(sugang.getGrade()).getLetter());
			sugang.setCourse(course);
			sugang.setUserInfo(getUser(sugang.getUidx()));
		}
		return sugangInfo;
	}
	public SugangInfo getRegList(UserInfo userInfo) throws SQLException{
		SugangInfo sugangInfo = sugangDao.getRegList(userInfo);
		for(Sugang sugang : sugangInfo.getList()){
			sugang.setGrade_en(getGrade(sugang.getGrade()).getLetter());
			sugang.setCourse(getCourse(sugang.getCid()));
			sugang.setUserInfo(userInfo);
		}
		return sugangInfo;
	}
}
