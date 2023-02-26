package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;

import jakarta.transaction.Transactional;


@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {

	
	@Query("select s from Customer s")
	List<Customer>findAllCustomerQuary();

	@Modifying
	@Transactional
	@Query("Update Customer set name= :name where id= :id")
	Integer update(Long id, String name);
	
	@Modifying
	@Transactional
	@Query("Delete from Customer where name=:name")
	Integer delete(String name);

	}



