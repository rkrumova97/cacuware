import { Component, OnInit } from '@angular/core';
import {Material} from "../../../model/material.model";
import {WarehouseService} from "../../../service/warehouse.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {PopupComponent} from "../../popup/popup.component";

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
    const modalRef = this.modalService.open(PopupComponent, {centered: true});
    modalRef.componentInstance.company = material;
    modalRef.componentInstance.url = "/materials/delete";
  }

  data() {

  }
}
