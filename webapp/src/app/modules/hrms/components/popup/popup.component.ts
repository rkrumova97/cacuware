import {Component, Input} from '@angular/core';

import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {Router} from "@angular/router";
import {Employee} from "../../model/employee.model";
import {HrmsService} from "../../service/hrms.service";
import {FileService} from "../../service/file.service";
import {EmailService} from "../../service/email.service";
import * as fileSaver from "file-saver";

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

  constructor(http: HrmsService, router: Router, modal: NgbActiveModal,
              private fileService: FileService, private mailService: EmailService) {
    this.http = http;
    this.router = router;
    this.modal = modal;
  }

  fire(id: string | null | undefined): string {
    console.log(id);

    this.http.getResource('/employees/fire/' + id)
      .subscribe(r => {
        console.log(r);
        this.fileService.getFireDocuments(this.employee)
          .subscribe((response: any) => {
            let blob: any = new Blob([response.file], {type: response.fileType});
            this.mailService.sendFireEmail(this.employee).subscribe();
            fileSaver.saveAs(blob, response.fileName);
          }), () => console.log('Error downloading the file'),
          () => console.info('File downloaded successfully');
        this.router.navigate(['/hr/archive']);
      });

    this.modal.close();
    return "null";
  }
}
