package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import bean.Guitar;
import jdbc.JDBC;
import model.InventoryModel;

public class InventoryDaoImpl implements InventoryDao{

	

	@Override
	public List<Guitar> search(String serialNumber) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from guitar where serialNumber=?";
		JDBC jdbc=new JDBC();
		Connection conn=jdbc.getConnection();
		List<Guitar> list =new LinkedList();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, serialNumber);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Guitar guitar=new Guitar(serialNumber, 
									rs.getDouble("price"), 
									rs.getString("builder"),
									rs.getString("model"),
									rs.getString("type"), 
									rs.getString("bacwood"), 
									rs.getString("topwood"));
					list.add(guitar);	
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbc.closeConnection(conn);
		}
		return null;
	}
	
}
