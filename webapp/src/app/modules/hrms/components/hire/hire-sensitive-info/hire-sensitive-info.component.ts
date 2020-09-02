import {Component, OnInit} from '@angular/core';
import {ISecurityData, SecurityDataModel} from "../../../model/security-data.model";

@Component({
  selector: 'app-hire-sensitive-info',
  templateUrl: './hire-sensitive-info.component.html',
  styleUrls: ['./hire-sensitive-info.component.css']
})
export class HireSensitiveInfoComponent implements OnInit {
  security!: SecurityDataModel;
  jobs?: string[];
  submitted?: Boolean;
  dropdownSettings = {};

  constructor() {
  }

  ngOnInit(): void {
    this.security = new SecurityDataModel();

  }

  process() {

  }
}
