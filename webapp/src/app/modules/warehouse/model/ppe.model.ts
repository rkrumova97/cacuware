import {Material} from "./material.model";
import {Employee} from "../../hrms/model/employee.model";

export interface IPpe {
  id?: string;
  material?: any;
  size?: string;
  type?: string;
  isDeleted?: boolean;
  people?: Employee[];
  name?:string;
}

export class Ppe implements IPpe {
  constructor(public id?: string,
              public name?:string,
              public material?: any,
              public size?: string,
              public type?: string,
              public isDeleted?: boolean,
              public people?: Employee[]) {
  }
}
