import { Component, OnInit } from '@angular/core';
import {Company} from "../../../model/company.model";

@Component({
  selector: 'app-company-add',
  templateUrl: './company-add.component.html',
  styleUrls: ['./company-add.component.css']
})
export class CompanyAddComponent implements OnInit {
  success: boolean = true;
  company!: Company;
  submitted!: Boolean;

  constructor() { }

  ngOnInit(): void {
  }

  close() {
    this.success = true;
  }

  process() {
    this.success = true
  }
}
