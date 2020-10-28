import {Component, Input} from '@angular/core';

import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {Router} from "@angular/router";
import {Employee} from "../../model/employee.model";
import {HrmsService} from "../../service/hrms.service";

@Component({
  selector: 'app-popup',
  templateUrl: './popup.component.html',
})
export class PopupComponent {

  modal: NgbActiveModal;

  employees?: Employee[];
  http: HrmsService;
  router: Router;

  @Input() employee!: Employee;

  constructor(http: HrmsService, router: Router, modal: NgbActiveModal) {
    this.http = http;
    this.router = router;
    this.modal = modal;
  }

  fire(id: string | null | undefined): string {
    console.log(id);

    this.http.getResource('/employees/fire/' + id)
      .subscribe(r => {
        console.log(r);
        this.router.navigate(['/hr/archive']);
      });

    this.modal.close();
    return "null";
  }
}
