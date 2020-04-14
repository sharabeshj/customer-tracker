package com.springdemo.project.DAO;

import java.util.List;

import com.springdemo.project.entity.Customer;

public interface CustomerDAOInfo {
	public List<Customer> getCustomers();

	public boolean addCustomer(Customer customer);
	
	public Customer getCustomer(int id);
	
	public boolean updateCustomer(Customer customer);
	
	public void deleteCustomer(Customer customer);
}
