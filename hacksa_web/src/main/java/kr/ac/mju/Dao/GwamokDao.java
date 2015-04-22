package kr.ac.mju.Dao;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import kr.ac.mju.Conf.Configuration.Files;
import kr.ac.mju.model.Gwamok;
import kr.ac.mju.model.GwamokInfo;

import org.springframework.stereotype.Repository;

@Repository
public class GwamokDao implements Dao {
	private GwamokInfo gwamokInfo = new GwamokInfo();

	public GwamokInfo getList(){
		String[] gwamokData;
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(Files.Gwamok.getFileName()).getFile());
		
		try (Scanner scanner = new Scanner(file)){
			while (scanner.hasNextLine()) {
				Gwamok gwamok = new Gwamok();
				String line = scanner.nextLine();
				gwamokData = line.split("\t");
				gwamok.setGwamok_id(gwamokData[0]);
				gwamok.setName(gwamokData[1]);
				gwamok.setHakjeom(Integer.parseInt(gwamokData[2]));
				
				if(check_duplication(gwamok) == 1){
					this.gwamokInfo.addGwamok(gwamok);
				}
			}
			this.gwamokInfo.setErrorCode("Success");
		 	scanner.close();
			return this.gwamokInfo;
		} catch (IOException e) {
			e.printStackTrace();
			this.gwamokInfo.setErrorCode("ER2000");
			return this.gwamokInfo;
		}
	}
	
	public int check_duplication(Gwamok gwamok){
		Vector<Gwamok> list = this.gwamokInfo.getList();
		if(list.isEmpty()){
			return 1;
		} else {
			for(Gwamok gwamoks : list){
				if(gwamoks.getGwamok_id().equals(gwamok.getGwamok_id())){				
					return -1;
				}
			}
		}
		return 1;
	}
}
