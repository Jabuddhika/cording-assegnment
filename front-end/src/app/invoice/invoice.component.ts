import {Component, Output} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Invoice} from "../dto/invoice";
import {Detail} from "../dto/detail";
import {TempServiceService} from "../service/temp-service.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.scss']
})
export class InvoiceComponent {
  invoiceList:Array<Invoice>=[];
  totalPages:number=0;
  next:number=0;

  //at startup get the invoices using constructor
  constructor(private http:HttpClient,private service:TempServiceService,private router:Router) {
    http.get(`http://localhost:8080/api/v1/invoices/${0}/${2}`,{ observe: 'response' }).subscribe(response=>{
      this.invoiceList=response.body as Array<Invoice>;
      const totalPage=this.invoiceList[0].totalPages;
      this.totalPages=totalPage;
    })
  }

  //get details corresponding with invoiceId
  getDetail(invoice: Invoice):void {
    this.http.get<Array<Detail>>(`http://localhost:8080/api/v1/details/${invoice.id}`).subscribe(data=>{

      this.service.detailList=data;

      this.service.sender=invoice.sender;
      this.service.receiver=invoice.receiver;
      this.service.totalAmount=invoice.totalAmount;

      if(data.length==0) this.service.flag=true;
      if(data.length>0) this.service.flag=false;

      this.router.navigate(['/details']);

    })

  }

  // get the next page
  getNextPage() {
    this.next=this.next+1;

    if(this.next>=this.totalPages/2){
      this.next=this.next-1;
      return;
    }

    this.http.get<Array<Invoice>>(`http://localhost:8080/api/v1/invoices/${this.next}/${2}`).subscribe(elm=>{
      this.invoiceList=elm;
    })
  }

  //get the preveius page
  getPrePage() {
    this.next=this.next-1;

    if(this.next<0){  //if page<0  cant get the response
      this.next=0;
      return;
    }

    this.http.get<Array<Invoice>>(`http://localhost:8080/api/v1/invoices/${this.next}/${2}`).subscribe(elm=>{
      this.invoiceList=elm;

    })

  }

  //get invoices with descending order
  getShortDesWithInvoice() {
    this.http.get<Array<Invoice>>(`http://localhost:8080/api/v1/invoices/${this.next}/${2}/id`).subscribe(elm=>{
      this.invoiceList=elm;
    })
  }

  //get invoices with ascending order
  getSortAseWithInvoice() {
    this.http.get<Array<Invoice>>(`http://localhost:8080/api/v1/invoices/${this.next}/${2}/id/asc`).subscribe(elm=>{
      this.invoiceList=elm;
    })

  }
}
