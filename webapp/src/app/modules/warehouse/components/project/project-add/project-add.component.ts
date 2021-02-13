import { Component, OnInit } from '@angular/core';
import {Project} from "../../../model/project.model";

@Component({
  selector: 'app-project-add',
  templateUrl: './project-add.component.html',
  styleUrls: ['./project-add.component.css']
})
export class ProjectAddComponent implements OnInit {
  success: boolean = true;
  project!: Project;
  submitted!: Boolean;

  constructor() { }

  ngOnInit(): void {
  }

  close() {

  }

  process() {

  }
}
