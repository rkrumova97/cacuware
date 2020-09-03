import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {IPerson} from "../model/person.model";
import {CookieService} from "ngx-cookie-service";

type EntityResponseType = HttpResponse<IPerson[]>;

@Injectable({
  providedIn: 'root'
})
export class PersonService {
  public clientId = 'hrms-service';
  public redirectUri = 'http://localhost:8089/';
  public resourceUrl = 'http://localhost:8084/api/hrms/persons';


  constructor(protected http: HttpClient, private cookieService: CookieService) {
  }

  retrieveToken = (code: string) => {
    let params = new URLSearchParams();
    params.append('grant_type', 'password');
    params.append('client_id', this.clientId);
    params.append('client_secret', 'secret');
    params.append('code', code);

    let headers =
      new HttpHeaders({'Content-type': 'application/x-www-form-urlencoded; charset=utf-8'});

    this.http.post("http://localhost:9999/" + 'oauth/token',
      params.toString(), {headers: headers})
      .subscribe(
        data => this.saveToken(data),
        err => alert('Invalid Credentials'));
  };
  private item: string ="";

  saveToken(token: any) {
    const expireDate = new Date().getTime() + (1000 * token.expires_in);
    this.cookieService.set("access_token", token.access_token, expireDate);
    console.log('Obtained Access token');
    window.location.href = 'http://localhost:8084';
  }

  getResource(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-type': 'application/x-www-form-urlencoded; charset=utf-8',
      'Authorization': 'Bearer ' + this.cookieService.get('access_token')
    });
    return this.http.get(this.resourceUrl, {headers: headers});
  }

  postResource(object: any): Observable<any> {
     this.item = <string> window.sessionStorage.getItem('token') ;
    let keys = this.item.split(":");
    let token = keys[1].split(",");
     console.log(token[0])
    const headers = new HttpHeaders({

      'Content-type': 'application/json',
      'Authorization': 'Bearer '+ token[0].substring(1, token[0].length-1)
    });
    return this.http.post(this.resourceUrl, object, {headers: headers});
  }

  deleteResource( id: any): Observable<any> {
    const headers = new HttpHeaders({
      'Content-type': 'application/x-www-form-urlencoded; charset=utf-8',
      'Authorization': 'Bearer ' + this.cookieService.get('access_token'),
      'id': id
    });
    return this.http.delete(this.resourceUrl, {headers: headers});
  }

  checkCredentials() {
    return this.cookieService.check('access_token');
  }

  logout() {
    this.cookieService.delete('access_token');
    window.location.reload();
  }


}
