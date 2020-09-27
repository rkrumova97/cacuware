import {Component, OnInit} from '@angular/core';
import {SecurityDataModel} from "../../../model/security-data.model";
import {HrmsService} from "../../../service/hrms.service";
import {DataService} from "../../../service/data.service";
import {Employee} from "../../../model/employee.model";
import {Person} from "../../../model/person.model";
import {Route, Router} from "@angular/router";

@Component({
  selector: 'app-hire-sensitive-info',
  templateUrl: './hire-sensitive-info.component.html',
  styleUrls: ['./hire-sensitive-info.component.css']
})
export class HireSensitiveInfoComponent implements OnInit {
  security!: SecurityDataModel;
  submitted?: Boolean;
  success: boolean = true;


  constructor(private hrmsService: HrmsService, private dataService: DataService, private router:Router) {
  }

  ngOnInit(): void {
    this.security = new SecurityDataModel();
  }

  process() {
    this.hrmsService.postResource("/securityData", this.security).subscribe(r => {
      this.router.navigate(['/hr/documents']);
      this.success = true;
    }, error => this.success = false);
    let employee = this.dataService.employee ? this.dataService.employee : new Employee(new Person());
    employee.securityData = this.security;
    this.hrmsService.updateResource("/employees", employee).subscribe();
  }

  close() {
    this.success = true;
  }
}
