import { Component, OnInit } from '@angular/core';
import {Employee} from "../../model/employee.model";
import {HrmsService} from "../../service/hrms.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-archive',
  templateUrl: './archive.component.html',
  styleUrls: ['./archive.component.css']
})
export class ArchiveComponent implements OnInit {

  employees?: Employee[];
  hrmsService: HrmsService;
  isClicked?: boolean;
  router: Router;

  constructor(hrmsService:HrmsService, router: Router) {
    this.hrmsService = hrmsService;
    this.router = router;
  }

  ngOnInit() {
    this.isClicked = true;
    this.hrmsService.getResource("/employees/archive").subscribe(res => {
      this.employees = res;
    });
  }
}
