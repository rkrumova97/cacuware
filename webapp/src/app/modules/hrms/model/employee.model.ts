export interface IEmployee {
  id?: string;
  idCardNumber?: string;
  idCardIssuedDate?: string;
  idCardAuthority?: string;
  vacationDays?: number;
  jobNumber?: string;
  workingHours?: number;
  workingDays?: number;
  email?: string;
  egn?:number;
  salary?:number;
  iban?: string;
  yearsOfLabour?: string;
  monthsOfLabour?: string;
  daysOfLabour?: string;
  startDate?: Date;
  leavingDate?: Date;
  leavingNoticeSubmissionDate?: Date;
  skill?: string;
}

export class Employee implements IEmployee {
  constructor(
    public id?: string,
  public idCardNumber?: string,
  public idCardIssuedDate?: string,
  public idCardAuthority?: string,
  public vacationDays?: number,
  public jobNumber?: string,
  public workingHours?: number,
  public workingDays?: number,
  public email?: string,
  public egn?:number,
  public salary?:number,
  public iban?: string,
  public yearsOfLabour?: string,
  public monthsOfLabour?: string,
  public daysOfLabour?: string,
  public startDate?: Date,
  public leavingDate?: Date,
  public leavingNoticeSubmissionDate?: Date,
    public skill?: string
  ) {}
}

