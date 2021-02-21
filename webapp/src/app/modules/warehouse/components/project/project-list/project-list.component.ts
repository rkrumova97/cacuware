import {Component, OnInit} from '@angular/core';
import {Project} from "../../../model/project.model";
import {WarehouseService} from "../../../service/warehouse.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {PopupComponent} from "../../popup/popup.component";
import {ProjectPopupComponent} from "../project-popup/project-popup.component";
import {Material} from "../../../model/material.model";
import {Employee} from "../../../../hrms/model/employee.model";
import {HrmsService} from "../../../../hrms/service/hrms.service";
import {Car} from "../../../model/car.model";

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements OnInit {
  projects!: Project[];
  materials!: Material[];
  people!: Employee[];
  cars!: Car[];

  constructor(private warehouseService: WarehouseService, private hrmsService: HrmsService,
              private modalService: NgbModal) {
  }

  ngOnInit(): void {
    this.warehouseService.getResource("/projects").subscribe(res => {
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
  }

  data() {

  }

  open(project: Project) {
    const modalRef = this.modalService.open(ProjectPopupComponent, {centered: true});
    modalRef.componentInstance.project = project;
  }
}
