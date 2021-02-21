import {Component, OnInit} from '@angular/core';
import {Material} from "../../../model/material.model";
import {WarehouseService} from "../../../service/warehouse.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {MaterialPopupComponent} from "../material-popup/material-popup.component";
import {Company} from "../../../model/company.model";

@Component({
  selector: 'app-material-list',
  templateUrl: './material-list.component.html',
  styleUrls: ['./material-list.component.css']
})
export class MaterialListComponent implements OnInit {
  materials!: Material[];
  companies!: Company[];

  constructor(private warehouseService: WarehouseService, private modalService: NgbModal) {
    this.warehouseService.getResource("/companies").subscribe(res => {
      this.companies = res;
    });
  }

  ngOnInit(): void {
    this.warehouseService.getResource("/materials").subscribe(res => {
      this.materials = res;
    });
  }

  open(material: Material) {
    const modalRef = this.modalService.open(MaterialPopupComponent, {centered: true});
    modalRef.componentInstance.material = material;
  }

  getCompany(uuid: string): string {
    let name: string | undefined | null = "";
    this.companies.forEach(company => {
      name = company.id == uuid ? company.name : null;
    });
    return name;
  }
}
