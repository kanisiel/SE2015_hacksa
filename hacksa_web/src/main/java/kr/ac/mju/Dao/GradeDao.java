package kr.ac.mju.Dao;

import java.sql.SQLException;
import java.util.List;

import kr.ac.mju.Conf.Configuration;
import kr.ac.mju.Conf.Configuration.ErrorCodes;
import kr.ac.mju.mapper.GradeMapper;
import kr.ac.mju.model.Grade;
import kr.ac.mju.model.GradeInfo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GradeDao implements Dao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public Grade getGrade(int idx) throws SQLException{
		Grade grade;
		GradeMapper gradeMapper = sqlSession.getMapper(GradeMapper.class);
		if(gradeMapper == null){
			grade = new Grade();
			grade.setErrorCode(ErrorCodes.ER1001.name());
			grade.setSubscribe_kor(ErrorCodes.ER1001.getSubtitleKor());
			return grade;
		} else {
			try {
				grade = gradeMapper.getGrade(idx);
				grade.setErrorCode(ErrorCodes.Success.name());
				grade.setSubscribe_kor(ErrorCodes.Success.getSubtitleKor());
				return grade;
			} catch (SQLException e) {
				grade = new Grade();
				grade.setErrorCode(ErrorCodes.ER2001.name());
				grade.setSubscribe_kor(ErrorCodes.ER2001.getSubtitleKor());
				return grade;
			}
		}
	}
	public GradeInfo getList() throws SQLException{
		GradeInfo gradeInfo;
		GradeMapper gradeMapper = sqlSession.getMapper(GradeMapper.class);
		
		if(gradeMapper!=null){
			List<Grade> gradeList = gradeMapper.getAll();
			if(gradeList == null){
				gradeInfo = new GradeInfo();
				gradeInfo.setErrorCode(Configuration.ErrorCodes.ER1001.getCodeName());
				gradeInfo.setSubscribe_kor(Configuration.ErrorCodes.ER1001.getSubtitleKor());
				return gradeInfo;
			} else {
				gradeInfo = new GradeInfo();
				gradeInfo.setList(gradeList);
				gradeInfo.setErrorCode(Configuration.ErrorCodes.Success.getCodeName());
				gradeInfo.setSubscribe_kor(Configuration.ErrorCodes.Success.getSubtitleKor());
				return gradeInfo;
			}
		} else {
			gradeInfo = new GradeInfo();
			gradeInfo.setErrorCode(Configuration.ErrorCodes.ER0000.getCodeName());
			gradeInfo.setSubscribe_kor(Configuration.ErrorCodes.ER0000.getSubtitleKor());
			return gradeInfo;
		}
	}
}
