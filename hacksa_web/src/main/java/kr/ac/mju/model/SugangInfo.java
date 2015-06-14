package kr.ac.mju.model;

import java.util.List;
import java.util.Vector;

public class SugangInfo implements Info {

	private List<Sugang> list;
	private String errorCode;
	private String subscribe_kor;
	
	public SugangInfo() {
		this.setList(new Vector<Sugang>());
		setErrorCode(null);
	}

	public List<Sugang> getList() {
		return list;
	}

	public void setList(List<Sugang> list) {
		this.list = list;
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
