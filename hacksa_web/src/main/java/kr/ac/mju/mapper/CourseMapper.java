package kr.ac.mju.mapper;

import java.sql.SQLException;
import java.util.List;

import kr.ac.mju.model.Course;
import kr.ac.mju.model.CourseInfo;

public interface CourseMapper {
	public List<Course> listAll() throws SQLException;
	public List<Course> getCourse(int cid) throws SQLException;
	public List<Course> listInstructor(int instructor) throws SQLException;
	public CourseInfo listCollegeCourse(int college) throws SQLException;
	public CourseInfo listDeptCourse(int dept) throws SQLException;
	public void create(Course course) throws SQLException;
	public void update(Course newOne) throws SQLException;
}
