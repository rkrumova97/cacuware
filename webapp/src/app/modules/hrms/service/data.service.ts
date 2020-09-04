import {Injectable} from "@angular/core";
import {IPerson} from "../model/person.model";
import {Employee} from "../model/employee.model";

@Injectable({
  providedIn: 'root'
})
export class DataService {
  public person?: IPerson;
  public employee?: Employee;
}
