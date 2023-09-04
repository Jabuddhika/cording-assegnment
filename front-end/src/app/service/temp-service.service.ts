import { Injectable } from '@angular/core';
import {Invoice} from "../dto/invoice";
import {Detail} from "../dto/detail";
import * as Big from "big.js";

@Injectable({
  providedIn: 'root'
})
export class TempServiceService {

  public detailList: Array<Detail> = [];

  sender:string='';

  receiver:string='';

  totalAmount:number=0;

  flag:boolean=false;
  constructor() { }
}
