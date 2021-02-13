import { Component, OnInit } from '@angular/core';
import {Material} from "../../../model/material.model";
import {WarehouseService} from "../../../service/warehouse.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-material-archive',
  templateUrl: './material-archive.component.html',
  styleUrls: ['./material-archive.component.css']
})
export class MaterialArchiveComponent implements OnInit {
  materials!: Material[];

  constructor(private warehouseService: WarehouseService, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.warehouseService.getResource("/materials/archive").subscribe(res => {
      this.materials = res;
    });
  }


  open() {

  }
}
