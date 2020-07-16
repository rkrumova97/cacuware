import { Component } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.less']
})
export class AppComponent {
  title = 'HRMs-FE';
  public href = '';
  isCollapsed: boolean = true;
  constructor(private router: Router) {}


  isLogin(): boolean {
    this.href = this.router.url;
    return this.href === '/' ;
  }
}
