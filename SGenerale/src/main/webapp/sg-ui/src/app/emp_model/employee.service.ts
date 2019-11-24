import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from './employee';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) { 
}

public fetchEmployees(): Observable<Employee[]>{
	return this.http.get<Employee[]>('http://localhost:8080/api/emplist');
}

public saveEmployee(employee: Employee){
	return this.http.post<Employee>('http://localhost:8080/api/empsave', employee);
}

}
