package tw.eeit178.jdbc.msproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MsConn {

private Connection conn;
public void createConn() throws Exception{   //開conn
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String urlstr = "jdbc:sqlserver://localhost:1433;databaseName=JDBC178;user=watcher;password=PasswOrd;encrypt=true;trustServerCertificate=true";
        conn = DriverManager.getConnection(urlstr);
        System.out.println("Connection Status:" + !conn.isClosed());
}

public void Closeconn() throws SQLException{  //關conn
if(conn !=null) {
conn.close();
}
System.out.println("Connection close!");

}

public static void main(String[] args) throws Exception {
	MsConn a= new MsConn();
	a.createConn();
	a.Closeconn();
	
}

}
