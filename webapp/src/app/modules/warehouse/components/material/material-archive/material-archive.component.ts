import { Component, OnInit } from '@angular/core';
import {Material} from "../../../model/material.model";
import {WarehouseService} from "../../../service/warehouse.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {Company} from "../../../model/company.model";

@Component({
  selector: 'app-material-archive',
  templateUrl: './material-archive.component.html',
  styleUrls: ['./material-archive.component.css']
})
export class MaterialArchiveComponent implements OnInit {
  materials!: Material[];
  companies!: Company[];

  constructor(private warehouseService: WarehouseService, private modalService: NgbModal) {
    this.warehouseService.getResource("/companies").subscribe(r => {
      this.companies = r;
    });
  }

  ngOnInit(): void {
    this.warehouseService.getResource("/materials/archive").subscribe(res => {
      this.materials = res;
      console.log(this.materials)
    });

  }


  getCompany(uuid: any) : string {
    let name: string | undefined | null = "";
    this.companies.forEach(company => {
      name = company.id == uuid ? company.name : null;
    });
    return name;
  }
}
