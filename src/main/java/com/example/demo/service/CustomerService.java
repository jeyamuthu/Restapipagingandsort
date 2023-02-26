package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository Customerrepository;

	public Page<Customer> findAll(Pageable pageable) {
		return Customerrepository.findAll(pageable);
	}

	public List<Customer> getAllCustomers(Integer pageNo, Integer pageSize, String sortBy) {
		 Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

	        Page<Customer> pagedResult = Customerrepository.findAll(paging);

	        if(pagedResult.hasContent()) {
	            return pagedResult.getContent();
	        } else {
	            return new ArrayList<Customer>();
	        }
	}

	public Iterable<Customer> sortCustomers(String field) {
		
       //return CustomerRepository.findAll(Sort.by(field));
		return Customerrepository.findAll(Sort.by(Direction.DESC, field));
	}

	public Page<Customer> pagingCustomers(int page,int pageSize) {
		Pageable paging = PageRequest.of(page, pageSize);
		 return Customerrepository.findAll(paging);
		}
	
	public Page<Customer> pagingAndSortingCustomers(int offset,int pageSize,String field) {
		Pageable paging = PageRequest.of(offset, pageSize).withSort(Sort.by(field));
			return Customerrepository.findAll(paging);
		}

	public List<Customer> SelectCustomers() {
		return Customerrepository.findAllCustomerQuary();
	}

	public Integer updateCustomer(Long id, String name) {
		return Customerrepository.update(id,name);
		 
	}

	public Integer deleteCustomer(String name) {
		
		return Customerrepository.delete(name);
	}


}
