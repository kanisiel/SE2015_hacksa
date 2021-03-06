package kr.ac.mju.model;

import java.util.List;
import java.util.Vector;

public class SubjectInfo implements Info {

	private List<Subject> list;
	private String errorCode;
	private String subscribe_kor;
	
	public SubjectInfo() {
		this.list = new Vector<Subject>();
		errorCode = null;
	}
	public void setList(List<Subject> list){
		this.list = list;
	}
	public List<Subject> getList(){
		return this.list;
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
