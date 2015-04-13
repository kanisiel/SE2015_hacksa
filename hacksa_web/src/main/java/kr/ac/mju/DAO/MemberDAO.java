package kr.ac.mju.DAO;

import javax.sql.DataSource;

import kr.ac.mju.model.CMember;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

@SuppressWarnings("deprecation")
public class MemberDAO implements DAO {
	
	private SimpleJdbcTemplate template;
	private static final String SelectQuery = "Select user_id, password From user_account Where user_id = ? And password = ?";
	
	public void setDataSource(DataSource dataSource){
		this.template = new SimpleJdbcTemplate(dataSource);
	}
	
	public CMember findMember(String id, String password){
		RowMapper<CMember> mapper = new BeanPropertyRowMapper<CMember>(CMember.class);
		return this.template.queryForObject(SelectQuery, mapper, id, password);		
	}
}
