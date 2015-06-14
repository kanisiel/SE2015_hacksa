package kr.ac.mju.mapper;

import java.sql.SQLException;

import kr.ac.mju.model.CourseInfo;

public interface CourseMapper {
	public CourseInfo listAll() throws SQLException;
	public CourseInfo listCollegeCourse(int college) throws SQLException;
	public CourseInfo listDeptCourse(int dept) throws SQLException;
	public void create(CourseInfo course) throws SQLException;
}
