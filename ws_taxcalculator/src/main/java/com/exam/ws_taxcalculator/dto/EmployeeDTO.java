package com.exam.ws_taxcalculator.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
	@Id
	@NotNull(message = "Employee Id shouldn't be null")
	private int empId;
	@NotNull(message = "firstName shouldn't be null")
	private String firstName;
	@NotNull(message = "lastName shouldn't be null")
	private String lastName;
	@Email(message = "invalid email address")
	private String email;
	@NotNull(message = "dateOfJoining shouldn't be null")
	private LocalDate dateOfJoining;
	@NotNull(message = "salary shouldn't be null")
	private BigDecimal salary;
	
	private List<PhoneNumberDTO> phoneNumbers;
    
    
}
