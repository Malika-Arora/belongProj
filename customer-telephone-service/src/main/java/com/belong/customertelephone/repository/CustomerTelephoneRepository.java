package com.belong.customertelephone.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.belong.customertelephone.models.Customer;
import com.belong.customertelephone.models.CustomerTelephone;

@Repository
public interface CustomerTelephoneRepository extends CrudRepository<CustomerTelephone, Integer> {
	List<CustomerTelephone> findByCustomer(Customer customerId);

	CustomerTelephone findByCustomerAndPhoneNumber(Customer customer, String phoneNumber);
}