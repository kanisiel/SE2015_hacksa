package kr.ac.mju.mapper;

import java.sql.SQLException;
import java.util.List;

import kr.ac.mju.model.Sugang;

public interface SugangMapper {
	 public List<Sugang> getRegList(int uidx) throws SQLException;
	 public List<Sugang> getCList(int cid) throws SQLException;
	 public void register(Sugang sugang) throws SQLException;
	 public void setGrade(Sugang sugang) throws SQLException;
}
