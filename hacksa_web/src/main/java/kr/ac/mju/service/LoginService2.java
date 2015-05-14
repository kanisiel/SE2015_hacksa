package kr.ac.mju.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kr.ac.mju.model.User;
import kr.ac.mju.model.UserInfo;

import org.springframework.stereotype.Service;

@Service
public class LoginService2 {
	
	private final static String URL = "jdbc:mysql://localhost:3306/lms";
	private final static String ID = "sogong";
	private final static String PASSWORD = "mju12345";
	
	private Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL, ID, PASSWORD);
	}
	
	private void closeConnection(Connection connection, Statement statement, ResultSet resultSet) throws SQLException{
		if(connection == null){
			return;
		}
		connection.close();
		statement.close();
		resultSet.close();
	}
	public void createAccount() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = null;
		PreparedStatement statement = null;
		connection = DriverManager.getConnection(URL, ID, PASSWORD);
		String accountSQL = "Grant all privileges on *.* to sogong2@localhost"
							+" identified by 'mju12345' with grant option";
		statement = connection.prepareStatement(accountSQL);
		statement.executeUpdate();
		statement.close();
		System.out.println("계정 생성");
	}
	
	public UserInfo login(String userID, String userPassword) throws ClassNotFoundException, SQLException{
		
		//dao 호출
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String sql = "select * from user where id=? and password=?";
		UserInfo userInfo = null;
		
		connection = getConnection();
		statement = connection.prepareStatement(sql);
		statement.setString(1, userID);
		statement.setString(2, userPassword);
		resultSet = statement.executeQuery();
		while(resultSet.next()){
			String id = resultSet.getString("id");
			String password = resultSet.getString("password");
			
			if(id.equals(userID) && password.equals(userPassword)){
				userInfo = new UserInfo();
				userInfo.setUserId(id);
				userInfo.setUserName(resultSet.getString("name"));
				userInfo.setUserPassword(password);
				userInfo.setErrorCode("Success");
				closeConnection(connection, statement, resultSet);
				return userInfo;
			}
		}
		closeConnection(connection, statement, resultSet);
		return null;
	}

}
