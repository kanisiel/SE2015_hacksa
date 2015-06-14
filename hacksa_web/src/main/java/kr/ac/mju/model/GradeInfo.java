package kr.ac.mju.model;

import java.util.List;

public class GradeInfo implements Info {

	private List<Grade> list;
	private String errorCode;
	private String subscribe_kor;
	
	public List<Grade> getList() {
		return list;
	}
	public void setList(List<Grade> list) {
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
