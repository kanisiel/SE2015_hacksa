package kr.ac.mju.model;

public class CHacksa implements Hacksa {

	private CMemberCatalog memberCatalog;
	
	public void setMemberCatalog(CMemberCatalog memberCatalog) {
		this.memberCatalog = memberCatalog;
	}

	@Override
	public CMember getMember(String id, String password) {
		return this.memberCatalog.getMember(id, password); 
	}

}
