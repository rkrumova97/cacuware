export interface IMaterial {
  id?: string;

  measurement?: string;

  quantity?: string;

  singlePrice?: number;

  value?: number;

  incomeInvoiceNumber?: number;

  moneySpent?: number;

  outcomeInvoiceNumber?: number;

  date?: Date;

  left?: number;

  type?: string;

  delivery?: any;

  isDeleted?: boolean;
}

export class Material implements IMaterial {
  projects: any;
  constructor(public id?: string,
              public measurement?: string,
              public quantity?: string,
              public singlePrice?: number,
              public value?: number,
              public incomeInvoiceNumber?: number,
              public moneySpent?: number,
              public outcomeInvoiceNumber?: number,
              public date?: Date,
              public left?: number,
              public type?: string,
              public isDeleted?: boolean,
              public delivery?: any
  ) {
  }
}
