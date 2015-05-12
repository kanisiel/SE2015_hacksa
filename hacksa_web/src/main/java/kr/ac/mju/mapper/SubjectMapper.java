package kr.ac.mju.mapper;

import java.sql.SQLException;

import kr.ac.mju.model.Subject;
import kr.ac.mju.model.SubjectInfo;

public interface SubjectMapper {
	public SubjectInfo listAll() throws SQLException;
	public Subject getSubject(int sid) throws SQLException;
	public void create(Subject subject) throws SQLException;
	public void update(Subject newOne) throws SQLException;
}
