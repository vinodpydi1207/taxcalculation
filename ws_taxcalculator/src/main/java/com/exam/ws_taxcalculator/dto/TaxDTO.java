package com.exam.ws_taxcalculator.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class TaxDTO {


	private int employeeCode;
	private String firstName;
	private String lastName;
	private BigDecimal taxAmount;
	private BigDecimal cessAmount;
}
