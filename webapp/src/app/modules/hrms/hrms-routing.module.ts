import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {HrmsComponent} from "./hrms.component";
import {RouterModule, Routes} from "@angular/router";
import {ListEmployeesComponent} from "./list-employees/list-employees.component";
import {HireEmployeeComponent} from "./hire-employee/hire-employee.component";
import {GiveSalaryComponent} from "./give-salary/give-salary.component";
import {EmployeeProfileComponent} from "./employee-profile/employee-profile.component";
import {ArchiveComponent} from "./archive/archive.component";
import {FireEmployeeComponent} from "./fire-employee/fire-employee.component";
import {VacationComponent} from "./vacation/vacation.component";
import {TimeCardComponent} from "./time-card/time-card.component";


export class HrRoutes {
static hrRoutes: Routes = [
  {
    path: '',
    component: HrmsComponent,
    children: [
      {path: 'hr', component: HrmsComponent}
    ],
  },
  {
    path: 'hire',
    component: HireEmployeeComponent,
    children: [
      {path: 'hr', component: HrmsComponent}
    ],
  },
  {
    path: 'fire',
    component: FireEmployeeComponent,
    children: [
      {path: 'hr', component: HrmsComponent}
    ],
  },
  {
    path: 'list',
    component: ListEmployeesComponent,
    children: [
      {path: 'hr', component: HrmsComponent}
    ],
  },
  {
    path: 'salary',
    component: GiveSalaryComponent,
    children: [
      {path: 'hr', component: HrmsComponent}
    ],
  },
  {
    path: 'profile/:id',
    component: EmployeeProfileComponent,
    children: [
      {path: 'hr', component: HrmsComponent}
    ],
  },
  {
    path: 'archive',
    component: ArchiveComponent,
    children: [
      {path: 'hr', component: HrmsComponent}
    ],
  }, {
    path: 'vacation',
    component: VacationComponent,
    children: [
      {path: 'hr', component: HrmsComponent}
    ],
  }, {
    path: 'time-card',
    component: TimeCardComponent,
    children: [
      {path: 'hr', component: HrmsComponent}
    ],
  },
];
}

@NgModule({
  imports: [RouterModule.forChild(HrRoutes.hrRoutes)],
  exports: [RouterModule]
})
export class HrmsRoutingModule { }
