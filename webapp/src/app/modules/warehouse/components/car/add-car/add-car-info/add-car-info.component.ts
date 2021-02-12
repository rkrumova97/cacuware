import { Component, OnInit } from '@angular/core';
import {DataService} from "../../../../service/data.service";
import {Car} from "../../../../model/car.model";

@Component({
  selector: 'app-add-car-info',
  templateUrl: './add-car-info.component.html',
  styleUrls: ['./add-car-info.component.css']
})
export class AddCarInfoComponent implements OnInit {
  car!: Car;
  submitted?: Boolean;
  success!: boolean;

  constructor(public dataService: DataService) { }

  ngOnInit(): void {
  }

  process() {
    this.dataService.number = 2;
  }

  close() {
    this.success = true;
  }
}
