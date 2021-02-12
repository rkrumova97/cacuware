import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-material-profile',
  templateUrl: './material-profile.component.html',
  styleUrls: ['./material-profile.component.css']
})
export class MaterialProfileComponent implements OnInit {
  employee: any;
  id: any;

  constructor() { }

  ngOnInit(): void {
  }

}
