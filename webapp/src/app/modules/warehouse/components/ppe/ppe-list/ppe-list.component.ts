import { Component, OnInit } from '@angular/core';
import {Ppe} from "../../../model/ppe.model";
import {WarehouseService} from "../../../service/warehouse.service";
import {PopupComponent} from "../../popup/popup.component";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {PpePopupComponent} from "../ppe-popup/ppe-popup.component";
import {Company} from "../../../model/company.model";

@Component({
  selector: 'app-ppe-list',
  templateUrl: './ppe-list.component.html',
  styleUrls: ['./ppe-list.component.css']
})
export class PpeListComponent implements OnInit {
  ppes!: Ppe[];
  companies!: Company[];

  constructor(private warehouseService: WarehouseService, private modalService: NgbModal) {
    this.warehouseService.getResource("/companies").subscribe(res => {
      this.companies = res;
    });
  }

  ngOnInit(): void {
    this.warehouseService.getResource("/ppes").subscribe(res => {
      this.ppes = res;
    });
  }

  data() {

  }

  open(ppe: Ppe) {
    const modalRef = this.modalService.open(PpePopupComponent, {centered: true});
    modalRef.componentInstance.ppe = ppe;
  }

  getCompany(uuid: string): string {
    let name: string | undefined | null = "";
    this.companies.forEach(company => {
      name = company.id == uuid ? company.name : null;
    });
    return name;
  }
}
