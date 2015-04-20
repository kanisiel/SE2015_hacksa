package kr.ac.mju.Dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import kr.ac.mju.Conf.Configuration.Files;
import kr.ac.mju.model.Gangjwa;
import kr.ac.mju.model.GangjwaInfo;
import org.springframework.stereotype.Repository;

@Repository
public class GangjwaDao implements Dao {
	
	private GangjwaInfo gangjwaInfo = new GangjwaInfo();

	public GangjwaInfo getList(){
		String[] gangjwaData;
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(Files.Gangjwa.getFileName()).getFile());
		
		try (Scanner scanner = new Scanner(file)){
			while (scanner.hasNextLine()) {
				Gangjwa gangjwa = new Gangjwa();
				String line = scanner.nextLine();
				gangjwaData = line.split("\t");
				
				gangjwa.setGwamok_id(gangjwaData[0]);
				gangjwa.setGangjwa_id(gangjwaData[1]);
				gangjwa.setName(gangjwaData[2]);
				gangjwa.setInstructor(gangjwaData[3]);
				gangjwa.setHackjeom(Integer.parseInt(gangjwaData[4]));
				
				if(check_duplication(gangjwa) == 1){
					this.gangjwaInfo.addGangjwa(gangjwa);
				}
				
			}
			this.gangjwaInfo.setErrorCode("Success");
		 	scanner.close();
			return gangjwaInfo;
		} catch (IOException e) {
			e.printStackTrace();
			gangjwaInfo.setErrorCode("ER1000");
			return gangjwaInfo;
		}
	}
	public int check_duplication(Gangjwa gangjwa){
		Vector<Gangjwa> list = this.gangjwaInfo.getList();
		if(list.isEmpty()){
			return 1;
		} else {
			for(Gangjwa gangjwas : list){
				if(gangjwas.getGwamok_id().equals(gangjwa.getGwamok_id())){				
					return -1;
				}
			}
		}
		return 1;
	}
	public void writeToDB(BufferedWriter file, String data){
		try {
			file.write(data, 0, data.length());
			file.write("\t");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insert(Gangjwa gangjwa){
		try {
			BufferedWriter file = new BufferedWriter(new FileWriter(Files.Gangjwa.getFileName(), true));
			writeToDB(file, String.valueOf(gangjwa.getGangjwa_id()));
			writeToDB(file, String.valueOf(gangjwa.getGwamok_id()));
			writeToDB(file, gangjwa.getName());
			writeToDB(file, gangjwa.getInstructor());
			writeToDB(file, String.valueOf(gangjwa.getHackjeom()));
			file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
