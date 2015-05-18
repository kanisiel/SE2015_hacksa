package kr.ac.mju.model;

public class College implements CEntity {
	private static final long serialVersionUID = 1L;
	private String name;
	private int idx;
	private String captain;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getCaptain() {
		return captain;
	}
	public void setCaptain(String captain) {
		this.captain = captain;
	}
}
