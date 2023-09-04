import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { DetailComponent } from './detail/detail.component';
import {Route, RouterModule, Routes} from "@angular/router";
import { InvoiceComponent } from './invoice/invoice.component';
import {HttpClientModule} from "@angular/common/http";

const routers:Routes=[  //set the routing for two component
  {
    path:"",
    component:InvoiceComponent
  },
  {
    path:"details",
    component:DetailComponent
  }
];
@NgModule({
  declarations: [
    AppComponent,
    DetailComponent,
    InvoiceComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routers),
    HttpClientModule,

  ],
  exports:[InvoiceComponent],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
