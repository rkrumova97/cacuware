import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class WarehouseService {
  public clientId = 'warehouse-service';
  public resourceUrl = 'http://localhost:8087/api/warehouse';

  private item: string = "";
  private readonly token: string = "";

  constructor(protected http: HttpClient) {
    this.item = <string>window.sessionStorage.getItem('token');
    let keys = this.item.split(":");
    let otherKeys = keys[1].split(",");
    this.token = otherKeys[0].substring(1, otherKeys[0].length - 1);
  }

  getResource(resource: string,): Observable<any> {
    const headers = new HttpHeaders({
      'Content-type': 'application/json',
      'Authorization': 'Bearer ' + this.token
    });
    return this.http.get(this.resourceUrl + resource, {headers: headers});
  }

  postResource(resource: string, object: any): Observable<any> {
    const headers = new HttpHeaders({
      'Content-type': 'application/json',
      'Authorization': 'Bearer ' + this.token
    });
    return this.http.post(this.resourceUrl + resource, object, {headers: headers});
  }

  updateResource(resource: string, object: any): Observable<any> {

    const headers = new HttpHeaders({
      'Content-type': 'application/json',
      'Authorization': 'Bearer ' + this.token
    });

    return this.http.put(this.resourceUrl + resource, object, {headers: headers});
  }

  deleteResource(resource: string, id: any): Observable<any> {
    const headers = new HttpHeaders({
      'Content-type': 'application/json',
      'Authorization': 'Bearer ' + this.token,
    });
    return this.http.delete(this.resourceUrl + resource, {headers: headers});
  }

  getOneResource(resource: string): Observable<any> {
    const headers = new HttpHeaders({
      'Content-type': 'application/json',
      'Authorization': 'Bearer ' + this.token,
    });
    return this.http.get(this.resourceUrl + resource, {headers: headers});
  }
}
