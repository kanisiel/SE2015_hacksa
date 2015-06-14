package kr.ac.mju.service;

import java.sql.SQLException;

import javax.annotation.Resource;

import kr.ac.mju.Dao.SubjectDao;
import kr.ac.mju.model.Subject;
import kr.ac.mju.model.SubjectInfo;

import org.springframework.stereotype.Service;

@Service
public class AdminService {
	@Resource(name="subjectDao")
	private SubjectDao subjectDao;
	
	
	public SubjectInfo getList() throws SQLException{
		SubjectInfo subjectInfo = subjectDao.getList();
		System.out.println(subjectInfo.getErrorCode());
		return subjectInfo;
	}
	public String createSubject(Subject subject) throws SQLException{
		return subjectDao.createSubject(subject);
	}
}
