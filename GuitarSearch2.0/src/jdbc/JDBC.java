package jdbc;

import java.sql.*;

public class JDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JDBC t=new JDBC();
		System.out.print(t.getConnection());
	}
	
	
	public static Connection getConnection(){
		
	    try {
			Class.forName("org.sqlite.JDBC");
		
	    Connection conn =
	      DriverManager.getConnection("jdbc:sqlite://d:/guitar2.db");
	    	return conn;
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
		
	}
	public void closeConnection(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
