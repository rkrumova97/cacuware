import { Component, OnInit } from '@angular/core';
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {PopupComponent} from "../../popup/popup.component";
import {DataService} from "../../../service/data.service";
import {WarehouseService} from "../../../service/warehouse.service";
import {Car} from "../../../model/car.model";

@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css']
})
export class CarListComponent implements OnInit {
  cars!: Car[];

  constructor(private warehouseService: WarehouseService, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.warehouseService.getResource("/cars").subscribe(res => {
      this.cars = res;
    });
  }
  open(car:Car) {
   const modalRef = this.modalService.open(PopupComponent, {centered: true});
    modalRef.componentInstance.company = car;
    modalRef.componentInstance.url = "/cars/delete";

  }

  data() {
   // this.dataService.number = 4;
  }
}
