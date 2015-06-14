package kr.ac.mju.model;

public class Sugang implements CEntity {
	
	private static final long serialVersionUID = 1L;
	private int idx;
	private int uidx;
	private int cid;
	private int grade;
	private String grade_en;
	private Course course;
	private UserInfo userInfo;
	
	
	public Sugang(){}
	public Sugang(int uidx, int cid){
		this.uidx = uidx;
		this.cid = cid;
	}
	public int getUidx() {
		return uidx;
	}
	public void setUidx(int uidx) {
		this.uidx = uidx;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public String getGrade_en() {
		return grade_en;
	}
	public void setGrade_en(String grade_en) {
		this.grade_en = grade_en;
	}
}
