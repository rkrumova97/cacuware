import { Component, OnInit } from '@angular/core';
import {Employee, IEmployee} from "../../model/employee.model";
import {SecurityDataModel} from "../../model/security-data.model";

@Component({
  selector: 'app-hire-sensitive-info',
  templateUrl: './hire-sensitive-info.component.html',
  styleUrls: ['./hire-sensitive-info.component.css']
})
export class HireSensitiveInfoComponent implements OnInit {
  security?: SecurityDataModel;
  jobs?: string[];
  submitted?: Boolean;
  dropdownSettings = {};


  workingDays = [
    { name: 'Three days a week', value: 3 },
    { name: 'Four days a week', value: 4 },
    { name: 'Five days a week', value: 5 }
  ];
  workingHours = [
    { name: 'Four hours a day', value: 4 },
    { name: 'Six hours a day', value: 6 },
    { name: 'Eight hours a day', value: 8 }
  ];

  constructor() { }

  ngOnInit(): void {
    this.employee = new Employee();

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

  }
}
