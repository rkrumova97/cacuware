import {NgModule} from '@angular/core';
import {HrmsComponent} from "./hrms.component";
import {RouterModule, Routes} from "@angular/router";
import {FireEmployeeComponent} from "./components/fire-employee/fire-employee.component";
import {ListEmployeesComponent} from "./components/list-employees/list-employees.component";
import {GiveSalaryComponent} from "./components/give-salary/give-salary.component";
import {EmployeeProfileComponent} from "./components/employee-profile/employee-profile.component";
import {ArchiveComponent} from "./components/archive/archive.component";
import {VacationComponent} from "./components/vacation/vacation.component";
import {TimeCardComponent} from "./components/time-card/time-card.component";
import {HireEmployeeComponent} from "./components/hire/hire-employee-personal-info/hire-employee.component";
import {HireEmployeeDetailsComponent} from "./components/hire/hire-employee-details/hire-employee-details.component";
import {HireSensitiveInfoComponent} from "./components/hire/hire-sensitive-info/hire-sensitive-info.component";
import {HireFilesComponent} from "./components/hire/hire-files/hire-files.component";



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
      path: 'employee-details',
      component: HireEmployeeDetailsComponent,
      children: [
        {path: 'hr', component: HrmsComponent}
      ],
    },
    {
      path: 'sensitive-info',
      component: HireSensitiveInfoComponent,
      children: [
        {path: 'hr', component: HrmsComponent}
      ],
    },
    {
      path: 'documents',
      component: HireFilesComponent,
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
export class HrmsRoutingModule {
}
