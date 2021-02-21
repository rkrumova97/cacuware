import { Component, OnInit } from '@angular/core';
import {Projects} from "@angular/cli/lib/config/schema";
import {Material} from "../../../model/material.model";
import {Project} from "../../../model/project.model";
import {WarehouseService} from "../../../service/warehouse.service";
import {HrmsService} from "../../../../hrms/service/hrms.service";

@Component({
  selector: 'app-material-report',
  templateUrl: './material-report.component.html',
  styleUrls: ['./material-report.component.css']
})
export class MaterialReportComponent implements OnInit {
  materials!: Material[];
  projects!: Project[];
  submitted: Boolean = false;
  success: boolean = false;

  constructor(private warehouseService:WarehouseService) { }

  ngOnInit(): void {
    this.warehouseService.getResource("/materials").subscribe(r => {
      this.materials = r;
    });
    this.warehouseService.getResource("/projects").subscribe(r => {
      this.projects = r;
    });
  }


  process() {
    this.warehouseService.updateResource("/materials/report", this.materials).subscribe(r => {
      this.success = true;
      this.materials = r;
    }, () => this.success = false);
  }

}
