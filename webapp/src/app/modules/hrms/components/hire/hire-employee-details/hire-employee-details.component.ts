import {Component, OnInit} from '@angular/core';
import {Employee} from "../../../model/employee.model";
import {HrmsService} from "../../../service/hrms.service";
import {DataService} from "../../../service/data.service";

@Component({
  selector: 'app-hire-employee-details',
  templateUrl: './hire-employee-details.component.html',
  styleUrls: ['./hire-employee-details.component.css']
})
export class HireEmployeeDetailsComponent implements OnInit {
  employee!: Employee;
  jobs?: string[];
  submitted = false;
  dropdownSettings = {};


  workingDays = [
    {name: 'Three days a week', value: 3},
    {name: 'Four days a week', value: 4},
    {name: 'Five days a week', value: 5}
  ];
  workingHours = [
    {name: 'Four hours a day', value: 4},
    {name: 'Six hours a day', value: 6},
    {name: 'Eight hours a day', value: 8}
  ];

  constructor(private hrmsService:HrmsService, private dataService: DataService) {

  }

  ngOnInit(): void {
    this.employee = new Employee();
    this.employee.person = this.dataService.person;
    this.dropdownSettings = {
      singleSelection: false,
      idField: 'item_id',
      textField: 'item_text',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };


  }

  process() {
    this.hrmsService.postResource("/employees", this.employee).subscribe();
    this.dataService.employee = this.employee;
  }
}
