package kr.ac.mju.Dao;

import java.sql.SQLException;
import java.util.List;

import kr.ac.mju.Conf.Configuration;
import kr.ac.mju.mapper.CollegeMapper;
import kr.ac.mju.model.College;
import kr.ac.mju.model.CollegeInfo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CollegeDao implements Dao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public CollegeInfo getList() throws SQLException{
		CollegeInfo collegeInfo;
		CollegeMapper collegeMapper = sqlSession.getMapper(CollegeMapper.class);
		
		if(collegeMapper!=null){
			List<College> collegeList = collegeMapper.listAll();
			if(collegeList == null){
				collegeInfo = new CollegeInfo();
				collegeInfo.setErrorCode(Configuration.ErrorCodes.ER1001.getCodeName());
				collegeInfo.setSubscribe_kor(Configuration.ErrorCodes.ER1001.getSubtitleKor());
				return collegeInfo;
			} else {
				collegeInfo = new CollegeInfo();
				collegeInfo.setList(collegeList);
				collegeInfo.setErrorCode(Configuration.ErrorCodes.Success.getCodeName());
				collegeInfo.setSubscribe_kor(Configuration.ErrorCodes.Success.getSubtitleKor());
				return collegeInfo;
			}
		} else {
			collegeInfo = new CollegeInfo();
			collegeInfo.setErrorCode(Configuration.ErrorCodes.ER0000.getCodeName());
			collegeInfo.setSubscribe_kor(Configuration.ErrorCodes.ER0000.getSubtitleKor());
			return collegeInfo;
		}
	}
	public College getCollege(int idx) throws SQLException{
		College college;
		CollegeMapper collegeMapper = sqlSession.getMapper(CollegeMapper.class);
		
		if(collegeMapper!=null){
			college = collegeMapper.getCollege(idx);
			if(college == null){
				college = new College();
				college.setErrorCode(Configuration.ErrorCodes.ER1001.getCodeName());
				college.setSubscribe_kor(Configuration.ErrorCodes.ER1001.getSubtitleKor());
				return college;
			} else {
				college.setErrorCode(Configuration.ErrorCodes.Success.getCodeName());
				college.setSubscribe_kor(Configuration.ErrorCodes.Success.getSubtitleKor());
				return college;
			}
		} else {
			college = new College();
			college.setErrorCode(Configuration.ErrorCodes.ER0000.getCodeName());
			college.setSubscribe_kor(Configuration.ErrorCodes.ER0000.getSubtitleKor());
			return college;
		}
	}
}
