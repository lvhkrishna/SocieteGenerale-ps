import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GetEmployeeComponent } from './emp_model/get-employee/get-employee.component';
import { SaveEmployeeComponent } from './emp_model/save-employee/save-employee.component';

const routes: Routes = [
	{ path: 'emplist', component: GetEmployeeComponent },
	{ path: 'empsave', component: SaveEmployeeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
