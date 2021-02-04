import { Component, OnInit } from '@angular/core';
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {PopupComponent} from "../../popup/popup.component";
import {DataService} from "../../../service/data.service";

@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css']
})
export class CarListComponent implements OnInit {

  constructor(public modalService: NgbModal, private dataService: DataService) { }

  ngOnInit(): void {
  }

  open() {
    const modalRef = this.modalService.open(PopupComponent, {centered: true});
  }

  data() {
    this.dataService.number = 4;
  }
}
