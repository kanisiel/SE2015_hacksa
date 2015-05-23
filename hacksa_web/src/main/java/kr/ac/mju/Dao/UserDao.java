package kr.ac.mju.Dao;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.mju.Conf.*;
import kr.ac.mju.mapper.UserMapper;
import kr.ac.mju.model.LoginInfo;
import kr.ac.mju.model.UserInfo;

@Repository
public class UserDao implements Dao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public UserInfo login(LoginInfo loginInfo) throws SQLException{
		UserInfo userInfo;
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		if(userMapper!=null){
			System.out.println(loginInfo.getUserId()+" / "+loginInfo.getUserPassword());
			userInfo = userMapper.getData(loginInfo);
			if(userInfo == null){
				userInfo = new UserInfo();
				userInfo.setErrorCode(Configuration.ErrorCodes.ER1001.getCodeName());
				userInfo.setSubscribe_kor(Configuration.ErrorCodes.ER1001.getSubtitleKor());
				return userInfo;
			} else {
				userInfo.setErrorCode(Configuration.ErrorCodes.Success.getCodeName());
				userInfo.setSubscribe_kor(Configuration.ErrorCodes.Success.getSubtitleKor());
				return userInfo;
			}
		} else {
			userInfo = new UserInfo();
			userInfo.setErrorCode(Configuration.ErrorCodes.ER0000.getCodeName());
			userInfo.setSubscribe_kor(Configuration.ErrorCodes.ER0000.getSubtitleKor());
			return userInfo;
		}
		
	}
	public UserInfo login_file(LoginInfo loginInfo){
		
		String[] userData;
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("UserDB.txt").getFile());
		UserInfo userInfo = new UserInfo();
		
		try (Scanner scanner = new Scanner(file)){
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				userData = line.split("\t");
				if(loginInfo.getUserId().equals(userData[0])){
					if(loginInfo.getUserPassword().equals(userData[1])){
						userInfo.setErrorCode("Success");
						userInfo.setUserId(userData[0]);
						userInfo.setUserPassword(userData[1]);
						userInfo.setUserName(userData[2]);
						userInfo.setUserType(Integer.parseInt(userData[3]));
						scanner.close();
						return userInfo;
					} else {
						userInfo.setErrorCode("ER1002");
					 	scanner.close();
						return userInfo;
					}
				} else {
					userInfo.setErrorCode("ER1001");
				}
				
			}
		 	scanner.close();
			return userInfo;
		} catch (IOException e) {
			e.printStackTrace();
			userInfo.setErrorCode("ER1000");
			return userInfo;
		}
	}
	public boolean createAccount(UserInfo userInfo) {
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		if(userMapper!=null){
			try{
				userMapper.createAccount(userInfo);
				return true;
			}catch(Exception e){
				return false;
			}
		}
		return false;
	}
}
