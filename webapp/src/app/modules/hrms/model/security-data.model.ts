export interface ISecurityData {
  id?: string;
  firstName?: string;
  middleName?: string;
  lastName?: string;
  gender?: string;
  area?: string;
  city?: number;
  address?: number;
  status?: string;
  birthday?: Date;
}

export class SecurityDataModel implements ISecurityData {
  constructor(
    public id?: string,
    public firstName?: string,
    public middleName?: string,
    public lastName?: string,
    public gender?: string,
    public area?: string,
    public city?: number,
    public address?: number,
    public status?: string,
    public birthday?: Date
  ) {}
}
