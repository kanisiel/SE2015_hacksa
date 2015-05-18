package kr.ac.mju.mapper;

import java.sql.SQLException;
import java.util.List;

import kr.ac.mju.model.Subject;

public interface SubjectMapper {
	public List<Subject> listAll() throws SQLException;
	public Subject getSubject(int sid) throws SQLException;
	public void create(Subject subject) throws SQLException;
	public void update(Subject newOne) throws SQLException;
}
