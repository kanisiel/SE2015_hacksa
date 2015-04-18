package kr.ac.mju.model;

import kr.ac.mju.Conf.*;
import kr.ac.mju.Conf.Configuration.ErrorCodes;
public class UserInfo implements Info {
	
	private String errorCode;
	private String userId;
	private String userPassword;
	private String name;
	private int userType;
	
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
		
}
