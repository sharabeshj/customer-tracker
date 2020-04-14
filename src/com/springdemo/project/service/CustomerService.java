package com.springdemo.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.project.DAO.CustomerDAOInfo;
import com.springdemo.project.entity.Customer;

@Service
public class CustomerService implements CustomerServiceInt {
	@Autowired
	private CustomerDAOInfo customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public boolean addCustomer(Customer customer) {
		if(customerDAO.addCustomer(customer)) return true;
		return false;
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public boolean updateCustomer(Customer customer) {
		return customerDAO.updateCustomer(customer);
	}

	@Override
	@Transactional
	public void deleteCustomer(Customer customer) {
		customerDAO.deleteCustomer(customer);
	}
	
}
