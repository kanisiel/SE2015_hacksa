package kr.ac.mju.service;

import java.sql.SQLException;

import javax.annotation.Resource;

import kr.ac.mju.Dao.DepartmentDao;
import kr.ac.mju.Dao.UserDao;
import kr.ac.mju.model.DepartmentInfo;
import kr.ac.mju.model.LoginInfo;
import kr.ac.mju.model.UserInfo;

import org.springframework.stereotype.Service;

import com.ibatis.sqlmap.engine.execution.SqlExecutor;

@Service
public class LoginService {
	
	@Resource(name="userDao")
	private UserDao userDao;
	
	@Resource(name="departmentDao")
	private DepartmentDao departmentDao;
	
	public UserInfo login(LoginInfo loginInfo) throws SQLException{
		return userDao.login(loginInfo);
	}
	
	public DepartmentInfo getList() throws SQLException {
		return departmentDao.getList();
	}
}
