package tw.eeit178.jdbc.msproject;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class MsfindById {
	private static final String urlstr = "jdbc:sqlserver://localhost:1433;databaseName=JDBC178;user=watcher;password=PasswOrd;encrypt=true;trustServerCertificate=true";
	private static final String USER = "watcher";
	private static final String PASSWORD = "PasswOrd";
	

public static void main(String[] args) throws Exception {
	Scanner scanner = new Scanner(System.in);
	System.out.print("請輸入Id:");
	int id = scanner.nextInt();
	scanner.close();
	Connection conn = DriverManager.getConnection(urlstr, USER, PASSWORD);
	MsDAO Mth = new MsDAO(conn);
	MsBean A = Mth.findById(id);
	MsBean sd = new MsBean();

	sd.setId(A.getId());
	sd.setYearOfRoc(A.getYearOfRoc());
	sd.setSemester(A.getSemester());
	sd.setClassName(A.getClassName());
	sd.setTeacherName(A.getTeacherName());
	sd.setClassTime(A.getClassTime());
	sd.setStudent(A.getStudent());

	System.out.println(sd);

	FileWriter fw = new FileWriter("C:\\Action\\test.txt");
	fw.write(sd.toString());
	fw.close();
	conn.close();
}
}