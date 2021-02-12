import { Component, OnInit } from '@angular/core';
import {Car} from "../../../../model/car.model";
import {Material} from "../../../../model/material.model";

@Component({
  selector: 'app-add-car-materials',
  templateUrl: './add-car-materials.component.html',
  styleUrls: ['./add-car-materials.component.css']
})
export class AddCarMaterialsComponent implements OnInit {
  car!: Car;
  material!: Material;
  submitted?: Boolean;
  success!: boolean;

  constructor() { }

  ngOnInit(): void {
  }

  process() {

  }

  close() {
    this.success = true;
  }
}
