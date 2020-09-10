import { Component, OnInit } from '@angular/core';
import {Employee} from "../../model/employee.model";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {map, startWith} from "rxjs/operators";
import {Observable} from "rxjs";
import {FormControl} from "@angular/forms";

function search(employees: Employee[], text: string): Employee[] {
  return employees.filter(employee => {
    const term = text.toLowerCase();
    return employee.person.firstName!.toLowerCase().includes(term);
  });
}

@Component({
  selector: 'app-fire-employee',
  templateUrl: './fire-employee.component.html',
  styleUrls: ['./fire-employee.component.css']
})
export class FireEmployeeComponent implements OnInit {

  employees$?: Observable<Employee[]>;
  filter = new FormControl('');

  constructor(http: HttpClient) {
    this.http = http;
  }

  http: HttpClient;
  employees: Employee[] = [];

  headElements = ['ID', 'First Name', 'Middle Name', 'Last Name', 'Job Type', 'Salary'];

  searchText = '';

  dataSource: any;

  ngOnInit() {
    this.http.get<Employee[]>('http://localhost:8080/employees').subscribe(res => {
      this.employees = res;
      console.log(this.employees);
    });

    this.employees$ = this.filter.valueChanges.pipe(
      startWith(''),
      map(text => search(this.employees, text))
    );
  }

  onClickButton(position: any) {
    this.http.get<Employee[]>('http://localhost:8080/position/' + position).subscribe((res: Employee[]) => {
      this.employees = res;
      console.log(this.employees);
    });
  }

  updateList(employee: Employee, property: string, event: any) {
    employee[property] = event.target.textContent;
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json;charset=UTF-8',
      })
    };
    console.log(JSON.stringify(this.employees));
    this.http.post<Employee>('http://localhost:8080/employees', JSON.stringify(this.employees), httpOptions)
      .subscribe((r: any) => {
        console.log(r);
      });
  }

  excel() {

  }



}
