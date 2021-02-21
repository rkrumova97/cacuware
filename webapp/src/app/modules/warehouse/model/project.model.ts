import {Company} from "./company.model";

export interface IProject {
  id?: string;

  name?: string;

  company?: string;

  isDeleted?: boolean;

  people?: string[];

  files?: string[];

  cars?: string[];

  materials?: string[];

}

export class Project implements IProject {
  constructor(
    public id?: string,
    public name?: string,
    public company?: string,
    public isDeleted?: boolean,
    public people?: string[],
    public files?: string[],
    public cars?: string[],
    public materials?: string[]) {
  }
}

