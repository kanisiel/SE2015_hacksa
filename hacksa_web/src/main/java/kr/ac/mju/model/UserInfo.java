package kr.ac.mju.model;

public class UserInfo implements Info {
	
	private String errorCode;
	private String subscribe_kor;
	private String uIdx;
	private String userId;
	private String userPassword;
	private String userName;
	private int userType;
	
	public UserInfo() {	}
	
	public UserInfo(String uIdx, String userId, String userPassword,
			String userName, int userType) {
		super();
		this.uIdx = uIdx;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userType = userType;
	}

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
	public String getUIdx() {
		return uIdx;
	}
	public void setUIdx(String uIdx) {
		this.uIdx = uIdx;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getSubscribe_kor() {
		return subscribe_kor;
	}
	public void setSubscribe_kor(String subscribe_kor) {
		this.subscribe_kor = subscribe_kor;
	}
		
}
