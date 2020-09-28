import {Person} from "./person.model";
import {SecurityDataModel} from "./security-data.model";

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
  egn?: number;
  salary?: number;
  iban?: string;
  yearsOfLabour?: string;
  monthsOfLabour?: string;
  daysOfLabour?: string;
  startDate?: Date;
  leavingDate?: Date;
  leavingNoticeSubmissionDate?: Date;
  person: Person;
  securityData?: SecurityDataModel;
  show?: any;
  education?: string;
  professionYearsOfLabour?: string;
  professionMonthsOfLabour?: string;
  professionDaysOfLabour?: string;
}

export class Employee implements IEmployee {
  constructor(
    public person: Person,
    public id?: string,
    public idCardNumber?: string,
    public idCardIssuedDate?: string,
    public idCardAuthority?: string,
    public vacationDays?: number,
    public jobNumber?: string,
    public workingHours?: number,
    public workingDays?: number,
    public email?: string,
    public egn?: number,
    public salary?: number,
    public iban?: string,
    public yearsOfLabour?: string,
    public monthsOfLabour?: string,
    public daysOfLabour?: string,
    public startDate?: Date,
    public leavingDate?: Date,
    public leavingNoticeSubmissionDate?: Date,
    public securityData?: SecurityDataModel,
    public show?: any,
    public education?: string,
    public professionYearsOfLabour?: string,
    public professionMonthsOfLabour?: string,
    public professionDaysOfLabour?: string,
  ) {
  }
}

