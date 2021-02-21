import {Component, Input, OnInit} from '@angular/core';
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {WarehouseService} from "../../../service/warehouse.service";
import {Router} from "@angular/router";
import {Project} from "../../../model/project.model";

@Component({
  selector: 'app-project-popup',
  templateUrl: './project-popup.component.html',
  styleUrls: ['./project-popup.component.css']
})
export class ProjectPopupComponent implements OnInit {

  modal: NgbActiveModal;

  http: WarehouseService;
  router: Router;

  @Input() project!: Project;

  constructor(http: WarehouseService, router: Router, modal: NgbActiveModal) {
    this.http = http;
    this.router = router;
    this.modal = modal;
  }

  ngOnInit(): void {
    console.log(this.project);
  }

  delete(id: string | null | undefined): string {
    console.log(this.project);

    this.http.deleteResource("/projects/" + id, id)
      .subscribe(r => {
        console.log(r);
      });

    this.modal.close();
    return "null";
  }

}
