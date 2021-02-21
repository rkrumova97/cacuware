import {Component, OnInit} from '@angular/core';
import {DataService} from "../../../../service/data.service";
import {Car} from "../../../../model/car.model";
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {WarehouseService} from "../../../../service/warehouse.service";

@Component({
  selector: 'app-add-car-documents',
  templateUrl: './add-car-documents.component.html',
  styleUrls: ['./add-car-documents.component.css']
})
export class AddCarDocumentsComponent implements OnInit {
  car!: Car;
  submitted?: Boolean;
  success!: boolean;

  constructor(public dataService: DataService, private http: HttpClient, private router: Router,
              private warehouseService: WarehouseService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.car = new Car();
    if (this.route.snapshot.paramMap.get('id') !== undefined && this.route.snapshot.paramMap.get('id') !== null) {
      this.warehouseService.getOneResource("/api/warehouse/cars" + this.route.snapshot.paramMap.get('id')).subscribe(res => {
        this.car = res;
      });
    }
  }

  process() {
    this.dataService.number = 3;
    this.dataService.car = this.car;
  }

  close() {
    this.success = true;
  }
}
