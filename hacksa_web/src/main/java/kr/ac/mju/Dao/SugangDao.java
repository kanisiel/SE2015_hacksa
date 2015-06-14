package kr.ac.mju.Dao;

import java.sql.SQLException;
import java.util.List;

import kr.ac.mju.Conf.Configuration;
import kr.ac.mju.Conf.Configuration.ErrorCodes;
import kr.ac.mju.mapper.SugangMapper;
import kr.ac.mju.model.Course;
import kr.ac.mju.model.Sugang;
import kr.ac.mju.model.SugangInfo;
import kr.ac.mju.model.UserInfo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SugangDao implements Dao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public String register(Sugang sugang) throws SQLException{
		
		SugangMapper sugangMapper = sqlSession.getMapper(SugangMapper.class);
		if(sugangMapper == null){
			return ErrorCodes.ER1001.name();
		} else {
			try {
				sugangMapper.register(sugang);
			} catch (SQLException e) {
				return ErrorCodes.ER2001.name();
			}
			return ErrorCodes.Success.name();
		}
	}
	public SugangInfo getRegList(UserInfo userInfo) throws SQLException{
		SugangInfo sugangInfo;
		SugangMapper sugangMapper = sqlSession.getMapper(SugangMapper.class);
		if(sugangMapper != null){
			List<Sugang> sugangList = sugangMapper.getRegList(userInfo.getUIdx());
			if(sugangList == null){
				sugangInfo = new SugangInfo();
				sugangInfo.setErrorCode(Configuration.ErrorCodes.ER1001.getCodeName());
				sugangInfo.setSubscribe_kor(Configuration.ErrorCodes.ER1001.getSubtitleKor());
				return sugangInfo;
			} else {
				sugangInfo = new SugangInfo();
				sugangInfo.setList(sugangList);
				sugangInfo.setErrorCode(Configuration.ErrorCodes.Success.getCodeName());
				sugangInfo.setSubscribe_kor(Configuration.ErrorCodes.Success.getSubtitleKor());
				return sugangInfo;
			}
		} else {
			sugangInfo = new SugangInfo();
			sugangInfo.setErrorCode(Configuration.ErrorCodes.ER0000.getCodeName());
			sugangInfo.setSubscribe_kor(Configuration.ErrorCodes.ER0000.getSubtitleKor());
			return sugangInfo;
		}
	}
	public SugangInfo getCList(Course course) throws SQLException{
		SugangInfo sugangInfo = new SugangInfo();
		SugangMapper sugangMapper = sqlSession.getMapper(SugangMapper.class);
		if(sugangMapper != null){
			List<Sugang> sugangList = sugangMapper.getCList(Integer.parseInt(course.getCid()));
			if(sugangList == null){
				sugangInfo = new SugangInfo();
				sugangInfo.setErrorCode(Configuration.ErrorCodes.ER1001.getCodeName());
				sugangInfo.setSubscribe_kor(Configuration.ErrorCodes.ER1001.getSubtitleKor());
				return sugangInfo;
			} else {
				sugangInfo = new SugangInfo();
				sugangInfo.setList(sugangList);
				sugangInfo.setErrorCode(Configuration.ErrorCodes.Success.getCodeName());
				sugangInfo.setSubscribe_kor(Configuration.ErrorCodes.Success.getSubtitleKor());
				return sugangInfo;
			}
		} else {
			sugangInfo = new SugangInfo();
			sugangInfo.setErrorCode(Configuration.ErrorCodes.ER0000.getCodeName());
			sugangInfo.setSubscribe_kor(Configuration.ErrorCodes.ER0000.getSubtitleKor());
			return sugangInfo;
		}
	}
	public String setGrade(Sugang sugang) throws SQLException{
		SugangMapper sugangMapper = sqlSession.getMapper(SugangMapper.class);
		if(sugangMapper == null){
			return ErrorCodes.ER1001.name();
		} else {
			try {
				sugangMapper.setGrade(sugang);
			} catch (SQLException e) {
				return ErrorCodes.ER2001.name();
			}
			return ErrorCodes.Success.name();
		}
	}
}
