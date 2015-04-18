package kr.ac.mju.Dao;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import kr.ac.mju.model.Gwamok;
import kr.ac.mju.model.GwamokInfo;

import org.springframework.stereotype.Repository;

@Repository
public class GwamokDao implements Dao {
	private GwamokInfo gwamokInfo;

	public GwamokInfo getList(){
		String[] gwamokData;
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("GwamokDB.txt").getFile());
		
		try (Scanner scanner = new Scanner(file)){
			while (scanner.hasNextLine()) {
				Gwamok gwamok = new Gwamok();
				String line = scanner.nextLine();
				gwamokData = line.split("\t");
				gwamok.setGwamok_id(Integer.parseInt(gwamokData[0]));
				gwamok.setName(gwamokData[1]);
				gwamok.setHakjeom(Integer.parseInt(gwamokData[2]));
				
				this.gwamokInfo.addGwamok(gwamok);
			}
		 	scanner.close();
			return gwamokInfo;
		} catch (IOException e) {
			e.printStackTrace();
			gwamokInfo.setErrorCode("ER1000");
			return gwamokInfo;
		}
	}
}
