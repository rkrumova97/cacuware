import { Component, OnInit } from '@angular/core';
import {DataService} from "../../../../service/data.service";

@Component({
  selector: 'app-add-car-info',
  templateUrl: './add-car-info.component.html',
  styleUrls: ['./add-car-info.component.css']
})
export class AddCarInfoComponent implements OnInit {
  car: any;
  submitted?: Boolean;

  constructor(public dataService: DataService) { }

  ngOnInit(): void {
  }

  process() {
    this.dataService.number = 2;
  }
}
