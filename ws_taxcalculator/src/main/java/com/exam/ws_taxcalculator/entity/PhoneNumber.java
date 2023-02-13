package com.exam.ws_taxcalculator.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Entity
@Data
@NoArgsConstructor
public class PhoneNumber {

	@Id
	@GeneratedValue
	private int phoneNumberId;
	@Pattern(regexp = "^\\d{10}$", message = "invalid mobile number entered ")
	private String phoneNumber;
}