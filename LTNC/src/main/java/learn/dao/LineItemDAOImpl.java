package learn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import learn.common.Database;
import learn.entities.LineItem;

public class LineItemDAOImpl implements LineItemDAO{

	@Override
	public List<LineItem> getAllItemsByOrderId(int orderId) {
		String sql = "select * from lineitem where order_id =?"; 
		Connection son;
		try {
			son = Database.Openconnection(); 
			PreparedStatement ps = son.prepareStatement(sql); 
			 
			ps.setInt(1,orderId); 
			 
			ResultSet rs = ps.executeQuery(); 
			 
			while(rs.next()) { 
				System.out.println(rs.getInt(1) + "\t" + rs.getInt(2)+ "\t"  + rs.getInt(3) + "\t" + rs.getFloat(4));
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		} 
		
		return null;
	}

	@Override
	public boolean addLineItem(LineItem item) {
		String sql = "insert into lineitem values(?,?,?,?)"; 
		Connection son;
		try {
			son = Database.Openconnection(); 
			PreparedStatement ps = son.prepareStatement(sql); 
			 
			ps.setInt(1,item.getOrderID()); 
			ps.setInt(2, item.getProductID()); 
			ps.setInt(3, item.getQuantity()); 
			ps.setFloat(4, item.getPrice()); 
			 
			return ps.executeUpdate() > 0;
			 
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		} 
		
		return false;
	} 
	

}
