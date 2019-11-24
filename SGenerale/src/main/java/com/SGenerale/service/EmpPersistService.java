package com.SGenerale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SGenerale.entity.Employee;
import com.SGenerale.repository.EmployeeRepository;

@Service
@Transactional
public class EmpPersistService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public String persistEmployee(Employee emp) {
		try {
			List<Employee> empInDbs = employeeRepository.findAll();
			for(Employee empInDb: empInDbs) {
				if(empInDb.getfName().equalsIgnoreCase(emp.getfName())
						&& empInDb.getlName().equalsIgnoreCase(emp.getlName())
						&& empInDb.getGender().equalsIgnoreCase(emp.getGender())
						&& empInDb.getDob().isEqual(emp.getDob())
						&& empInDb.getDept().equalsIgnoreCase(emp.getDept())) {
					return "Warn";
				}
			}
			employeeRepository.save(emp);
			return "Success";
		}
		catch(Exception e) {
			return e.toString();
		}
	}
}
