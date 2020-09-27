export interface IApplicationForVacation {
   vacationDays: string;
   startDate: any;
}
export class ApplicationForVacation {
  constructor( public vacationDays?: string,
               public startDate?: any) {
  }
}
