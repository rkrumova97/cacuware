import {Component, Input, OnInit} from '@angular/core';
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {WarehouseService} from "../../../service/warehouse.service";
import {Router} from "@angular/router";
import {Material} from "../../../model/material.model";
import {Ppe} from "../../../model/ppe.model";

@Component({
  selector: 'app-ppe-popup',
  templateUrl: './ppe-popup.component.html',
  styleUrls: ['./ppe-popup.component.css']
})
export class PpePopupComponent implements OnInit {

  modal: NgbActiveModal;

  http: WarehouseService;
  router: Router;

  @Input() ppe!: Ppe;

  constructor(http: WarehouseService, router: Router, modal: NgbActiveModal) {
    this.http = http;
    this.router = router;
    this.modal = modal;
  }

  ngOnInit(): void{
    console.log(this.ppe);
  }

  delete(id: string | null | undefined): string {
    console.log(this.ppe);

    this.http.deleteResource("/ppes/" + id, id)
      .subscribe(r => {
        console.log(r);
      });

    this.modal.close();
    return "null";
  }

}
