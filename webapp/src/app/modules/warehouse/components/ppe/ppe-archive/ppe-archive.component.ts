import { Component, OnInit } from '@angular/core';
import {Ppe} from "../../../model/ppe.model";
import {WarehouseService} from "../../../service/warehouse.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-ppe-archive',
  templateUrl: './ppe-archive.component.html',
  styleUrls: ['./ppe-archive.component.css']
})
export class PpeArchiveComponent implements OnInit {

  ppes!: Ppe[];

  constructor(private warehouseService: WarehouseService, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.warehouseService.getResource("/ppes").subscribe(res => {
      this.ppes = res;
    });
  }

  open() {

  }
}
