package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Cust")
public class Customer {

	@Id
	private Long id;

	private String name;
	private int price;
	private String Review;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getReview() {
		return Review;
	}
	public void setReview(String review) {
		Review = review;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", price=" + price + ", Review=" + Review + "]";
	}
	
	




	

	

	
}