import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SecurityService {

  constructor(private http: HttpClient) { }
  baseUrl = 'http://localhost:8080/api/';

  login(loginPayload: string) {
    const headers = {
      Authorization: 'Basic ' + btoa('account-service:secret'),
      'Content-type': 'application/x-www-form-urlencoded'
    };
    console.log('something2');
    return this.http.post("http://localhost:9999/" + 'oauth/token', loginPayload, {headers});
  }

  getUsers() {
    return this.http.get(this.baseUrl + 'user?access_token=' + JSON.parse(<string>window.sessionStorage.getItem('token')).access_token);
  }

  getUserById(id: number) {
    return this.http.get(this.baseUrl + 'user/' + id + '?access_token=' + JSON.parse(<string>window.sessionStorage.getItem('token')).access_token);
  }}
