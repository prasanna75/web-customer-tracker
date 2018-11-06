package com.springmvc.hibernate.springdemo.dao;

import java.util.List;

import com.springmvc.hibernate.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

}
