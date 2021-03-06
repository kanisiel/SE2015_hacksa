package kr.ac.mju.Dao;

import java.sql.SQLException;
import java.util.List;

import kr.ac.mju.Conf.Configuration;
import kr.ac.mju.mapper.DepartmentMapper;
import kr.ac.mju.model.Department;
import kr.ac.mju.model.DepartmentInfo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDao implements Dao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public DepartmentInfo getList() throws SQLException{
		DepartmentInfo departmentInfo;
		DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
		
		if(departmentMapper!=null){
			List<Department> departmentList = departmentMapper.listAll();
			if(departmentList == null){
				departmentInfo = new DepartmentInfo();
				departmentInfo.setErrorCode(Configuration.ErrorCodes.ER1001.getCodeName());
				departmentInfo.setSubscribe_kor(Configuration.ErrorCodes.ER1001.getSubtitleKor());
				return departmentInfo;
			} else {
				departmentInfo = new DepartmentInfo();
				departmentInfo.setList(departmentList);
				departmentInfo.setErrorCode(Configuration.ErrorCodes.Success.getCodeName());
				departmentInfo.setSubscribe_kor(Configuration.ErrorCodes.Success.getSubtitleKor());
				return departmentInfo;
			}
		} else {
			departmentInfo = new DepartmentInfo();
			departmentInfo.setErrorCode(Configuration.ErrorCodes.ER0000.getCodeName());
			departmentInfo.setSubscribe_kor(Configuration.ErrorCodes.ER0000.getSubtitleKor());
			return departmentInfo;
		}
	}
	public Department getDept(int idx) throws SQLException{
		Department department;
		DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
		if(departmentMapper!=null){
			department = departmentMapper.getDept(idx);
			if(department == null){
				department = new Department();
				department.setErrorCode(Configuration.ErrorCodes.ER1001.getCodeName());
				department.setSubscribe_kor(Configuration.ErrorCodes.ER1001.getSubtitleKor());
				return department;
			} else {
				department.setErrorCode(Configuration.ErrorCodes.Success.getCodeName());
				department.setSubscribe_kor(Configuration.ErrorCodes.Success.getSubtitleKor());
				return department;
			}
		} else {
			department = new Department();
			department.setErrorCode(Configuration.ErrorCodes.ER0000.getCodeName());
			department.setSubscribe_kor(Configuration.ErrorCodes.ER0000.getSubtitleKor());
			return department;
		}
	}
}
