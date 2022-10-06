package learn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import learn.common.Database;
import learn.entities.Order;

public class OrderDAOImpl implements OrderDAO{

	@Override
	public List<Order> getAllOrdersByCustomerId(int customerId) {
		String sql = "select * from orders where customer_id =?"; 
		Connection son;
		try {
			son = Database.Openconnection(); 
			PreparedStatement ps = son.prepareStatement(sql); 
			 
			ps.setInt(1,customerId); 
			 
			ResultSet rs = ps.executeQuery(); 
			 
			while(rs.next()) { 
				System.out.println(rs.getInt(1) + "\t" + rs.getDate(2)+ "\t"  + rs.getInt(3) + "\t" + rs.getInt(4) + "\t" + rs.getFloat(5));
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		} 
		
		return null;
	}

	@Override
	public boolean addOrder(Order order) {		
		String sql = "insert into orders values(?,?,?,?,?)"; 
		Connection son;
		try {
			son = Database.Openconnection(); 
			PreparedStatement ps = son.prepareStatement(sql); 
			 
			ps.setInt(1,order.getOrderID()); 
			ps.setDate(2, order.getOrderDate()); 
			ps.setInt(3, order.getCustomerID()); 
			ps.setInt(4, order.getEmployeeID()); 
			ps.setFloat(5, order.getTotal()); 
			 
			return ps.executeUpdate() > 0;
			 
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		} 		
		return false;
	}

	@Override
	public boolean updateOrderTotal(int orderId) {
		String sql = "update orders set total=? where order_id=?"; 		
		try {
			Connection	son = Database.Openconnection(); 
			PreparedStatement ps = son.prepareStatement(sql); 
			  
			float total = 1000 ;
			ps.setInt(2,orderId); 
			ps.setFloat(1, total); 
		
			return ps.executeUpdate() > 0;
			 
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		} 
		
		return false;
	}

	@Override
	public void DoublecomputeOrderTotal(int orderId) {
		String sql = "select total(?)"; 
		
		try {
			Connection	son = Database.Openconnection(); 
			PreparedStatement ps = son.prepareStatement(sql); 
			 
			ps.setFloat(1, orderId);  
			 
			ResultSet rs = ps.executeQuery(); 
			 
			while(rs.next()) { 
				System.out.println(rs.getInt(1));
			}
		 
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	
	}

}
