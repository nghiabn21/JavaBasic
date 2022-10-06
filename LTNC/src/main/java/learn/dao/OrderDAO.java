package learn.dao;

import java.util.List;

import learn.entities.Order;

public interface OrderDAO {
	List<Order> getAllOrdersByCustomerId(int customerId); 
	 
	boolean addOrder(Order order); 
	 
	boolean updateOrderTotal(int orderId); 
	 
	void DoublecomputeOrderTotal(int orderId);
}
