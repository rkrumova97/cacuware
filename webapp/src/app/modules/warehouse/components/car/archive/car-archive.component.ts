import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {Car} from "../../../model/car.model";
import {WarehouseService} from "../../../service/warehouse.service";

@Component({
  selector: 'car-archive',
  templateUrl: './car-archive.component.html',
  styleUrls: ['./car-archive.component.css']
})
export class CarArchiveComponent implements OnInit {
  isClicked?: boolean;
  router: Router;
  employees: any;
  cars!: Car[];

  constructor( router: Router, private warehouseService: WarehouseService,) {
    this.router = router;
  }

  ngOnInit() {
    this.isClicked = true;
    this.warehouseService.getResource("/cars/archive").subscribe(res => {
      this.cars = res;
    });
  }

  open() {

  }
}
