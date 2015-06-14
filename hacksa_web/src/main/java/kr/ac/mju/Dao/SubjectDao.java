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

//	public SubjectInfo getList(){
//		String[] gwamokData;
//		ClassLoader classLoader = getClass().getClassLoader();
//		File file = new File(classLoader.getResource(Files.Gwamok.getFileName()).getFile());
//		
//		try (Scanner scanner = new Scanner(file)){
//			while (scanner.hasNextLine()) {
//				Subject subject = new Subject();
//				String line = scanner.nextLine();
//				gwamokData = line.split("\t");
//				subject.setSid(gwamokData[0]);
//				subject.setName(gwamokData[1]);
//				subject.setUnit(Integer.parseInt(gwamokData[2]));
//				
////				if(check_duplication(subject) == 1){
//	//				this.subjectInfo.addGwamok(subject);
//		//		}
//			}
//			this.subjectInfo.setErrorCode("Success");
//		 	scanner.close();
//			return this.subjectInfo;
//		} catch (IOException e) {
//			e.printStackTrace();
//			this.subjectInfo.setErrorCode("ER2000");
//			return this.subjectInfo;
//		}
//	}
	
//	public int check_duplication(Subject subject){
//		Vector<Subject> list = this.subjectInfo.getList();
//		if(list.isEmpty()){
//			return 1;
//		} else {
//			for(Subject subjects : list){
//				if(subjects.getGwamok_id().equals(subject.getGwamok_id())){				
//					return -1;
//				}
//			}
//		}
//		return 1;
//	}
}
