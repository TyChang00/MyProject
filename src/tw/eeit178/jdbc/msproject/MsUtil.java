package tw.eeit178.jdbc.msproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MsUtil {
private Connection conn;
public Connection createConn() throws Exception{ 
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
	String urlstr = "jdbc:sqlserver://localhost:1433;databaseName=JDBC178;user=watcher;password=PasswOrd;encrypt=true;trustServerCertificate=true";
	conn = DriverManager.getConnection(urlstr);
	System.out.println("Connection Status:" + !conn.isClosed()); return conn;
	}

public void Closeconn() throws SQLException{	
	if(conn !=null) {			
		conn.close();		
		}		
	System.out.println("Connection close!");			
	}
}
