package kr.ac.mju.model;

import kr.ac.mju.model.CMemberCatalog;

import org.springframework.beans.factory.annotation.Autowired;

public class HacksaImpl implements Hacksa {

	private CMemberCatalog memberCatalog;
	
	@Autowired
	public void setMemberCatalog(CMemberCatalog memberCatalog) {
		this.memberCatalog = memberCatalog;
	}
	
	@Override
	public CMember getMember(String id, String password) {
		return this.memberCatalog.getMember(id, password);
	}

}
