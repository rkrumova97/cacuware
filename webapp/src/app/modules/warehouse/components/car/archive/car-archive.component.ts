import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'car-archive',
  templateUrl: './car-archive.component.html',
  styleUrls: ['./car-archive.component.css']
})
export class CarArchiveComponent implements OnInit {
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

  open() {

  }
}
