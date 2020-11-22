import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-car-materials',
  templateUrl: './add-car-materials.component.html',
  styleUrls: ['./add-car-materials.component.css']
})
export class AddCarMaterialsComponent implements OnInit {
  car: any;
  submitted?: Boolean;

  constructor() { }

  ngOnInit(): void {
  }

  process() {

  }
}
