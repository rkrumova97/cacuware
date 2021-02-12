import {Material} from "./material.model";

export interface IPpe {
  id: string;
  material: Material;
  size: string;
  type: string;
  isDeleted: boolean;
  people: string[];
}

export class Ppe implements IPpe {
  constructor(public id: string,
              public material: Material,
              public size: string,
              public type: string,
              public isDeleted: boolean,
              public people: string[]) {
  }
}
