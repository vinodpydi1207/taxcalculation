package com.exam.ws_taxcalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.ws_taxcalculator.dto.EmployeeDTO;
import com.exam.ws_taxcalculator.entity.Employee;
import com.exam.ws_taxcalculator.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
  
	@Autowired
	private EmployeeService employeeService;
	

	@PostMapping("/save")
	public ResponseEntity<Employee> saveStudent1(@RequestBody EmployeeDTO employee) {
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);

	}
	
	
}
