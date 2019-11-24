package com.SGenerale.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SGenerale.entity.Employee;
import com.SGenerale.repository.EmployeeRepository;
import com.SGenerale.service.EmpPersistService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	EmpPersistService empPersistService;

	@GetMapping("/api/emplist")
	public List<Employee> getEmployees(){
		List<Employee> emps = employeeRepository.findAll();
		return emps;
	}
	
	@PostMapping("/api/empsave")
	public ResponseEntity<Map<String, Object>> saveEmployee(@RequestBody Employee emp) {
		HttpStatus status = HttpStatus.OK;
		Map<String, Object> response = new HashMap<String, Object>();
		String result = empPersistService.persistEmployee(emp);
		if(result.equals("Success")) {
			response.put("Status", 1);
			response.put("Message", "Employee data saved successfully");
		}
		else if(result.equals("Warn")) {
			response.put("Status", 2);
			response.put("Message", "Employee with same data already exists");
		}
		else {
			response.put("Status", 0);
			response.put("Message", result);
		}
		return new ResponseEntity<Map<String, Object>>(response, status);
	}
}
