import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Employee} from "../model/employee.model";

@Injectable({
  providedIn: 'root'
})
export class EmailService {

  private baseUrl = 'http://localhost:8082';
  public clientId = 'mail-service';
  private item: string = "";
  private readonly token: string = "";

  constructor(private http: HttpClient) {
    this.item = <string>window.sessionStorage.getItem('token');
    let keys = this.item.split(":");
    let otherKeys = keys[1].split(",");
    this.token = otherKeys[0].substring(1, otherKeys[0].length - 1);
  }

  sendHireEmail(employee: Employee | undefined): any{
    let headers = new HttpHeaders({
      'Content-type': 'application/json',
      'Authorization': 'Bearer ' + this.token,
    });
    return this.http.post(this.baseUrl + "/sendMail",
      {"email":"rkrumova97@gmail.com",
        "text":"Hi, \n You successfully hired " + employee + " \n Please after signed replace the signed documents. \n Greetings!", "subject":"Hire " + employee!.person.firstName + " " + employee!.person.lastName, "fileName":null, "file":null},
      {headers: headers});
  }
}
