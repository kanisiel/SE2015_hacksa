package kr.ac.mju.model;

import java.util.Vector;

public class SubjectInfo implements Info {

	private Vector<Subject> list;
	private String errorCode;
	private String subscribe_kor;
	
	public SubjectInfo() {
		this.list = new Vector<Subject>();
		errorCode = null;
	}
	public void addGwamok(Subject subject){
		this.list.add(subject);
	}
	public Subject getGwamok(int index){
		return this.list.get(index);
	}
	public Vector<Subject> getList(){
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
