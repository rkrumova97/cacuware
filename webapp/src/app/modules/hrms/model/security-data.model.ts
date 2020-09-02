export interface ISecurityData {
  id?: string;
  idCardNumber?: string;
  idCardIssuedDate?: string;
  idCardAuthority?: string;
  egn?: string;
  yearsOfLabour?: number;
  monthsOfLabour?: number;
  daysOfLabour?: number;
  salary?: string;
  iban?: string;
  email?: string;
}

export class SecurityDataModel implements ISecurityData {
  constructor(
    public id?: string,
    public idCardNumber?: string,
    public idCardIssuedDate?: string,
    public idCardAuthority?: string,
    public egn?: string,
    public yearsOfLabour?: number,
    public monthsOfLabour?: number,
    public daysOfLabour?: number,
    public salary?: string,
    public iban?: string,
    public email?: string
  ) {}
}
