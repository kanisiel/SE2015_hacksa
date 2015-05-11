package kr.ac.mju.Dao;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import kr.ac.mju.Conf.Configuration.Files;
import kr.ac.mju.model.Subject;
import kr.ac.mju.model.SubjectInfo;

import org.springframework.stereotype.Repository;

@Repository
public class GwamokDao implements Dao {
	private SubjectInfo subjectInfo = new SubjectInfo();

	public SubjectInfo getList(){
		String[] gwamokData;
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(Files.Gwamok.getFileName()).getFile());
		
		try (Scanner scanner = new Scanner(file)){
			while (scanner.hasNextLine()) {
				Subject subject = new Subject();
				String line = scanner.nextLine();
				gwamokData = line.split("\t");
				subject.setGwamok_id(gwamokData[0]);
				subject.setName(gwamokData[1]);
				subject.setHakjeom(Integer.parseInt(gwamokData[2]));
				
				if(check_duplication(subject) == 1){
					this.subjectInfo.addGwamok(subject);
				}
			}
			this.subjectInfo.setErrorCode("Success");
		 	scanner.close();
			return this.subjectInfo;
		} catch (IOException e) {
			e.printStackTrace();
			this.subjectInfo.setErrorCode("ER2000");
			return this.subjectInfo;
		}
	}
	
	public int check_duplication(Subject subject){
		Vector<Subject> list = this.subjectInfo.getList();
		if(list.isEmpty()){
			return 1;
		} else {
			for(Subject subjects : list){
				if(subjects.getGwamok_id().equals(subject.getGwamok_id())){				
					return -1;
				}
			}
		}
		return 1;
	}
}
