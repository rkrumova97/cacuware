import {Injectable} from '@angular/core';
import {HttpClient, HttpEvent, HttpHeaders, HttpParams, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FileService {
  private baseUrl = 'http://localhost:8083';
  public clientId = 'file-service';
  private item: string = "";
  private readonly token: string = "";

  constructor(private http: HttpClient) {
    this.item = <string>window.sessionStorage.getItem('token');
    let keys = this.item.split(":");
    let otherKeys = keys[1].split(",");
    this.token = otherKeys[0].substring(1, otherKeys[0].length - 1);
  }

  upload(type: string, file?: File | null): Observable<HttpEvent<any>> {
    const formData: any = new FormData();
    const headers = new HttpHeaders({
      'Authorization': 'Bearer ' + this.token
    });
    // @ts-ignore
    formData.append('file', file);
    const params = new HttpParams()
      .set('type', type);

    const req = new HttpRequest('POST', `${this.baseUrl}/uploadFile`, formData, {
      reportProgress: true,
      responseType: 'json',
      headers: headers,
      params:params
    });

    return this.http.request(req);
  }

  getFiles(): Observable<any> {
    const headers = new HttpHeaders({
      'Authorization': 'Bearer ' + this.token
    });
    return this.http.get(`${this.baseUrl}/getFiles`, {headers: headers});
  }

  getFileTypes(): Observable<any> {
    const headers = new HttpHeaders({
      'Authorization': 'Bearer ' + this.token
    });
    return this.http.get(`${this.baseUrl}/getFileTypes`, {headers: headers});
  }

  generateFiles(){
    
  }
}
