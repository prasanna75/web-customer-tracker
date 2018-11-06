package com.springmvc.hibernate.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.hibernate.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	
	//here we need to inject the session factory 
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
		Session currentSession= sessionFactory.getCurrentSession();
		
		//Create QUERY
		Query<Customer> theQuery= currentSession.createQuery("from Customer",Customer.class);
		
		//EXECUTE QUERY AND GET RESULTS
			List<Customer> CustomersList = theQuery.getResultList();	
		
		//return results
		return CustomersList;
	}

}
