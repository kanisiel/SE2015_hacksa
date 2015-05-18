package kr.ac.mju.model;

import java.util.List;
import java.util.Vector;

public class CollegeInfo implements Info {

	private List<College> list;
	private String errorCode;
	private String subscribe_kor;
	
	public CollegeInfo() {
		this.setList(new Vector<College>());
		setErrorCode(null);
	}

	public List<College> getList() {
		return list;
	}

	public void setList(List<College> list) {
		this.list = list;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getSubscribe_kor() {
		return subscribe_kor;
	}

	public void setSubscribe_kor(String subscribe_kor) {
		this.subscribe_kor = subscribe_kor;
	}
	
	
}
