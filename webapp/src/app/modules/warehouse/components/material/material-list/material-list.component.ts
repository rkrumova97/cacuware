import { Component, OnInit } from '@angular/core';
import {Material} from "../../../model/material.model";
import {WarehouseService} from "../../../service/warehouse.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {PopupComponent} from "../../popup/popup.component";
import {MaterialPopupComponent} from "../material-popup/material-popup.component";

@Component({
  selector: 'app-material-list',
  templateUrl: './material-list.component.html',
  styleUrls: ['./material-list.component.css']
})
export class MaterialListComponent implements OnInit {
  materials!: Material[];

  constructor(private warehouseService: WarehouseService, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.warehouseService.getResource("/materials").subscribe(res => {
      this.materials = res;
    });
  }

  open(material: Material) {
    const modalRef = this.modalService.open(MaterialPopupComponent, {centered: true});
    modalRef.componentInstance.material = material;
  }

  data() {

  }
}
