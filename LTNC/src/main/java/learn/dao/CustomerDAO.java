package learn.dao;

import java.util.List;

import learn.entities.Customer;

public interface CustomerDAO { 
	 List<Customer> getAllCustomer(); 
	  
	 boolean updateCustomer(Customer customer); 
	  
	 boolean addCustomer(Customer customer); 
	  
	 boolean deleteCustomer(int customerId);

}
