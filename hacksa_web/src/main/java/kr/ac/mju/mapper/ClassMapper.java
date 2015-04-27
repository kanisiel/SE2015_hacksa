package kr.ac.mju.mapper;

import kr.ac.mju.model.GwamokInfo;

public interface ClassMapper {
	public GwamokInfo listAllGwamok();
	public GwamokInfo listCollegeGwamok(String college);
	public GwamokInfo listDeptGwamok(String dept);
}
