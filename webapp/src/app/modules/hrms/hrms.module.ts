import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HrmsComponent } from './hrms.component';
import { HireEmployeeComponent } from './hire-employee/hire-employee.component';
import { ListEmployeesComponent } from './list-employees/list-employees.component';
import { GiveSalaryComponent } from './give-salary/give-salary.component';
import { EmployeeProfileComponent } from './employee-profile/employee-profile.component';
import { ArchiveComponent } from './archive/archive.component';
import {HrmsRoutingModule} from "./hrms-routing.module";
import { VacationComponent } from './vacation/vacation.component';
import { FireEmployeeComponent } from './fire-employee/fire-employee.component';
import { TimeCardComponent } from './time-card/time-card.component';



@NgModule({
  declarations: [HrmsComponent, HireEmployeeComponent, ListEmployeesComponent, GiveSalaryComponent, EmployeeProfileComponent, ArchiveComponent, VacationComponent, FireEmployeeComponent, TimeCardComponent],
  imports: [
    CommonModule,
    HrmsRoutingModule
  ]
})
export class HrmsModule { }
