package kr.ac.mju.model;

import java.util.Vector;

public class SubjectInfo implements Info {

	private Vector<Subject> list;
	private String errorCode;
	
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
	
	
}
