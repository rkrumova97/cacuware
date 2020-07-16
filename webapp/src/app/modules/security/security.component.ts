import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {HttpParams} from '@angular/common/http';
import {SecurityService} from './security.service';

@Component({
  selector: 'app-security',
  templateUrl: './security.component.html',
  styleUrls: ['./security.component.less']
})
export class SecurityComponent implements OnInit {

  loginForm!: FormGroup ;
  invalidLogin = false;
  private authenticated = false;

  constructor(private formBuilder: FormBuilder, private router: Router, private apiService: SecurityService) {
  }

  onSubmit() {
    if (this.loginForm.invalid) {
      return;
    }
    const body = new HttpParams()
      .set('username', this.loginForm.controls.username.value)
      .set('password', this.loginForm.controls.password.value)
      .set('grant_type', 'password');

    this.apiService.login(body.toString()).subscribe(data => {
      window.sessionStorage.setItem('token', JSON.stringify(data));
      window.sessionStorage.setItem('currentUser', <string>body.get('username'));
      console.log(window.sessionStorage.getItem('token'));
      console.log(    window.sessionStorage.getItem('currentUser'));
      this.router.navigate(["/core"]);
      this.authenticated = true;
    }, error => {
      alert(error.error.error_description);
    });
  }

  ngOnInit() {
    window.sessionStorage.removeItem('token');
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.compose([Validators.required])],
      password: ['', Validators.required]
    });

      // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
  }
}
