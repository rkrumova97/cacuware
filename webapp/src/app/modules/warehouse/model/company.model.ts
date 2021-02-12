export interface ICompany {
  id?: string;

  name?: string;

  email?: string;

  mol?: string;

  isDeleted?: boolean;

  bulstat?: string;

  contactName?: string;

  contactEmail?: string;

  contactNumber?: number;
}

export class Company implements ICompany {
  constructor(
    public id?: string,
    public name?: string,
    public email?: string,
    public mol?: string,
    public isDeleted?: boolean,
    public bulstat?: string,
    public contactName?: string,
    public contactEmail?: string,
    public contactNumber?: number) {
  }
}
