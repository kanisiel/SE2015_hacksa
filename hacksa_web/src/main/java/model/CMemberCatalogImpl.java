package model;

import DAO.MemberDAO;

public class CMemberCatalogImpl implements CMemberCatalog {

	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}


	@Override
	public CMember getMember(String id, String password) {
		return this.memberDAO.findMember(id, password);
	}

}
