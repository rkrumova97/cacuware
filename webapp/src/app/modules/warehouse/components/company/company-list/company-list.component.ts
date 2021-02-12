import { Component, OnInit } from '@angular/core';
import {Company} from "../../../model/company.model";
import {WarehouseService} from "../../../service/warehouse.service";

@Component({
  selector: 'app-company-list',
  templateUrl: './company-list.component.html',
  styleUrls: ['./company-list.component.css']
})
export class CompanyListComponent implements OnInit {
  companies!: Company[];

  constructor(private warehouseService: WarehouseService) { }

  ngOnInit(): void {
    this.warehouseService.getResource("/companies").subscribe(res => {
      this.companies = res;
    });
  }

  open() {

  }

  data() {

  }
}
