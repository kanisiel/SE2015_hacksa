package kr.ac.mju.service;

import java.sql.SQLException;

import javax.annotation.Resource;

import kr.ac.mju.Dao.CourseDao;
import kr.ac.mju.Dao.SubjectDao;
import kr.ac.mju.model.Subject;
import kr.ac.mju.model.SubjectInfo;

public class ProfService {
	
	@Resource(name="courseDao")
	private CourseDao courseDao;
	@Resource(name="subjectDao")
	private SubjectDao subjectDao;
	
	public SubjectInfo getList() throws SQLException{
		SubjectInfo subjectInfo = subjectDao.getList();
		System.out.println(subjectInfo.getErrorCode());
		return subjectInfo;
	}
	public String createCourse(Subject subject) throws SQLException{
		return courseDao.createCourse(subject);
	}
}
