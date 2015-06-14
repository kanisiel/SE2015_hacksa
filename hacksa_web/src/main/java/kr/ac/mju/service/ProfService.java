package kr.ac.mju.service;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.ac.mju.Dao.CollegeDao;
import kr.ac.mju.Dao.CourseDao;
import kr.ac.mju.Dao.DepartmentDao;
import kr.ac.mju.Dao.SubjectDao;
import kr.ac.mju.model.College;
import kr.ac.mju.model.Course;
import kr.ac.mju.model.CourseInfo;
import kr.ac.mju.model.Department;
import kr.ac.mju.model.SubjectInfo;
@Service
public class ProfService {
	
	@Resource(name="courseDao")
	private CourseDao courseDao;
	@Resource(name="subjectDao")
	private SubjectDao subjectDao;
	@Resource(name="departmentDao")
	private DepartmentDao departmentDao;
	@Resource(name="collegeDao")
	private CollegeDao collegeDao;

	public SubjectInfo getSList() throws SQLException{
		SubjectInfo subjectInfo = subjectDao.getList();
		System.out.println(subjectInfo.getErrorCode());
		return subjectInfo;
	}
	public CourseInfo getCList() throws SQLException{
		CourseInfo courseInfo = courseDao.getAllCourse();
		System.out.println(courseInfo.getErrorCode());
		return courseInfo;
	}
	public CourseInfo getCList(int instructor) throws SQLException{
		CourseInfo courseInfo = courseDao.listInstructor(instructor);
		System.out.println(courseInfo.getErrorCode());
		return courseInfo;
	}
	public String createCourse(Course course) throws SQLException{
		return courseDao.createCourse(course);
	}
	public Department getDept(int idx) throws SQLException {
		return departmentDao.getDept(idx);
	}
	
	public College getCollege(int idx) throws SQLException {
		return collegeDao.getCollege(idx);
	}
}
