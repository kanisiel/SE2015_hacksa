package kr.ac.mju.model;

import java.io.Serializable;

public class CMember implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String ID;
	private String password;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
}
