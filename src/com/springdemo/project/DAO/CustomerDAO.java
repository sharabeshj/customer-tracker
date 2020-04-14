package com.springdemo.project.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdemo.project.entity.Customer;

@Repository
public class CustomerDAO implements CustomerDAOInfo {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer order by lastName",Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
	}
	
	@Override
	public boolean addCustomer(Customer customer) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(customer);
			return true;
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}
		
	}

	@Override
	public Customer getCustomer(int id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			return session.get(Customer.class, id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.createQuery("update from Customer c set c.firstName='"+customer.getFirstName()
					+ "',c.lastName='"+customer.getLastName()+"', c.email='"+ customer.getEmail() 
					+"' where c.id=" + customer.getId()).executeUpdate();
			return true;
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}
	}

	@Override
	public void deleteCustomer(Customer customer) {
		try {
			Session session = sessionFactory.getCurrentSession();
			customer = session.get(Customer.class, customer.getId());
			session.delete(customer);
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
	
}
