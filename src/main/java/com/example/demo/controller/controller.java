package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;

import com.example.demo.repository.Customerdao;

@RestController
public class controller {

	@Autowired
	Customerdao f1;
	
	@GetMapping("/get")
	public List<Customer> getDetails()
	{
		System.out.println("Retrieved All the Details Present In The Table");
		return f1.findAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteDetails(@PathVariable("id") Long id)
	{
		f1.deleteById(id);
		return "Id : "+id+" is deleted";
	}
	
	@PostMapping("/post")
	public String postDetails(@RequestBody Customer b1)
	{
		f1.save(b1);
		return "Customer Details Successfully Saved In The DataBase";
	}
	
	@PutMapping("/put/{id}")
	public Customer updateCustomerDetails(@RequestBody Customer b)
	{
		System.out.println("The Changes Made Have Been Successfully Updated");
		return f1.save(b);
		
	}
}
