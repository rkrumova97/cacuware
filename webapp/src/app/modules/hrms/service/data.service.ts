import {Injectable} from "@angular/core";
import {IPerson, Person} from "../model/person.model";
import {Employee} from "../model/employee.model";

@Injectable({
  providedIn: 'root'
})
export class DataService {
  public person!: Person;
  public employee?: Employee;
}
