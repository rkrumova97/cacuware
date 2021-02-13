import {Component, Input, OnInit} from '@angular/core';

import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {Router} from "@angular/router";
import {HrmsService} from "../../../hrms/service/hrms.service";
import {FileService} from "../../../hrms/service/file.service";
import {EmailService} from "../../../hrms/service/email.service";

@Component({
  selector: 'app-popup',
  templateUrl: './popup.component.html',
})
export class PopupComponent implements OnInit{

  modal: NgbActiveModal;

  http: HrmsService;
  router: Router;

  @Input() object!: any;
  @Input() url!: string;

  constructor(http: HrmsService, router: Router, modal: NgbActiveModal) {
    this.http = http;
    this.router = router;
    this.modal = modal;
  }

  ngOnInit(): void{
    console.log(this.object, this.url);
  }

  delete(id: string | null | undefined): string {
    console.log(this.object);

    this.http.deleteResource(this.url + id, id)
      .subscribe(r => {
        console.log(r);
      });

    this.modal.close();
    return "null";
  }
}
