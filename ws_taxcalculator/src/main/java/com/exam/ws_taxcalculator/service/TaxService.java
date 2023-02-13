package com.exam.ws_taxcalculator.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.ws_taxcalculator.dto.TaxDTO;
import com.exam.ws_taxcalculator.entity.Employee;
import com.exam.ws_taxcalculator.repository.EmployeeRepository;


@Service
public class TaxService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public TaxDTO getTaxAmount(int employeeId) {
		Employee emp=employeeRepository.findByEmpId(employeeId);
		System.out.println(emp.getDateOfJoining().getMonthValue());
		LocalDate endDate = null;
		if(emp.getDateOfJoining().getMonthValue()<=3)
		{
			
			endDate=LocalDate.of(emp.getDateOfJoining().getYear(),3,31);
			
		}else{
			endDate= LocalDate.of(emp.getDateOfJoining().getYear()+1,3,31);
		}
		    
		    long months = ChronoUnit.MONTHS.between(LocalDate.parse(emp.getDateOfJoining().toString()),
		    		endDate);
		   

	     double annualSalary=emp.getSalary().doubleValue()*months;
		double taxDeduction=0.0;
		    if(annualSalary<250000)
		    {
		    	taxDeduction=0;
		    }
		    
		    else if (annualSalary > 250000 && annualSalary <= 500000.0) {
				taxDeduction = ((0.05) * annualSalary);
			} 
		    else if (annualSalary > 500000.0 && annualSalary <= 1000000.0) {
		    	annualSalary = annualSalary - 500000.0;
				taxDeduction = (((0.2) * annualSalary) + 12500.0);
			} else if (annualSalary > 1000000.0) {
				annualSalary = annualSalary - 1000000.0;
				taxDeduction = (((0.3 / 100) * annualSalary) + 112500.0);
			}

		    TaxDTO tax=new TaxDTO();
		    tax.setEmployeeCode(emp.getEmpId());
		    tax.setFirstName(emp.getFirstName());
		    tax.setLastName(emp.getLastName());
		    double cess=0.0;
		    if(annualSalary>2500000 )
		    {
		    	double amount=annualSalary-2500000;
		    	cess=amount*0.02;
		    	
		    }
		    tax.setCessAmount(new BigDecimal(cess));
		    tax.setTaxAmount(new BigDecimal(taxDeduction));
		return tax;
	}

}
