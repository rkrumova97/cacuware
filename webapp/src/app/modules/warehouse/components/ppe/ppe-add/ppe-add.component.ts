import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ppe-add',
  templateUrl: './ppe-add.component.html',
  styleUrls: ['./ppe-add.component.css']
})
export class PpeAddComponent implements OnInit {
  ppe: any;
  submitted!: Boolean;

  constructor() { }

  ngOnInit(): void {
  }

  process() {

  }
}
