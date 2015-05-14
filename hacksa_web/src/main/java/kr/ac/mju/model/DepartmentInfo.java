package kr.ac.mju.model;

import java.util.List;
import java.util.Vector;

public class DepartmentInfo implements Info {

	private List<Department> list;
	private String errorCode;
	private String subscribe_kor;
	
	public DepartmentInfo() {
		this.setList(new Vector<Department>());
		setErrorCode(null);
	}

	public List<Department> getList() {
		return list;
	}

	public void setList(List<Department> list) {
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
