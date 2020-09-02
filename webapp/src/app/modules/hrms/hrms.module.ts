import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HrmsComponent} from './hrms.component';

import {HrmsRoutingModule} from "./hrms-routing.module";
import {TimeCardComponent} from "./components/time-card/time-card.component";
import {GiveSalaryComponent} from "./components/give-salary/give-salary.component";
import {EmployeeProfileComponent} from "./components/employee-profile/employee-profile.component";
import {VacationComponent} from "./components/vacation/vacation.component";
import {ArchiveComponent} from "./components/archive/archive.component";
import {FireEmployeeComponent} from "./components/fire-employee/fire-employee.component";
import {ListEmployeesComponent} from "./components/list-employees/list-employees.component";
import {FormsModule} from "@angular/forms";
import {HireEmployeeDetailsComponent} from "./components/hire/hire-employee-details/hire-employee-details.component";
import {HireSensitiveInfoComponent} from "./components/hire/hire-sensitive-info/hire-sensitive-info.component";
import {HireEmployeeComponent} from "./components/hire/hire-employee-personal-info/hire-employee.component";
import { HireFilesComponent } from './components/hire/hire-files/hire-files.component';



@NgModule({
  declarations: [HrmsComponent, HireEmployeeComponent, ListEmployeesComponent, GiveSalaryComponent, EmployeeProfileComponent, ArchiveComponent, VacationComponent, FireEmployeeComponent, TimeCardComponent, HireEmployeeDetailsComponent, HireSensitiveInfoComponent, HireFilesComponent],
  imports: [
    CommonModule,
    HrmsRoutingModule,
    FormsModule
  ]
})
export class HrmsModule {
}
