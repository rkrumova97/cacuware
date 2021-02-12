import { Component, OnInit } from '@angular/core';
import {Project} from "../../../model/project.model";
import {WarehouseService} from "../../../service/warehouse.service";

@Component({
  selector: 'app-project-archive',
  templateUrl: './project-archive.component.html',
  styleUrls: ['./project-archive.component.css']
})
export class ProjectArchiveComponent implements OnInit {
  projects!: Project[];

  constructor(private warehouseService: WarehouseService) { }

  ngOnInit(): void {
    this.warehouseService.getResource("/projects/archive").subscribe(res => {
      this.projects = res;
    });
  }

  open() {

  }

  data() {

  }
}
