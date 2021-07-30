package com.belong.customertelephone.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.belong.customertelephone.dto.CustomerTelephoneDTO;
import com.belong.customertelephone.exception.CustomBadRequestException;
import com.belong.customertelephone.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/v1/telephone")
public class CustomerTelephoneController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(path = "/getAllNumbers")
	@Operation(description = "${sw.customerservice.operation.getAllNumbers}", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content) })
	public ResponseEntity<List<CustomerTelephoneDTO>> getAllNumbers(){
		List<CustomerTelephoneDTO> response = customerService.getAllNumbers();
		return ResponseEntity.ok(response);
		
	}
	
	
	@GetMapping(path = "/getNumbersByCustomer/{customerId}")
	@Operation(description = "${sw.customerservice.operation.getNumbersByCustomer}", responses = {
			@ApiResponse(responseCode = "200", description = "Success"),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content) })
	public ResponseEntity<List<CustomerTelephoneDTO>> getNumbersByCustomer(@PathVariable(value = "customerId") String customerId){
		if (!StringUtils.isNumeric(customerId)) {
		       throw new CustomBadRequestException("Invalid customerId. Please input number only");
	   }
		List<CustomerTelephoneDTO> response = customerService.getAllNumbersByCustomerId(Integer.parseInt(customerId));
		return ResponseEntity.ok(response);
		
	}
			
	 @PatchMapping("updateTelephoneStatus/{customerId}/{phoneNumber}/{active}")
	 @Operation(description = "${sw.customerservice.operation.updateTelephoneStatus}", responses = {
	            @ApiResponse(responseCode = "200", description = "OK"),
	            @ApiResponse(responseCode = "400", description = "Bad Request"),
	            @ApiResponse(responseCode = "404", description = "Not Found"),
	            @ApiResponse(responseCode = "500", description = "Internal server error")
	    })
	    public ResponseEntity<String> updateTelephoneStatus(@PathVariable(value = "customerId") String customerId,
	    		@PathVariable(value = "phoneNumber") String phoneNumber,
	    		@PathVariable(value = "active") boolean active){
		 if (!StringUtils.isNumeric(customerId)) {
		       throw new CustomBadRequestException("Invalid customerId. Please input number only");
		 }
		 if (StringUtils.isEmpty(phoneNumber)) {
		       throw new CustomBadRequestException("Invalid phoneNumber. Please input valid phoneNumber only");
		 }
		 customerService.updateTelephoneStatus(Integer.parseInt(customerId),phoneNumber, active );
		 return ResponseEntity.ok("Successfully updated");
	 }
	    		

}
