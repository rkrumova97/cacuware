import { Component, OnInit } from '@angular/core';
import {Car} from "../../../../model/car.model";

@Component({
  selector: 'app-add-car-materials',
  templateUrl: './add-car-materials.component.html',
  styleUrls: ['./add-car-materials.component.css']
})
export class AddCarMaterialsComponent implements OnInit {
  car!: Car;
  submitted?: Boolean;

  constructor() { }

  ngOnInit(): void {
  }

  process() {

  }
}
