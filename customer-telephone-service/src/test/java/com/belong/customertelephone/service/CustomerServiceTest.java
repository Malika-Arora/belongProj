package com.belong.customertelephone.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.belong.customertelephone.application.CustomerTelephoneServiceApplication;
import com.belong.customertelephone.dto.CustomerTelephoneDTO;
import com.belong.customertelephone.exception.CustomNotFoundException;
import com.belong.customertelephone.models.CustomerTelephone;

@SpringBootTest(classes = {CustomerTelephoneServiceApplication.class})
@ActiveProfiles("test")
@AutoConfigureMockMvc
@ContextConfiguration
public class CustomerServiceTest {
	@Autowired
	private CustomerService customerService;

	@Test
	public void testGetAllNumbers() throws Exception {
		List<CustomerTelephoneDTO> customerTelephoneDTO = customerService.getAllNumbers();
		assertNotNull(customerTelephoneDTO);
		assertEquals(4, customerTelephoneDTO.size());
	}

	@Test
	public void testGetAllNumbersByCustomerId() throws Exception {

		List<CustomerTelephoneDTO> customerTelephoneDTO = customerService.getAllNumbersByCustomerId(1);
		assertNotNull(customerTelephoneDTO);
		assertEquals(2, customerTelephoneDTO.size());
	}

	@Test
	public void testUpdateTelephoneStatus() throws Exception {

		CustomerTelephone customerTelephone = customerService.updateTelephoneStatus(1, "+61469880141", true);
		assertNotNull(customerTelephone);
		assertEquals(true, customerTelephone.isActive());
	}

	@Test
	public void testUpdateTelephoneStatust_NoRecord() throws Exception {

		assertThrows(CustomNotFoundException.class, () -> customerService.getAllNumbersByCustomerId(4),
				"Customer not found");
	}

	@Test
	public void testUpdateTelephoneStatus_NoRecord() throws Exception {

		assertThrows(CustomNotFoundException.class,
				() -> customerService.updateTelephoneStatus(4, "+61469880141", true), "Customer not found");
		assertThrows(CustomNotFoundException.class,
				() -> customerService.updateTelephoneStatus(1, "+61469880144", true),
				"Customer with this telephone not found");
	}

}
