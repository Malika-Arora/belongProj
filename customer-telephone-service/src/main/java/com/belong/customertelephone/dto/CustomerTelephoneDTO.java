package com.belong.customertelephone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerTelephoneDTO {
	
private String phoneNumber;
private boolean active;
}
