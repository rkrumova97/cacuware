import {Component, Input, OnInit} from '@angular/core';
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {WarehouseService} from "../../../service/warehouse.service";
import {Router} from "@angular/router";
import {Car} from "../../../model/car.model";

@Component({
  selector: 'app-car-popup',
  templateUrl: './car-popup.component.html',
  styleUrls: ['./car-popup.component.css']
})
export class CarPopupComponent implements OnInit {

  modal: NgbActiveModal;

  http: WarehouseService;
  router: Router;

  @Input() car!: Car;

  constructor(http: WarehouseService, router: Router, modal: NgbActiveModal) {
    this.http = http;
    this.router = router;
    this.modal = modal;
  }

  ngOnInit(): void{
    console.log(this.car);
  }

  delete(id: string | null | undefined): string {
    console.log(this.car);

    this.http.deleteResource("/cars/" + id, id)
      .subscribe(r => {
        console.log(r);
      });

    this.modal.close();
    return "null";
  }


}
