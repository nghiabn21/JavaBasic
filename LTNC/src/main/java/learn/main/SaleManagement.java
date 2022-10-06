package learn.main;

import java.sql.Date;

import learn.dao.CustomerDAO;
import learn.dao.CustomerDAOImpl;
import learn.dao.LineItemDAOImpl;
import learn.dao.OrderDAOImpl;
import learn.entities.Customer;
import learn.entities.LineItem;
import learn.entities.Order;

public class SaleManagement {

	public static void main(String[] args) {
		CustomerDAOImpl cus = new CustomerDAOImpl(); 
//		System.out.println(cus.getAllCustomer());   
		Customer cs = new Customer();  
//		cs.setCustomerName("Ngọc Châu"); 
//		cus.addCustomer(cs); 
	//	cus.deleteCustomer(2);
//		cus.updateCustomer(cs);
//		
		
		OrderDAOImpl or = new OrderDAOImpl(); 
//		System.out.println(or.getAllOrdersByCustomerId(1));  
//		Order o = new Order(2,null, 1,1,20f);  
//		or.addOrder(o); 
	//	or.updateOrderTotal(1);  
		or.DoublecomputeOrderTotal(2);
		
		
		 
		LineItemDAOImpl line = new LineItemDAOImpl(); 
//		System.out.println(line.getAllItemsByOrderId(1)); 
//		LineItem line1 = new LineItem(2, 2, 20, 200); 
//		line.addLineItem(line1);

	}

}
