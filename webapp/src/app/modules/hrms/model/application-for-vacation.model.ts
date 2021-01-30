import {Employee} from "./employee.model";

export interface IApplicationForVacation {
  vacationDays: string;
  startDate: any;
  employee: Employee;
}

export class ApplicationForVacation {
  constructor(public vacationDays?: string,
              public startDate?: any,
              public employee?: Employee) {
  }
}
