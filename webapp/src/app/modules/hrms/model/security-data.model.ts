export interface ISecurityData {
  id?: string;
  idNumber?: number;
  issuedDate?: string;
  authority?: string;
  egn?: string;
  yearsOfLabour?: number;
  monthsOfLabour?: number;
  daysOfLabour?: number;
  professionYearsOfLabour?: number;
  professionMonthsOfLabour?: number;
  professionDaysOfLabour?: number;
  salary?: string;
  iban?: string;
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
    public iban?: string,
    public email?: string,
    public professionYearsOfLabour?: number,
    public professionMonthsOfLabour?: number,
    public professionDaysOfLabour?: number,
  ) {}
}
