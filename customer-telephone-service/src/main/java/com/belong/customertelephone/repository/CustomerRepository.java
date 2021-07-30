package com.belong.customertelephone.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.belong.customertelephone.models.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	Customer findByCustomerId(int i);
}