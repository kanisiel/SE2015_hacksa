package kr.ac.mju.model;

public class Subject implements CEntity {

	private static final long serialVersionUID = 1L;
	private String sid;
	private String name;
	private int unit;
	
	public Subject(){}
	
	public Subject(String sid, String name, int unit) {
		this.sid = sid;
		this.name = name;
		this.unit = unit;
	}

	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	
}
