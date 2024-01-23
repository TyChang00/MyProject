package tw.eeit178.jdbc.msproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class MsFileStore {
	
	private Connection conn;
	
	public void processAction() throws Exception {
		MsUtil util = new MsUtil();
		conn = util.createConn();
		
		inserttosql();
		
		util.Closeconn();
	}

	public void inserttosql() {
		
		 String csvFile = "c:/Action/ClassInfo.csv"; 
	     String line;
	     String splitBy = ",";

	        try (
	        	BufferedReader br = new BufferedReader(new FileReader(csvFile));
	        	
	        		) {
	           
	            while ((line = br.readLine()) != null) {
	                String[] data = line.split(splitBy);

	                	String insertQuery = "INSERT INTO ClassInfo (yearOfRoc, semester, className, teacherName, classTime,student) VALUES (?,?, ?, ?, ?, ?)";
	     	            PreparedStatement state = conn.prepareStatement(insertQuery);
	     	            

	     	            
	                	state.setString(1, data[1]);
	                	state.setString(2, data[2]);
	                	state.setString(3, data[3]);
	                	state.setString(4, data[4]);
	                	state.setString(5, data[5]);
	                	state.setString(6, data[6]);
	       

	                    state.execute();
	                    state.close();
	            }
	          
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	public static void main(String[] args) throws Exception {
		MsFileStore  jdbcfile = new MsFileStore ();
		jdbcfile.processAction();
	}
}