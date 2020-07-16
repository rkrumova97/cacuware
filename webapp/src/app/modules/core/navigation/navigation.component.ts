import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.less']
})
export class NavigationComponent implements OnInit {
  name: any;
  private http: HttpClient;

  constructor(http: HttpClient) {
    this.http = http;
    this.name = window.sessionStorage.getItem('currentUser');
  }

  ngOnInit() {

  }

}
