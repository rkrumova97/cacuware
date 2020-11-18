import { Component, OnInit } from '@angular/core';
import {Employee} from "../../model/employee.model";
import {HrmsService} from "../../service/hrms.service";

@Component({
  selector: 'app-time-card',
  templateUrl: './time-card.component.html',
  styleUrls: ['./time-card.component.css']
})
export class TimeCardComponent implements OnInit {
  days?: string[] = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"];
  employees?: Employee[];

  constructor(private hrmsService:HrmsService) { }


  ngOnInit(): void {
    this.hrmsService.getResource("/employees").subscribe(res => {
      this.employees = res;
    });
  }

}
