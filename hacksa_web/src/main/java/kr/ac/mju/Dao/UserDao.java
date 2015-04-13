package kr.ac.mju.Dao;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.springframework.stereotype.Repository;
import kr.ac.mju.model.LoginInfo;
import kr.ac.mju.model.UserInfo;

@Repository
public class UserDao implements Dao {

	public UserInfo login(LoginInfo loginInfo){
		
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
						userInfo.setName(userData[2]);
						scanner.close();
						return userInfo;
					} else {
						userInfo.setErrorCode("ER:1002");
					}
				} else {
					userInfo.setErrorCode("ER:1001");
				}
				
			}
		 	scanner.close();
			return userInfo;
		} catch (IOException e) {
			e.printStackTrace();
			userInfo.setErrorCode("ER:1000");
			return userInfo;
		}
	}
}
