import { Component, OnInit } from '@angular/core';
import {Material} from "../../../model/material.model";

@Component({
  selector: 'app-material-add',
  templateUrl: './material-add.component.html',
  styleUrls: ['./material-add.component.css']
})
export class MaterialAddComponent implements OnInit {
  material!: Material;
  submitted!: Boolean;

  constructor() { }

  ngOnInit(): void {
  }

  process() {

  }
}
