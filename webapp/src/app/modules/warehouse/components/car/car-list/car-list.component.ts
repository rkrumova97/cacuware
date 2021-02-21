import {Component, OnInit} from '@angular/core';
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {WarehouseService} from "../../../service/warehouse.service";
import {Car} from "../../../model/car.model";
import {CarPopupComponent} from "../car-popup/car-popup.component";

@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css']
})
export class CarListComponent implements OnInit {
  cars!: Car[];

  constructor(private warehouseService: WarehouseService, private modalService: NgbModal) {
  }

  ngOnInit(): void {
    this.warehouseService.getResource("/cars").subscribe(res => {
      this.cars = res;
    });
  }

  open(car: Car) {
    const modalRef = this.modalService.open(CarPopupComponent, {centered: true});
    modalRef.componentInstance.car = car;
  }

  data() {
  }
}
