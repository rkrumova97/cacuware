import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {IPerson} from "../model/person.model";

type EntityResponseType = HttpResponse<IPerson[]>;

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  public resourceUrl = 'http://localhost:8084/api/hrms';

  constructor(protected http: HttpClient) {
  }

  find(): Observable<EntityResponseType> {
    return this.http
      .get<IPerson[]>(`${this.resourceUrl}`, {observe: 'response'});
  }

  delete(id: string): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, {observe: 'response'});
  }

  create(person?: IPerson): Observable<HttpResponse<IPerson>> {
    return this.http
      .post<IPerson>(this.resourceUrl, person, {observe: 'response'});
  }

  update(person?: IPerson): Observable<HttpResponse<IPerson>> {
    return this.http
      .put<IPerson>(this.resourceUrl, person, {observe: 'response'});
  }

}
