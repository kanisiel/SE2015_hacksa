package kr.ac.mju.Dao;

import java.sql.SQLException;
import java.util.List;

import kr.ac.mju.Conf.Configuration;
import kr.ac.mju.Conf.Configuration.ErrorCodes;
import kr.ac.mju.mapper.CourseMapper;
import kr.ac.mju.model.Course;
import kr.ac.mju.model.CourseInfo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDao implements Dao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public CourseInfo getAllCourse() throws SQLException{
		CourseInfo courseInfo;
		CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
		if(courseMapper!=null){
			List<Course> courseList = courseMapper.listAll();
			if(courseList == null){
				courseInfo = new CourseInfo();
				courseInfo.setErrorCode(Configuration.ErrorCodes.ER1001.getCodeName());
				courseInfo.setSubscribe_kor(Configuration.ErrorCodes.ER1001.getSubtitleKor());
				return courseInfo;
			} else {
				courseInfo = new CourseInfo();
				courseInfo.setList(courseList);
				courseInfo.setErrorCode(Configuration.ErrorCodes.Success.getCodeName());
				courseInfo.setSubscribe_kor(Configuration.ErrorCodes.Success.getSubtitleKor());
				return courseInfo;
			}
		} else {
			courseInfo = new CourseInfo();
			courseInfo.setErrorCode(Configuration.ErrorCodes.ER0000.getCodeName());
			courseInfo.setSubscribe_kor(Configuration.ErrorCodes.ER0000.getSubtitleKor());
			return courseInfo;
		}
		
	}
	public CourseInfo getCourse(int cid) throws SQLException{
		CourseInfo courseInfo;
		CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
		if(courseMapper!=null){
			List<Course> courseList = courseMapper.getCourse(cid);
			if(courseList == null){
				courseInfo = new CourseInfo();
				courseInfo.setErrorCode(Configuration.ErrorCodes.ER1001.getCodeName());
				courseInfo.setSubscribe_kor(Configuration.ErrorCodes.ER1001.getSubtitleKor());
				return courseInfo;
			} else {
				courseInfo = new CourseInfo();
				courseInfo.setList(courseList);
				courseInfo.setErrorCode(Configuration.ErrorCodes.Success.getCodeName());
				courseInfo.setSubscribe_kor(Configuration.ErrorCodes.Success.getSubtitleKor());
				return courseInfo;
			}
		} else {
			courseInfo = new CourseInfo();
			courseInfo.setErrorCode(Configuration.ErrorCodes.ER0000.getCodeName());
			courseInfo.setSubscribe_kor(Configuration.ErrorCodes.ER0000.getSubtitleKor());
			return courseInfo;
		}
		
	}
	public CourseInfo listInstructor(int instructor) throws SQLException{
		CourseInfo courseInfo;
		CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
		if(courseMapper!=null){
			List<Course> courseList = courseMapper.listInstructor(instructor);
			if(courseList == null){
				courseInfo = new CourseInfo();
				courseInfo.setErrorCode(Configuration.ErrorCodes.ER1001.getCodeName());
				courseInfo.setSubscribe_kor(Configuration.ErrorCodes.ER1001.getSubtitleKor());
				return courseInfo;
			} else {
				courseInfo = new CourseInfo();
				courseInfo.setList(courseList);
				courseInfo.setErrorCode(Configuration.ErrorCodes.Success.getCodeName());
				courseInfo.setSubscribe_kor(Configuration.ErrorCodes.Success.getSubtitleKor());
				return courseInfo;
			}
		} else {
			courseInfo = new CourseInfo();
			courseInfo.setErrorCode(Configuration.ErrorCodes.ER0000.getCodeName());
			courseInfo.setSubscribe_kor(Configuration.ErrorCodes.ER0000.getSubtitleKor());
			return courseInfo;
		}
		
	}
	public CourseInfo getCollegeCourse(int college){
		CourseInfo courseInfo;
		CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
		if(courseMapper!=null){
			try {
				courseInfo = courseMapper.listCollegeCourse(college);
				if(courseInfo == null){
					courseInfo = new CourseInfo();
					courseInfo.setErrorCode(Configuration.ErrorCodes.ER3000.getCodeName());
					return courseInfo;
				} else {
					courseInfo.setErrorCode(Configuration.ErrorCodes.Success.getCodeName());
					return courseInfo;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				courseInfo = new CourseInfo();
				courseInfo.setErrorCode(Configuration.ErrorCodes.ER0001.getCodeName());
				return courseInfo;
			}
		} else {
			courseInfo = new CourseInfo();
			courseInfo.setErrorCode(Configuration.ErrorCodes.ER0000.getCodeName());
			return courseInfo;
		}
		
	}
	public String createCourse(Course Course){
		CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
		if(courseMapper == null){
			return ErrorCodes.ER1001.name();
		} else {
			try {
				courseMapper.create(Course);
			} catch (SQLException e) {
				return ErrorCodes.ER2001.name();
			}
			return ErrorCodes.Success.name();
		}
	}
	/*public CourseInfo getList(){
		String[] gangjwaData;
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(Files.Gangjwa.getFileName()).getFile());
		
		try (Scanner scanner = new Scanner(file)){
			while (scanner.hasNextLine()) {
				Course gangjwa = new Course();
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
	public int check_duplication(Course gangjwa){
		Vector<Course> list = this.gangjwaInfo.getList();
		if(list.isEmpty()){
			return 1;
		} else {
			for(Course gangjwas : list){
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
	public void insert(Course gangjwa){
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
	}*/
}
