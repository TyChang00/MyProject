package tw.eeit178.jdbc.msproject;


import java.sql.SQLException;

public interface Msinterface {

	
	public MsBean update(MsBean B)throws SQLException;
	public MsBean deleteByclassName(String A) throws SQLException;
	public MsBean findById(int id) throws SQLException;
	public void storeImage() throws Exception;
	public void retriveImage(int id) throws Exception;
}
