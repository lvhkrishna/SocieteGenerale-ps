import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-get-employee',
  templateUrl: './get-employee.component.html',
  styleUrls: ['./get-employee.component.css']
})
export class GetEmployeeComponent implements OnInit {
	
  emps: Employee[];

  constructor(private employeeService: EmployeeService) { }

  ngOnInit() {
	this.employeeService.fetchEmployees().subscribe(data => {
		this.emps = data;
	});
  }

  sortBy(prop: string) {
	if(this.emps.length > 0){
		return this.emps.sort((a, b) => a[prop] > b[prop] ? 1 : a[prop] <= b[prop] ? -1 : 0);
	}
  }

}
