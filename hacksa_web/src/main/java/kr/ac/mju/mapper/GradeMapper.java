package kr.ac.mju.mapper;

import java.sql.SQLException;
import java.util.List;

import kr.ac.mju.model.Grade;

public interface GradeMapper {
	public Grade getGrade(int idx) throws SQLException;
	public List<Grade> getAll() throws SQLException;
}
