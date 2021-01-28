import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-archive',
  templateUrl: './archive.component.html',
  styleUrls: ['./archive.component.css']
})
export class ArchiveComponent implements OnInit {


  isClicked?: boolean;
  router: Router;
  employees: any;

  constructor( router: Router) {
    this.router = router;
  }

  ngOnInit() {
    this.isClicked = true;
    // this.hrmsService.getResource("/employees/archive").subscribe(res => {
    //   this.employees = res;
    // });
  }
}
