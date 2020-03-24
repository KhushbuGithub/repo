import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RouterComponent } from './router/router.component';
import { Layer1Component } from './layer1/layer1.component';
import { Layer2Component } from './layer2/layer2.component';
import { Layer3Component } from './layer3/layer3.component';
import {RouterModule} from '@angular/router';
import { Sublayer1Component } from './sublayer1/sublayer1.component';
import { Sublayer2Component } from './sublayer2/sublayer2.component';
import { Sublayer3Component } from './sublayer3/sublayer3.component';
import { DatabindingComponent } from './databinding/databinding.component';
import { TwoWayComponent } from './two-way/two-way.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { EmpDetailsComponent } from './emp-details/emp-details.component';
import { AddEmpComponent } from './add-emp/add-emp.component';
import { DisplayEmpComponent } from './display-emp/display-emp.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { AddProductComponent } from './add-product/add-product.component';
import { DisplayProductComponent } from './display-product/display-product.component';
import { TemplateComponent } from './template/template.component';
import { ReactiveComponent } from './reactive/reactive.component';


@NgModule({
  declarations: [
    AppComponent,
    RouterComponent,
    Layer1Component,
    Layer2Component,
    Layer3Component,
    Sublayer1Component,
    Sublayer2Component,
    Sublayer3Component,
    DatabindingComponent,
    TwoWayComponent,
    EmpDetailsComponent,
    AddEmpComponent,
    DisplayEmpComponent,
    ProductDetailsComponent,
    AddProductComponent,
    DisplayProductComponent,
    TemplateComponent,
    ReactiveComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      {path: 'layer1',component:Layer1Component},
      {path:'layer2',component:Layer2Component},
      {path:'layer3',component:Layer3Component,
      children:[
        {path:'sublayer1',component:Sublayer1Component},
        {path:'sublayer2',component:Sublayer2Component},
        {path:'sublayer3',component:Sublayer3Component}
      ]},
      {path:'databinding',component:DatabindingComponent},
      {path:'twoway',component:TwoWayComponent},
      {path:'empdetails' ,component:EmpDetailsComponent},
      {path:'productdetails',component:ProductDetailsComponent},
      {path:'template',component:TemplateComponent},
      {path:'reactive',component:ReactiveComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
