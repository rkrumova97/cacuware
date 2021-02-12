import { Component, OnInit } from '@angular/core';
import {Project} from "../../../model/project.model";
import {WarehouseService} from "../../../service/warehouse.service";

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements OnInit {
  projects!: Project[];

  constructor(private warehouseService: WarehouseService) { }

  ngOnInit(): void {
    this.warehouseService.getResource("/projects").subscribe(res => {
      this.projects = res;
    });
  }

  data() {

  }

  open() {

  }
}
