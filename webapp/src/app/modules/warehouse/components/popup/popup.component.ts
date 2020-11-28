import {Component} from '@angular/core';

import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {Router} from "@angular/router";

@Component({
  selector: 'app-popup',
  templateUrl: './popup.component.html',
})
export class PopupComponent {

  modal: NgbActiveModal;

  router: Router;


  constructor(router: Router, modal: NgbActiveModal) {
    this.router = router;
    this.modal = modal;
  }

  fire(id: string | null | undefined): string {
    console.log(id);


    this.modal.close();
    return "null";
  }
}
