import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-car-report',
  templateUrl: './car-report.component.html',
  styleUrls: ['./car-report.component.css']
})
export class CarReportComponent implements OnInit {
  cars: any;

  constructor() { }

  ngOnInit(): void {
  }

}
