package tw.eeit178.jdbc.msproject;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class MsDeletetest {
	
		private static final String urlstr = "jdbc:sqlserver://localhost:1433;databaseName=JDBC178;user=watcher;password=PasswOrd;encrypt=true;trustServerCertificate=true";
		private static final String USER = "watcher";
		private static final String PASSWORD = "PasswOrd";
		
		public static void main(String[] args) throws FileNotFoundException, Exception {
			
			Scanner scanner = new Scanner(System.in);
			System.out.print("請輸入設置位置:");
			String className = scanner.next();
			scanner.close();
			Connection conn = DriverManager.getConnection(urlstr, USER, PASSWORD);
			MsDAO Mth = new MsDAO(conn);
			Mth.deleteByclassName(className);
			
		
	}
}

