package com.exam.ws_taxcalculator.controller;

import java.time.Year;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.ws_taxcalculator.dto.TaxDTO;
import com.exam.ws_taxcalculator.service.TaxService;

@RestController
@RequestMapping("/tax")
public class TaxController {

	@Autowired
	private TaxService taxService;
	
	@GetMapping("/amount")
	public TaxDTO getTaxAmount(@RequestParam int employeeId)
	{
		return taxService.getTaxAmount(employeeId);
	}
	
}
