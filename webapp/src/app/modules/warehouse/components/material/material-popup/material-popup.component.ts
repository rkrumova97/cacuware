import {Component, Input, OnInit} from '@angular/core';
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {WarehouseService} from "../../../service/warehouse.service";
import {Router} from "@angular/router";
import {Company} from "../../../model/company.model";
import {Material} from "../../../model/material.model";

@Component({
  selector: 'app-material-popup',
  templateUrl: './material-popup.component.html',
  styleUrls: ['./material-popup.component.css']
})
export class MaterialPopupComponent implements OnInit {

  modal: NgbActiveModal;

  http: WarehouseService;
  router: Router;

  @Input() material!: Material;

  constructor(http: WarehouseService, router: Router, modal: NgbActiveModal) {
    this.http = http;
    this.router = router;
    this.modal = modal;
  }

  ngOnInit(): void{
    console.log(this.material);
  }

  delete(id: string | null | undefined): string {
    console.log(this.material);

    this.http.deleteResource("/materials/" + id, id)
      .subscribe(r => {
        console.log(r);
      });

    this.modal.close();
    return "null";
  }


}
