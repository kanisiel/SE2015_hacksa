package kr.ac.mju.Conf;

public class Configuration {
	public enum Files {
		Gangjwa("GangjwaDB.txt"),
		Gwamok("GwamokDB.txt"),
		User("UserDB.txt");
		
		private String fileName;
		
		Files(String fileName){
			this.fileName = fileName;
		}

		public String getFileName() {
			return fileName;
		}
		
	}
	public enum ErrorCodes {
		ER1000("ER1000", "Can't connect to DB. Please contact to System Administrator", "데이터배이스 연결에 실패 하였습니다. 시스템 관리자에게 문의해 주세요."),
		ER1001("ER1001", "You're input invalid ID. Check ID and retry.", "없는 아이디 입니다. 확인 후 다시 로그인 해 주세요."),
		ER1002("ER1002", "You're input invalid Password. Check ID and Password.", "비밀번호가 틀렸습니다. 확인 후 다시 로그인 해 주세요."),
		ER2000("ER2000", "Gwamok data doesn't exist. Please contact in charge.", "과목정보가 입력되지 않았습니다. 담당자에게 문의해 주세요.");
		
		private String codeName;
		private String subtitleEng;
		private String subtitleKor;
		
		ErrorCodes(String codeName, String subtitleEng, String subtitleKor){
			this.codeName = codeName;
			this.subtitleEng = subtitleEng;
			this.subtitleKor = subtitleKor;
		}
		public String getCodeName() {
			return codeName;
		}

		public String getSubtitleEng() {
			return subtitleEng;
		}

		public String getSubtitleKor() {
			return subtitleKor;
		}		
		
	}

}
