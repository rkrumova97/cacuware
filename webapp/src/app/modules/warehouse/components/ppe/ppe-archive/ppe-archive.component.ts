import { Component, OnInit } from '@angular/core';
import {Ppe} from "../../../model/ppe.model";
import {WarehouseService} from "../../../service/warehouse.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {Company} from "../../../model/company.model";

@Component({
  selector: 'app-ppe-archive',
  templateUrl: './ppe-archive.component.html',
  styleUrls: ['./ppe-archive.component.css']
})
export class PpeArchiveComponent implements OnInit {

  ppes!: Ppe[];
  companies!: Company[];

  constructor(private warehouseService: WarehouseService, private modalService: NgbModal) {
    this.warehouseService.getResource("/companies").subscribe(res => {
      this.companies = res;
    });
  }

  ngOnInit(): void {
    this.warehouseService.getResource("/ppes/archive").subscribe(res => {
      this.ppes = res;
    });
  }

  open() {

  }

  getCompany(uuid: string): string {
    let name: string | undefined | null = "";
    this.companies.forEach(company => {
      name = company.id == uuid ? company.name : null;
    });
    return name;
  }
}
