import { Component, OnInit } from '@angular/core';
import {Company} from "../../../model/company.model";
import {WarehouseService} from "../../../service/warehouse.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {CompanyPopupComponent} from "../company-popup/company-popup.component";

@Component({
  selector: 'app-company-archive',
  templateUrl: './company-archive.component.html',
  styleUrls: ['./company-archive.component.css']
})
export class CompanyArchiveComponent implements OnInit {

  companies!: Company[];

  constructor(private warehouseService: WarehouseService, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.warehouseService.getResource("/companies/archive").subscribe(res => {
      this.companies = res;
    });
  }

  open(company: Company) {
    const modalRef = this.modalService.open(CompanyPopupComponent, {centered: true});
    modalRef.componentInstance.company = company;
  }

}
