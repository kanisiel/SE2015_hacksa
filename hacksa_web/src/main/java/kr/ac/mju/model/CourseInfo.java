package kr.ac.mju.model;

import java.util.List;
import java.util.Vector;

public class CourseInfo implements Info {
	
	private List<Course> list;
	private String errorCode;
	private String subscribe_kor;
	
	public CourseInfo() {
		this.list = new Vector<Course>();
		errorCode = null;
	}
	public List<Course> getList() {
		return list;
	}
	public void setList(List<Course> list) {
		this.list = list;
	}
	public void addGangjwa(Course course){
		this.list.add(course);
	}
	public Course getGangjwa(int index){
		return this.list.get(index);
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
