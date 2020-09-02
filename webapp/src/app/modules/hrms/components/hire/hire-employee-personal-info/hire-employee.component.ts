import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {Person} from "../../../model/person.model";
import {PersonService} from "../../../service/person.service";


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

  constructor(http: HttpClient, router: Router, private personService: PersonService) {
    this.http = http;
    this.router = router;
  }

  ngOnInit() {
    this.person = new Person();
  }

  process(): void {
      this.personService.create(this.person).subscribe();
  }
}
