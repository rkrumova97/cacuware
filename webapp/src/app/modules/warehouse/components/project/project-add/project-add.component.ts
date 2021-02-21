import {Component, OnInit} from '@angular/core';
import {Project} from "../../../model/project.model";
import {Employee} from "../../../../hrms/model/employee.model";
import {WarehouseService} from "../../../service/warehouse.service";
import {HrmsService} from "../../../../hrms/service/hrms.service";
import {Company} from "../../../model/company.model";
import {Car} from "../../../model/car.model";
import {Material} from "../../../model/material.model";

@Component({
  selector: 'app-project-add',
  templateUrl: './project-add.component.html',
  styleUrls: ['./project-add.component.css']
})
export class ProjectAddComponent implements OnInit {
  success: boolean = true;
  project!: Project;
  submitted!: Boolean;
  employees!: Employee[];
  selectedEmployees: string[] = [];
  selectedCars: string[] = [];
  cars!: Car[];
  selectedMaterials: string[] = [];
  materials!: Material[];
  companies!: Company[];
  company!: Company;

  constructor(private warehouseService: WarehouseService, private hrmsService: HrmsService) {
    this.hrmsService.getResource("/employees").subscribe(r => {
      this.employees = r;
    });
    this.warehouseService.getResource("/companies").subscribe(r => {
      this.companies = r;
    });
    this.warehouseService.getResource("/cars").subscribe(r => {
      this.cars = r;
    });
    this.warehouseService.getResource("/materials").subscribe(r => {
      this.materials = r;
    });
  }

  ngOnInit(): void {
    this.project = new Project()
  }

  close() {
    this.success = true;
  }

  process() {
    this.project.people = [];
    this.selectedEmployees.forEach(employee => {
      if (employee!= null) {
        this.project.people!.push(employee)
      }
    });

    this.project.company = this.company.id;

    this.project.cars = [];
    this.selectedCars.forEach(car => {
      if (car != null) {
        this.project.cars!.push(car)
      }
    });
    this.project.materials = [];
    this.selectedMaterials.forEach(material => {
      if (material != null) {
        this.project.materials!.push(material)
      }
    });

    console.log(this.project.materials);
    this.warehouseService.postResource("/projects", this.project).subscribe(r => {
      this.success = true;
      this.project = r;
    }, () => this.success = false);
  }
}
