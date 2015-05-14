package kr.ac.mju.mapper;

import java.sql.SQLException;
import java.util.List;

import kr.ac.mju.model.Department;

public interface DepartmentMapper {
	public List<Department> listAll() throws SQLException;
	public Department getDept(int idx) throws SQLException;
//	public void create(Subject subject) throws SQLException;
//	public void update(Subject newOne) throws SQLException;
}
