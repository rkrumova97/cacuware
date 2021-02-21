import { Injectable } from '@angular/core';
import {Car} from "../model/car.model";

@Injectable({
  providedIn: 'root'
})
export class DataService {
  number: number = 1;
  public car!: Car;

  constructor() { }
}
