package tw.eeit178.jdbc.msproject;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MsDAO implements Msinterface{
	private Connection conn;

	public MsDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public MsBean update(MsBean B) throws SQLException {//裡面參數給Bean的時候要再new一個bean
		String SQL = "update ClassInfo set classtime=? where id= ? ";
		PreparedStatement preState = conn.prepareStatement(SQL);
		preState.setString(1, B.getClassTime());
		preState.setInt(2, B.getId() );
		int count = preState.executeUpdate();
		System.out.println("update count=" + count);
		preState.close();
		return B;
		
	}

	@Override
	public MsBean deleteByclassName(String A) throws SQLException {
		String SQL = "delete from ClassInfo where className like  ? ";
		PreparedStatement preState = conn.prepareStatement(SQL);
		preState.setString(1, "%" + A + "%");
		int count = preState.executeUpdate();
		System.out.print("delete count=" + count);
		preState.close();
		
		return null;
		
	}

	@Override
	public MsBean findById(int id) throws SQLException {
		String SQL = "select * from [JDBC178].[DBO].[ClassInfo] where Id = ?";
		PreparedStatement preState = conn.prepareStatement(SQL);
		preState.setInt(1, id);
		ResultSet rs = preState.executeQuery();
		rs.next();

		MsBean s = new MsBean();//利用rs.get取得資料再利用set放進去bean裡面
		s.setId(rs.getInt(1));
		s.setYearOfRoc(rs.getString(2));
		s.setSemester(rs.getString(3));
		s.setClassName(rs.getString(4));
		s.setTeacherName(rs.getString(5));
		s.setClassTime(rs.getString(6));
		s.setStudent(rs.getString(7));

		rs.close();
		preState.close();

		return s;
	}

	@Override
	public void storeImage() throws Exception {
		
			FileInputStream fis1 = new FileInputStream("c:/Action/image01.jpg");
			
			String sqlstr = "insert into FileGallery(FileName, FileContent) values(?,?)";
			PreparedStatement state = conn.prepareStatement(sqlstr);
			state.setString(1, "images00");
			state.setBinaryStream(2, fis1);
			state.executeUpdate();
			state.close();
			System.out.println("File Stored");
		
		
	}

	@Override
	public void retriveImage(int id) throws Exception {
		String sqlstr = "select * from FileGallery where FileID=?";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		state.setInt(1, 1);
		ResultSet rs = state.executeQuery();
		
		if(rs.next()) {
			Blob blob = rs.getBlob(3);
			int length = (int)blob.length();
			System.out.println("length:" + length);
			
			BufferedOutputStream bos1 = new BufferedOutputStream(new FileOutputStream("c:/Action/image02.jpg"));
			bos1.write(blob.getBytes(1, length));
			bos1.flush();
			bos1.close();
			System.out.println("Connection close!");
			rs.close();
			state.close();
		}
		
	}

}

