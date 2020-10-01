import { Component, OnInit } from '@angular/core';
import {DataService} from "../../../service/data.service";

@Component({
  selector: 'app-hire-files',
  templateUrl: './hire-files.component.html',
  styleUrls: ['./hire-files.component.css']
})
export class HireFilesComponent implements OnInit {
  success: boolean = true;
  id?: string;

  constructor( private dataService: DataService) { }

  ngOnInit(): void {
    this.id = this.dataService.employee?.id;
  }

  process() {

  }

  close() {
    this.success = true;
  }
}
