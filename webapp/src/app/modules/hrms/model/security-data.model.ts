export interface ISecurityData {
  id?: string;
  idCardNumber?: number;
  idCardIssuedDate?: string;
  idCardAuthority?: string;
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
    public idCardNumber?: number,
    public idCardIssuedDate?: string,
    public idCardAuthority?: string,
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
