package kr.ac.mju.Dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class UserDaoIbatis extends SqlMapClientDaoSupport {
	public List selectUser(){
		return getSqlMapClientTemplate().queryForList("user.getAllUser");
	}
}
