package kr.ac.mju.model;

public class Gwamok implements CEntity {

	private static final long serialVersionUID = 1L;
	private int gwamok_id;
	private String name;
	private int hakjeom;
	
	
	public int getGwamok_id() {
		return gwamok_id;
	}
	public void setGwamok_id(int gwamok_id) {
		this.gwamok_id = gwamok_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHakjeom() {
		return hakjeom;
	}
	public void setHakjeom(int hakjeom) {
		this.hakjeom = hakjeom;
	}
	
	
}
