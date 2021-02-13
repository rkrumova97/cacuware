import {Component, OnInit} from '@angular/core';
import {Project} from "../../../model/project.model";
import {WarehouseService} from "../../../service/warehouse.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {PopupComponent} from "../../popup/popup.component";

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements OnInit {
  projects!: Project[];

  constructor(private warehouseService: WarehouseService, private modalService: NgbModal) {
  }

  ngOnInit(): void {
    this.warehouseService.getResource("/projects").subscribe(res => {
      this.projects = res;
    });
  }

  data() {

  }

  open(project: Project) {
    const modalRef = this.modalService.open(PopupComponent, {centered: true});
    modalRef.componentInstance.company = project;
    modalRef.componentInstance.url = "/projects/delete";


  }
}
