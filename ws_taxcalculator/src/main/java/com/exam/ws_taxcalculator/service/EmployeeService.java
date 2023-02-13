package com.exam.ws_taxcalculator.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.ws_taxcalculator.dto.EmployeeDTO;
import com.exam.ws_taxcalculator.dto.PhoneNumberDTO;
import com.exam.ws_taxcalculator.entity.Employee;
import com.exam.ws_taxcalculator.entity.PhoneNumber;
import com.exam.ws_taxcalculator.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee saveEmployee(EmployeeDTO employee) {
		
		
		Employee emp = new  Employee();
		emp.setEmpId(employee.getEmpId());
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmail(employee.getEmail());
		emp.setDateOfJoining(employee.getDateOfJoining());
		emp.setSalary(employee.getSalary());
		List<PhoneNumber> phoneNumbers = new ArrayList();
		for(PhoneNumberDTO phnNum :employee.getPhoneNumbers())
		{
			PhoneNumber phoneNumber = new PhoneNumber(); 
			phoneNumber.setPhoneNumber(phnNum.getPhoneNumber());
			phoneNumbers.add(phoneNumber);
		}
		emp.setPhoneNumbers(phoneNumbers);
		return employeeRepository.save(emp);
	}


}
