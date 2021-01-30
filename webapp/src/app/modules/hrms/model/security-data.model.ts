export interface ISecurityData {
  id?: string;
  idNumber?: number;
  issuedDate?: string;
  authority?: string;
  egn?: string;
  yearsOfLabour?: number;
  monthsOfLabour?: number;
  daysOfLabour?: number;
  professionalYearsOfLabour?: number;
  professionalMonthsOfLabour?: number;
  professionalDaysOfLabour?: number;
  salary?: string;
  email?: string;
}

export class SecurityDataModel implements ISecurityData {
  constructor(
    public id?: string,
    public idNumber?: number,
    public issuedDate?: string,
    public authority?: string,
    public egn?: string,
    public yearsOfLabour?: number,
    public monthsOfLabour?: number,
    public daysOfLabour?: number,
    public salary?: string,
    public email?: string,
    public professionalYearsOfLabour?: number,
    public professionalMonthsOfLabour?: number,
    public professionalDaysOfLabour?: number,
  ) {}
}
