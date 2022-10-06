package learn.dao;

import java.util.List;

import learn.entities.LineItem;

public interface LineItemDAO {
	List <LineItem> getAllItemsByOrderId(int orderId); 
	 
	boolean addLineItem(LineItem item);
}
