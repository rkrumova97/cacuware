import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ppe-profile',
  templateUrl: './ppe-profile.component.html',
  styleUrls: ['./ppe-profile.component.css']
})
export class PpeProfileComponent implements OnInit {
  employee: any;
  id: any;

  constructor() { }

  ngOnInit(): void {
  }

}
