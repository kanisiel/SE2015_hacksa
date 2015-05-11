package kr.ac.mju.model;

import java.util.Vector;

public class CourseInfo implements Info {
	
	private Vector<Course> list;
	private String errorCode;
	
	public CourseInfo() {
		this.list = new Vector<Course>();
		errorCode = null;
	}
	public void addGangjwa(Course course){
		this.list.add(course);
	}
	public Course getGangjwa(int index){
		return this.list.get(index);
	}
	public Vector<Course> getList(){
		return this.list;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
