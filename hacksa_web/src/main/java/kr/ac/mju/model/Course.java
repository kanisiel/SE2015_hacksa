package kr.ac.mju.model;

public class Course implements CEntity {

	private static final long serialVersionUID = 1L;
	private String sid;
	private String cid;
	private String name;
	private int instructor;
	private String inst_name;
	private int year;
	private int max;
	private int grade;
	private int unit;
	private int dept;
	private int college;

	
	public Course(){}
	public Course(String sid, String cid, String name, int instructor,String inst_name, int year, int max, int grade, 
			int unit, int dept, int college) {
		this.sid = sid;
		this.cid = cid;
		this.name = name;
		this.instructor = instructor;
		this.inst_name = inst_name;
		this.setYear(year);
		this.max = max;
		this.grade = grade;
		this.unit = unit;
		this.dept = dept;
		this.college = college;
	}
	public Course clone(){
		return new Course(this.sid, this.cid, this.name, this.instructor, this.inst_name, this.year, this.max, this.grade, this.unit, this.dept, this.college);
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
	public int getInstructor() {
		return instructor;
	}
	public void setInstructor(int instructor) {
		this.instructor = instructor;
	}
	public int getDept() {
		return dept;
	}
	public void setDept(int dept) {
		this.dept = dept;
	}
	public int getCollege() {
		return college;
	}
	public void setCollege(int college) {
		this.college = college;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getInst_name() {
		return inst_name;
	}
	public void setInst_name(String inst_name) {
		this.inst_name = inst_name;
	}
	
}
