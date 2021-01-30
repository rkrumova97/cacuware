import {Person} from "./person.model";
import {SecurityDataModel} from "./security-data.model";

export interface IEmployee {
  id?:  string | null | undefined;
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
  startDate?: Date;
  leavingDate?: Date;
  leavingNoticeSubmissionDate?: Date;
  person: Person;
  securityData?: SecurityDataModel;
  show?: any;
  education?: string;
  filesIds?: string[];
}

export class Employee implements IEmployee {
  constructor(
    public person: Person,
    public securityData?: SecurityDataModel,
    public id?: string | null | undefined,
    public idCardNumber?: string,
    public idCardIssuedDate?: string,
    public idCardAuthority?: string,
    public vacationDays?: number,
    public jobNumber?: string,
    public workingHours?: number,
    public workingDays?: number,
    public startDate?: Date,
    public leavingDate?: Date,
    public leavingNoticeSubmissionDate?: Date,
    public show?: any,
    public education?: string,
    public fileIds?: string[]
  ) {
  }
}

