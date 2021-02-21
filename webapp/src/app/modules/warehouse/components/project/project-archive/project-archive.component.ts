import { Component, OnInit } from '@angular/core';
import {Project} from "../../../model/project.model";
import {WarehouseService} from "../../../service/warehouse.service";
import {Material} from "../../../model/material.model";
import {Employee} from "../../../../hrms/model/employee.model";
import {Car} from "../../../model/car.model";
import {HrmsService} from "../../../../hrms/service/hrms.service";
import {Company} from "../../../model/company.model";

@Component({
  selector: 'app-project-archive',
  templateUrl: './project-archive.component.html',
  styleUrls: ['./project-archive.component.css']
})
export class ProjectArchiveComponent implements OnInit {
  projects!: Project[];
  materials!: Material[];
  people!: Employee[];
  cars!: Car[];
  companies!: Company[];

  constructor(private warehouseService: WarehouseService, private hrmsService: HrmsService) { }

  ngOnInit(): void {
    this.warehouseService.getResource("/projects/archive").subscribe(res => {
      this.projects = res;
    });
    this.warehouseService.getResource("/materials").subscribe(res => {
      this.materials = res;
    })
    this.hrmsService.getResource("/employees").subscribe(res => {
      this.people = res;
    })
    this.warehouseService.getResource("/cars").subscribe(res => {
      this.cars = res;
    })
    this.warehouseService.getResource("/companies").subscribe(res => {
      this.companies = res;
    })

  }

  open() {

  }

  data() {

  }

  getCompany(uuid: string): string {
    let name: string | undefined | null = "";
    this.companies.forEach(company => {
      name = company.id == uuid ? company.name : null;
    });
    return name;
  }
}
