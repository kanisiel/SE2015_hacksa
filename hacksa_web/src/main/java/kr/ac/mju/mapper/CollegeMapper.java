package kr.ac.mju.mapper;

import java.sql.SQLException;
import java.util.List;

import kr.ac.mju.model.College;

public interface CollegeMapper {
	public List<College> listAll() throws SQLException;
	public College getCollege(int idx) throws SQLException;
//	public void create(Subject subject) throws SQLException;
//	public void update(Subject newOne) throws SQLException;
}
