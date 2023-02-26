package com.example.demo.controller;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;

import com.example.demo.service.CustomerService;

	

	@RestController
	public class CustomerController {

		@Autowired
		CustomerService customerService;
		
		
		@GetMapping("/sortCustomers/{field}")
		public Iterable<Customer> CustomersSort(@PathVariable ("field") String field) {
			return customerService.sortCustomers(field);

		}

		@GetMapping(value = "/pagingCustomers/{pageNo}/{pageSize}")
		public Page<Customer> CustomersPaging(@PathVariable ("pageNo") int pageno,@PathVariable ("pageSize") int pageSize) {
			return customerService.pagingCustomers(pageno, pageSize);

		}
		

		@GetMapping(value = "/pagingSortingCustomers/{pageNo}/{pageSize}/{field}")
		public Page<Customer> CustomersPagingAndSorting(@PathVariable ("pageNo") int pageno,@PathVariable ("pageSize") int pageSize,@PathVariable ("field")String field) {
			return customerService.pagingAndSortingCustomers(pageno, pageSize,field);

		}
		@GetMapping(value="/select")
		public List<Customer> CustomersSelect() {
			return customerService.SelectCustomers();

		}
		@PutMapping(value="/update/{id}/{name}")
		public Integer updateCustomer(@PathVariable Long id,@PathVariable String name)
		{
			return customerService.updateCustomer(id,name);
			
		}
		@DeleteMapping(value="/delete/{name}")
		public Integer deleteCustomer(@PathVariable String name)
		{
			return customerService.deleteCustomer(name);
		}
}

