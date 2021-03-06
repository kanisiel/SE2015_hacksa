package kr.ac.mju.model;

public class Department implements CEntity {
	private static final long serialVersionUID = 1L;
	private String name;
	private int idx;
	private String captain;
	private int college;
	private String errorCode;
	private String subscribe_kor;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCaptain() {
		return captain;
	}
	public void setCaptain(String captain) {
		this.captain = captain;
	}
	public int getCollege() {
		return college;
	}
	public void setCollege(int college) {
		this.college = college;
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
