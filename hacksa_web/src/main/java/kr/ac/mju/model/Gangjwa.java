package kr.ac.mju.model;

public class Gangjwa implements CEntity {

	private static final long serialVersionUID = 1L;
	private int gangjwa_id;
	private String name;
	private int hackjeom;
	private int gwamok_id;
	private String instructor;
	
	
	public int getGangjwa_id() {
		return gangjwa_id;
	}
	public void setGangjwa_id(int gangjwa_id) {
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
	public int getGwamok_id() {
		return gwamok_id;
	}
	public void setGwamok_id(int gwamok_id) {
		this.gwamok_id = gwamok_id;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
}
