import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-save-employee',
  templateUrl: './save-employee.component.html',
  styleUrls: ['./save-employee.component.css']
})
export class SaveEmployeeComponent implements OnInit {
	
	emp: Employee;
	startDate: Date;
	pipe: DatePipe;
	localeValue: string;
	maxDate: Date;

  constructor(private toastr: ToastrService, private employeeService: EmployeeService) { 
	this.emp = new Employee();
	this.maxDate = new Date();
}

  ngOnInit() {
	this.startDate = new Date(1990, 0, 1);
  }

onSubmit(){
	this.pipe = new DatePipe('en-US');
	this.emp.dob = this.pipe.transform(this.emp.dob, 'yyyy-MM-dd');
	this.employeeService.saveEmployee(this.emp).subscribe(response => this.afterSubmit(response));
}

afterSubmit(response){
	if(response.Status == 1){
		this.toastr.success(response.Message);
	}
	else if(response.Status == 2){
		this.toastr.warning(response.Message);
	}
	else{
		this.toastr.error(response.Message);
	}
}

}
