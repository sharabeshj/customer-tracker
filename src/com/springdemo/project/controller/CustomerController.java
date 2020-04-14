package com.springdemo.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.project.DAO.CustomerDAOInfo;
import com.springdemo.project.entity.Customer;
import com.springdemo.project.service.CustomerService;
import com.springdemo.project.service.CustomerServiceInt;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerServiceInt customerService;
	
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "list-customers";
	}
	
	@GetMapping("/form")
	public String customerForm(Model model) {
		model.addAttribute("customer",  new Customer());
		return "customer-add";
	}
	
	@GetMapping("/form-update")
	public String customerUpdateForm(@RequestParam(name = "id") int id,Model model) {
		Customer customer = customerService.getCustomer(id);
		System.out.println(customer);
		if(customer != null) {
			customer.setId(id);
			model.addAttribute(customer);
			return "customer-update";
		}
		return "redirect:/customer/list";
	}
	
	@PostMapping("/add")
	public String addCustomer(@Valid @ModelAttribute("customer")Customer customer, BindingResult result,Model model) {
		if(result.hasErrors()) return "customer-add";
		if(customerService.addCustomer(customer))
		return "redirect:/customer/list";
		return "redirect:/customer/form";
	}
	
	@PostMapping("/update")
	public String updateCustomer(@Valid @ModelAttribute("customer")Customer customer, BindingResult result,Model model) {
		System.out.println(customer);
		if(result.hasErrors()) return "customer-update";
		if(customerService.updateCustomer(customer)) return "redirect:/customer/list";
		return "redirect:/customer/form-update?id="+customer.getId();
	}
	
	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam("id") int id) {
		Customer customer = customerService.getCustomer(id);
		if(customer != null)
		customerService.deleteCustomer(customer);
		return "redirect:/customer/list";
	}
}
