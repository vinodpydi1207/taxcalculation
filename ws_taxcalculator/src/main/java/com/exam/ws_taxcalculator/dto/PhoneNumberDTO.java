package com.exam.ws_taxcalculator.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class PhoneNumberDTO {


	@Pattern(regexp = "^\\d{10}$", message = "invalid mobile number entered ")
	private String phoneNumber;
}
