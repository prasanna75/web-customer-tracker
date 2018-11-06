package com.springmvc.hibernate.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.hibernate.springdemo.dao.CustomerDAO;
import com.springmvc.hibernate.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//Injecting Customers DAO
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model themodel) {
		
		//get customers from DAO
		List<Customer> customers = customerDAO.getCustomers();
		
		//add customer to the model so that the data 
		//can be transfered or manipulated from controller
		themodel.addAttribute("customersList", customers);
		
		
		return "list-customers";
	}
	
}
