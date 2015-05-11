package kr.ac.mju.model;

public class Course implements CEntity {

	private static final long serialVersionUID = 1L;
	private String gwamok_id;
	private String gangjwa_id;
	private String name;
	private String instructor;
	private int hackjeom;
	

	public String getGwamok_id() {
		return gwamok_id;
	}
	public void setGwamok_id(String gwamok_id) {
		this.gwamok_id = gwamok_id;
	}
	public String getGangjwa_id() {
		return gangjwa_id;
	}
	public void setGangjwa_id(String gangjwa_id) {
		this.gangjwa_id = gangjwa_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHackjeom() {
		return hackjeom;
	}
	public void setHackjeom(int hackjeom) {
		this.hackjeom = hackjeom;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
}
