
import { Component, OnInit } from '@angular/core';
import {Detail} from "../dto/detail";
import {Invoice} from "../dto/invoice";
import {TempServiceService} from "../service/temp-service.service";
import * as Big from "big.js";


@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.scss']
})
export class DetailComponent{

  detailList:Array<Detail>=[];

  sender:string;

  receiver:string;

  totalAmount:number;

  flag:boolean;



  //use the service to get the data from invoice component
  constructor(private service:TempServiceService) {
    this.detailList=service.detailList;
    this.sender=service.sender;
    this.receiver=service.receiver;
    this.totalAmount=service.totalAmount;
    this.flag=service.flag;

    console.log(this.sender)
    console.log(this.receiver)
    console.log(this.totalAmount)
    console.log(this.detailList)
    console.log("hello")
  }

}
