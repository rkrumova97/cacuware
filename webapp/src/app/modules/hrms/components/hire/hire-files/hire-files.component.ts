import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hire-files',
  templateUrl: './hire-files.component.html',
  styleUrls: ['./hire-files.component.css']
})
export class HireFilesComponent implements OnInit {
  success: boolean = true;

  constructor() { }

  ngOnInit(): void {
  }

  process() {

  }

  close() {
    this.success = true;
  }
}
