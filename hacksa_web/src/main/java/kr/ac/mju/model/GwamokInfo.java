package kr.ac.mju.model;

import java.util.Vector;

public class GwamokInfo implements Info {

	private Vector<Gwamok> list;
	private String errorCode;
	
	public GwamokInfo() {
		this.list = new Vector<Gwamok>();
		errorCode = null;
	}
	public void addGwamok(Gwamok gwamok){
		this.list.add(gwamok);
	}
	public Gwamok getGwamok(int index){
		return this.list.get(index);
	}
	public Vector<Gwamok> getList(){
		return this.list;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
