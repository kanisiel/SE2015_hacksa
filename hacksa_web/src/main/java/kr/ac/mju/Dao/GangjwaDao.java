package kr.ac.mju.Dao;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import kr.ac.mju.model.Gangjwa;
import kr.ac.mju.model.GangjwaInfo;
import kr.ac.mju.model.UserInfo;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

@Repository
public class GangjwaDao implements Dao {
	
	private GangjwaInfo gangjwaInfo;

	public GangjwaInfo getList(){
		String[] gangjwaData;
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("GangjwaDB.txt").getFile());
		
		try (Scanner scanner = new Scanner(file)){
			while (scanner.hasNextLine()) {
				Gangjwa gangjwa = new Gangjwa();
				String line = scanner.nextLine();
				gangjwaData = line.split("\t");
				gangjwa.setGwamok_id(Integer.parseInt(gangjwaData[0]));
				gangjwa.setGangjwa_id(Integer.parseInt(gangjwaData[1]));
				gangjwa.setName(gangjwaData[2]);
				gangjwa.setInstructor(gangjwaData[3]);
				gangjwa.setHackjeom(Integer.parseInt(gangjwaData[4]));
				
				this.gangjwaInfo.addGangjwa(gangjwa);
			}
		 	scanner.close();
			return gangjwaInfo;
		} catch (IOException e) {
			e.printStackTrace();
			gangjwaInfo.setErrorCode("ER1000");
			return gangjwaInfo;
		}
	}
}
