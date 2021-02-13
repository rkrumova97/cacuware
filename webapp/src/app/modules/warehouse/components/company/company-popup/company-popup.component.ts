import {Component, Input, OnInit} from '@angular/core';
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {HrmsService} from "../../../../hrms/service/hrms.service";
import {Router} from "@angular/router";
import {Company} from "../../../model/company.model";
import {WarehouseService} from "../../../service/warehouse.service";

@Component({
  selector: 'app-company-popup',
  templateUrl: './company-popup.component.html',
  styleUrls: ['./company-popup.component.css']
})
export class CompanyPopupComponent implements OnInit {
  modal: NgbActiveModal;

  http: WarehouseService;
  router: Router;

  @Input() company!: Company;

  constructor(http: WarehouseService, router: Router, modal: NgbActiveModal) {
    this.http = http;
    this.router = router;
    this.modal = modal;
  }

  ngOnInit(): void{
    console.log(this.company);
  }

  delete(id: string | null | undefined): string {
    console.log(this.company);

    this.http.deleteResource("/companies/" + id, id)
      .subscribe(r => {
        console.log(r);
      });

    this.modal.close();
    return "null";
  }

}
