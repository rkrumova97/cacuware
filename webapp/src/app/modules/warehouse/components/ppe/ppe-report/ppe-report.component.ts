import { Component, OnInit } from '@angular/core';
import {Ppe} from "../../../model/ppe.model";
import {Employee} from "../../../../hrms/model/employee.model";
import {WarehouseService} from "../../../service/warehouse.service";
import {HrmsService} from "../../../../hrms/service/hrms.service";

@Component({
  selector: 'app-ppe-report',
  templateUrl: './ppe-report.component.html',
  styleUrls: ['./ppe-report.component.css']
})
export class PpeReportComponent implements OnInit {
  ppes!: Ppe[];
  employee!: Employee;
  people!: Employee[];
  private success: boolean = false;

  constructor(private warehouseService:WarehouseService, private hrmsService:HrmsService) { }

  ngOnInit(): void {
    this.hrmsService.getResource("/employees").subscribe(r => {
      this.people = r;
    });
    this.warehouseService.getResource("/ppes").subscribe(r => {
      this.ppes = r;
    });
  }

  process() {
    this.warehouseService.updateResource("/ppes/report", this.ppes).subscribe(r => {
      this.success = true;
      this.ppes = r;
    }, () => this.success = false);
  }

  setPeople(ppe: Ppe, person: Employee) {
    ppe.people = [];
    ppe.people?.push(person);
  }
}
