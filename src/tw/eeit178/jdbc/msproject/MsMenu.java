package tw.eeit178.jdbc.msproject;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class MsMenu {
	private static final String urlstr = "jdbc:sqlserver://localhost:1433;databaseName=JDBC178;user=watcher;password=PasswOrd;encrypt=true;trustServerCertificate=true";
	private static final String USER = "watcher";
	private static final String PASSWORD = "PasswOrd";
	
	public static void main(String[] args) throws Exception {
		Connection conn = DriverManager.getConnection(urlstr, USER, PASSWORD);
		MsDAO sDAO = new MsDAO(conn);
		int num;
		Scanner scanner = new Scanner(System.in);
		do {
		scanner = new Scanner(System.in);
		System.out.println("功能清單" + "\n" +"(1)讀取資料" + "\n" + "(2)讀取資料並建立檔案" + "\n" + "(3)請輸入要刪除的課名"+ "\n" + "(4)請輸入更新時間"
				+ "\n" + "(5)讀取圖片並建立檔案" + "\n" + "請選擇功能：");
		num = scanner.nextInt();
}while(num > 5)    ;
		
		switch (num) {

		case 1:
			System.out.print("請輸入Id:");
			int id = scanner.nextInt();
			MsBean s = sDAO.findById(id);
			MsBean sd = new MsBean();
			sd.setId(s.getId());
			sd.setYearOfRoc(s.getYearOfRoc());
			sd.setSemester(s.getSemester());
			sd.setClassName(s.getClassName());
			sd.setTeacherName(s.getTeacherName());
			sd.setClassTime(s.getClassTime());
			sd.setStudent(s.getStudent());
			System.out.println(sd);
			conn.close();
			break;
		case 2:
			System.out.print("請輸入Id:");
			int ID2 = scanner.nextInt();
			MsBean s2 = sDAO.findById(ID2);
			MsBean sd2 = new MsBean();
			sd2.setId(s2.getId());
			sd2.setYearOfRoc(s2.getYearOfRoc());
			sd2.setSemester(s2.getSemester());
			sd2.setClassName(s2.getClassName());
			sd2.setTeacherName(s2.getTeacherName());
			sd2.setClassTime(s2.getClassTime());
			sd2.setStudent(s2.getStudent());
			
			System.out.println(sd2);
			FileWriter fw1 = new FileWriter("C:\\Action\\test.txt");
			fw1.write(sd2.toString());
			fw1.close();
			conn.close();
			break;
		case 3:
			System.out.print("請輸入要刪除的課名:");
			String ClassName = scanner.next();
			sDAO.deleteByclassName(ClassName);
			break;
		case 4:
			System.out.print("請輸入更新時間:");
			String classTime = scanner.next();
			System.out.print("請輸入更新id:");
			int id1 = scanner.nextInt();
			MsDAO Mth = new MsDAO(conn);
			MsBean ms = new MsBean(classTime, id1);
			sDAO.update(ms);
			break;
		case 5:
			System.out.print("請輸入ID:");
			int ID3 = scanner.nextInt();
			sDAO.retriveImage(ID3);
			break;
		}
		scanner.close();
		
	}
}

