import {Component, OnInit} from '@angular/core';
import {Employee} from "../../model/employee.model";
import {HrmsService} from "../../service/hrms.service";
import {ActivatedRoute} from "@angular/router";
import {Person} from "../../model/person.model";

@Component({
  selector: 'app-employee-profile',
  templateUrl: './employee-profile.component.html',
  styleUrls: ['./employee-profile.component.css']
})
export class EmployeeProfileComponent implements OnInit {

  id?: string | null;
  employee!: Employee;
  http: HrmsService;

  constructor(private route: ActivatedRoute, http: HrmsService) {
    this.http = http;
  }

  ngOnInit() {
    this.employee = new Employee(new Person());

    this.id = this.route.snapshot.paramMap.get('id');
    this.http.getOneResource('/employees/' + this.id).subscribe(res => {
      this.employee = res;
      console.log(this.employee);
    });
  }


}
