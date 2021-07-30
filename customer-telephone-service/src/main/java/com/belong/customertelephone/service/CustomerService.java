package com.belong.customertelephone.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belong.customertelephone.dto.CustomerTelephoneDTO;
import com.belong.customertelephone.exception.CustomNotFoundException;
import com.belong.customertelephone.models.Customer;
import com.belong.customertelephone.models.CustomerTelephone;
import com.belong.customertelephone.repository.CustomerRepository;
import com.belong.customertelephone.repository.CustomerTelephoneRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerTelephoneRepository customerTelephoneRepository;

	@Autowired
	private CustomerRepository customerRepository;

	public List<CustomerTelephoneDTO> getAllNumbers() {
		return ((List<CustomerTelephone>) customerTelephoneRepository.findAll()).stream().map(
				custTelephone -> new CustomerTelephoneDTO(custTelephone.getPhoneNumber(), custTelephone.isActive()))
				.collect(Collectors.toList());
	}

	public List<CustomerTelephoneDTO> getAllNumbersByCustomerId(int customerId) {
		List<CustomerTelephone> customerTelephonesList = customerTelephoneRepository
				.findByCustomer(findCustomerById(customerId));
		return customerTelephonesList.stream().map(
				custTelephone -> new CustomerTelephoneDTO(custTelephone.getPhoneNumber(), custTelephone.isActive()))
				.collect(Collectors.toList());
	}

	public CustomerTelephone updateTelephoneStatus(int customerId, String phoneNumber, boolean active) {
		CustomerTelephone customerTelephone = customerTelephoneRepository
				.findByCustomerAndPhoneNumber(findCustomerById(customerId), phoneNumber);
		if (customerTelephone != null) {
			customerTelephone.setActive(active);
			return customerTelephoneRepository.save(customerTelephone);
		}else {
			throw new CustomNotFoundException("Customer with this telephone not found");
		}
	}
	
	public Customer findCustomerById(int customerId) {
		Customer customer = customerRepository.findByCustomerId(customerId);
		if(customer == null) {
			throw new CustomNotFoundException("Customer not found");
		}else {
			return customer;
		}
		
	}

}
