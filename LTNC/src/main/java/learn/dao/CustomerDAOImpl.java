package learn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import learn.common.Database;
import learn.entities.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public  List<Customer> getAllCustomer() {
		String sql = "select * from customer" ;  
		List<Customer> list  = new ArrayList<Customer>(); 
		try {
			Connection con = Database.Openconnection(); 
			PreparedStatement pst = con.prepareStatement(sql); 
			 
			ResultSet rs = pst.executeQuery(); 
			
			while(rs.next()) { 
				Customer cs = new Customer(); 
				cs.setCustomerID(rs.getInt("customer_id")); 
				cs.setCustomerName(rs.getString("customer_name")); 
				list.add(cs); 
				System.out.println(rs.getInt("customer_id") + "\t" + rs.getString(2));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}  
		return list ;
		
	
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		
		String sql = "update customer set customer_name=? where customer_id=?"; 
		Connection son;
		try {
			son = Database.Openconnection(); 
			PreparedStatement ps = son.prepareStatement(sql); 
			 
			ps.setInt(2,customer.getCustomerID()); 
			ps.setString(1, customer.getCustomerName()); 
		
			return ps.executeUpdate() > 0;
			 
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		} 
		
		return false;
	}

	@Override
	public boolean addCustomer(Customer customer) {
		String sql = "call Employee(?)"; 
		Connection son;
		try {
			son = Database.Openconnection(); 
			PreparedStatement ps = son.prepareStatement(sql); 			 
			ps.setString(1,customer.getCustomerName()); 	 
			return ps.executeUpdate() > 0;
			 
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		} 
		
		return false;
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		String sql = "call dele(?)"; 
		Connection son;
		try {
			son = Database.Openconnection(); 
			PreparedStatement ps = son.prepareStatement(sql); 			 
			ps.setInt(1,customerId); 	 
			return ps.executeUpdate() > 0;
			 
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		} 
		
		return false;
	}

}
