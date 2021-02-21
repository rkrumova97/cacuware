import { Component, OnInit } from '@angular/core';
import {Car} from "../../../../model/car.model";
import {Material} from "../../../../model/material.model";
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {WarehouseService} from "../../../../service/warehouse.service";

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

  constructor(private http: HttpClient, private router: Router,
              private warehouseService: WarehouseService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.car = new Car();
    if (this.route.snapshot.paramMap.get('id') !== undefined && this.route.snapshot.paramMap.get('id') !== null) {
      this.warehouseService.getOneResource("/api/warehouse/cars" + this.route.snapshot.paramMap.get('id')).subscribe(res => {
        this.car = res;
      });
    }
  }

  process() {
    this.warehouseService.postResource("/cars", this.car).subscribe(r => {
      this.success = true;
      this.car = r;
    }, () => this.success = false);
  }

  close() {
    this.success = true;
  }
}
