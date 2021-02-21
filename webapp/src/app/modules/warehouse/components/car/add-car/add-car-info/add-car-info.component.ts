import { Component, OnInit } from '@angular/core';
import {DataService} from "../../../../service/data.service";
import {Car} from "../../../../model/car.model";
import {Company} from "../../../../model/company.model";
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {WarehouseService} from "../../../../service/warehouse.service";

@Component({
  selector: 'app-add-car-info',
  templateUrl: './add-car-info.component.html',
  styleUrls: ['./add-car-info.component.css']
})
export class AddCarInfoComponent implements OnInit {
  car!: Car;
  submitted?: Boolean;
  success: boolean = true;

  constructor(public dataService: DataService, private http: HttpClient, private router: Router,
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
    this.dataService.number = 2;
    this.dataService.car = this.car;
    console.log(this.car);
  }

  close() {
    this.success = true;
  }
}
