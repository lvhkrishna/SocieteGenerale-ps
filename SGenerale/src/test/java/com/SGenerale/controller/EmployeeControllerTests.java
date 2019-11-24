package com.SGenerale.controller;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.SGenerale.entity.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTests {

	@Autowired
	private EmployeeController employeeController;
	
	@Test
	public void getEmployeesTest() {
		List<Employee> emps = employeeController.getEmployees();
		assertNotNull(emps);
	}
	
	@Test
	public void saveEmployeesTest() throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		LocalDate dob = LocalDate.of(1995, Month.JUNE, 19);
		Employee emp = new Employee("Emp", "One", "Male", dob, "IT");
		ResponseEntity<Map<String, Object>> response = employeeController.saveEmployee(emp);
		assertEquals(200, response.getStatusCodeValue());
//		assertEquals("Employee data saved successfully", response.getBody().get("Message"));
	}
}
