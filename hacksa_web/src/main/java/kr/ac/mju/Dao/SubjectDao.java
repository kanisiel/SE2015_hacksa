package kr.ac.mju.Dao;

import java.sql.SQLException;
import java.util.List;

import kr.ac.mju.Conf.Configuration;
import kr.ac.mju.Conf.Configuration.ErrorCodes;
import kr.ac.mju.mapper.SubjectMapper;
import kr.ac.mju.model.Subject;
import kr.ac.mju.model.SubjectInfo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SubjectDao implements Dao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public String updateSubject(Subject subject) throws SQLException{
		SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
		if(subjectMapper == null){
			return ErrorCodes.ER1001.name();
		} else {
			subjectMapper.update(subject);
		}
		return ErrorCodes.Success.name();
	}
	
	public String createSubject(Subject subject){
		SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
		if(subjectMapper == null){
			return ErrorCodes.ER1001.name();
		} else {
			try {
				subjectMapper.create(subject);
			} catch (SQLException e) {
				return ErrorCodes.ER2001.name();
			}
			return ErrorCodes.Success.name();
		}
	}
	
	public SubjectInfo getList() throws SQLException{
		SubjectInfo subjectInfo;
		SubjectMapper subjectMapper = sqlSession.getMapper(SubjectMapper.class);
		
		if(subjectMapper!=null){
			List<Subject> subjectList = subjectMapper.listAll();
			if(subjectList == null){
				subjectInfo = new SubjectInfo();
				subjectInfo.setErrorCode(Configuration.ErrorCodes.ER1001.getCodeName());
				subjectInfo.setSubscribe_kor(Configuration.ErrorCodes.ER1001.getSubtitleKor());
				return subjectInfo;
			} else {
				subjectInfo = new SubjectInfo();
				subjectInfo.setList(subjectList);
				subjectInfo.setErrorCode(Configuration.ErrorCodes.Success.getCodeName());
				subjectInfo.setSubscribe_kor(Configuration.ErrorCodes.Success.getSubtitleKor());
				return subjectInfo;
			}
		} else {
			subjectInfo = new SubjectInfo();
			subjectInfo.setErrorCode(Configuration.ErrorCodes.ER0000.getCodeName());
			subjectInfo.setSubscribe_kor(Configuration.ErrorCodes.ER0000.getSubtitleKor());
			return subjectInfo;
		}
	}
}
