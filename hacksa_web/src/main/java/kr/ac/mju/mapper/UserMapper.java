package kr.ac.mju.mapper;

import java.sql.SQLException;

import kr.ac.mju.model.LoginInfo;
import kr.ac.mju.model.UserInfo;

public interface UserMapper {
//	 public List<User> selectAllUsers();  
//	 public User selectUser(String username);  
	 public UserInfo getData(LoginInfo loginInfo) throws SQLException;
//	 public void insertUser(User user);  
//	 public void updateUser(User user);  
//	 public void deleteUser(String username);
}
