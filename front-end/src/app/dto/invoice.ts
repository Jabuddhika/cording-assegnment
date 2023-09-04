

export class Invoice {

  constructor(public id:number,public sender:string,public receiver:string,public totalAmount:number,public totalPaidAmount:number,public totalPages:number) {
  }
}
