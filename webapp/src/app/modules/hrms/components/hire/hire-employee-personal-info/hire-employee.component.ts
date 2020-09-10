import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";
import {Person} from "../../../model/person.model";
import {HrmsService} from "../../../service/hrms.service";
import {SecurityService} from "../../../../security/security.service";
import {DataService} from "../../../service/data.service";


@Component({
  selector: 'app-hire-employee',
  templateUrl: './hire-employee.component.html',
  styleUrls: ['./hire-employee.component.css']
})
export class HireEmployeeComponent implements OnInit {

  grades?: string[];
  http: HttpClient;
  skills?: string[];
  person?: Person;
  genders = ['Male', 'Female', 'Other'];
  router: Router;
  dropdownSettings = {};

  submitted = false;
  isAdding = false;

  constructor(http: HttpClient, router: Router, private hrmsService: HrmsService, private dataService: DataService) {
    this.http = http;
    this.router = router;
  }

  ngOnInit() {
    this.person = new Person();
  }

  process(): void {
      this.hrmsService.postResource("/persons", this.person).subscribe(r => console.log("works"));
      this.dataService.person = this.person!;
  }
}
