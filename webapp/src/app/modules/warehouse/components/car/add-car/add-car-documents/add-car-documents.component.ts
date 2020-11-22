import { Component, OnInit } from '@angular/core';
import {DataService} from "../../../../service/data.service";

@Component({
  selector: 'app-add-car-documents',
  templateUrl: './add-car-documents.component.html',
  styleUrls: ['./add-car-documents.component.css']
})
export class AddCarDocumentsComponent implements OnInit {
  car: any;
  submitted?: Boolean;

  constructor(public dataService: DataService) { }

  ngOnInit(): void {
  }

  process() {
    this.dataService.number = 3;
  }
}
