import { Component, OnInit } from '@angular/core';
import {Ppe} from "../../../model/ppe.model";
import {WarehouseService} from "../../../service/warehouse.service";
import {PopupComponent} from "../../popup/popup.component";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-ppe-list',
  templateUrl: './ppe-list.component.html',
  styleUrls: ['./ppe-list.component.css']
})
export class PpeListComponent implements OnInit {
  ppes!: Ppe[];

  constructor(private warehouseService: WarehouseService, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.warehouseService.getResource("/ppes").subscribe(res => {
      this.ppes = res;
    });
  }

  data() {

  }

  open(ppe: Ppe) {
    const modalRef = this.modalService.open(PopupComponent, {centered: true});
    modalRef.componentInstance.company = ppe;
    modalRef.componentInstance.url = "/ppes/delete";
  }
}
