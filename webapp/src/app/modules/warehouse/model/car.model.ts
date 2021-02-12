import {Material} from "./material.model";

export interface ICar {
  id: string;
  type: string;
  brand: string;
  number: string;
  engineVolume: string;
  insurance: string;
  insuranceExpiryDate: Date;
  examination: string;
  examinationExpiryDate: Date;
  vignette: string;
  vignetteExpiryDate: Date;
  repair: string;
  repairDate: Date;
  repairMoney: string;
  kilometers: number;
  fuel: number;
  norm: number;
  material: Material[];
}
export class Car implements ICar{
  constructor(public id: string,
  public type: string,
  public brand: string,
  public number: string,
  public engineVolume: string,
  public insurance: string,
  public insuranceExpiryDate: Date,
  public examination: string,
  public examinationExpiryDate: Date,
  public vignette: string,
  public vignetteExpiryDate: Date,
  public repair: string,
  public repairDate: Date,
  public repairMoney: string,
  public kilometers: number,
  public fuel: number,
  public norm: number,
  public material: Material[]) {
  }
}
