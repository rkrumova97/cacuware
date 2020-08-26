import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HrmsComponent} from './hrms.component';

import {HrmsRoutingModule} from "./hrms-routing.module";
import {HireEmployeeComponent} from "./components/hire-employee-personal-info/hire-employee.component";
import {TimeCardComponent} from "./components/time-card/time-card.component";
import {GiveSalaryComponent} from "./components/give-salary/give-salary.component";
import {EmployeeProfileComponent} from "./components/employee-profile/employee-profile.component";
import {VacationComponent} from "./components/vacation/vacation.component";
import {ArchiveComponent} from "./components/archive/archive.component";
import {FireEmployeeComponent} from "./components/fire-employee/fire-employee.component";
import {ListEmployeesComponent} from "./components/list-employees/list-employees.component";
import {FormsModule} from "@angular/forms";
import { HireEmployeeDetailsComponent } from './components/hire-employee-details/hire-employee-details.component';
import { HireSensitiveInfoComponent } from './components/hire-sensitive-info/hire-sensitive-info.component';


@NgModule({
  declarations: [HrmsComponent, HireEmployeeComponent, ListEmployeesComponent, GiveSalaryComponent, EmployeeProfileComponent, ArchiveComponent, VacationComponent, FireEmployeeComponent, TimeCardComponent, HireEmployeeDetailsComponent, HireSensitiveInfoComponent],
  imports: [
    CommonModule,
    HrmsRoutingModule,
    FormsModule
  ]
})
export class HrmsModule {
}
