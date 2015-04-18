package kr.ac.mju.model;

import java.util.Vector;

public class GangjwaInfo implements Info {
	private Vector<Gangjwa> list;
	private String errorCode;
	
	public void setList(Vector<Gangjwa> list) {
		this.list = list;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public void addGangjwa(Gangjwa gangjwa){
		this.list.add(gangjwa);
	}
	public Gangjwa getGangjwa(int index){
		return this.list.get(index);
	}
	public Vector<Gangjwa> getList(){
		return this.list;
	}
}
