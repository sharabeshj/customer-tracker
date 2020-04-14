package com.springdemo.project.service;

import java.util.List;

import com.springdemo.project.entity.Customer;

public interface CustomerServiceInt {
	public List<Customer> getCustomers();
	public boolean addCustomer(Customer customer);
	public Customer getCustomer(int id);
	public boolean updateCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
}
