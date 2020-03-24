import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { FeaturesComponent } from './features/features.component';
import { CompanyComponent } from './company/company.component';
import { PricingComponent } from './pricing/pricing.component';
import { CustomersComponent } from './customers/customers.component';
import { SupportComponent } from './support/support.component';
import { RouterModule} from '@angular/router';
import { TemplateComponent } from './template/template.component';
import { ReactiveComponent } from './reactive/reactive.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FeaturesComponent,
    CompanyComponent,
    PricingComponent,
    CustomersComponent,
    SupportComponent,
    TemplateComponent,
    ReactiveComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
     {path:'home',component:HomeComponent},
     {path:'customers', component:CustomersComponent},
     {path:'company',component:CompanyComponent,
     children:[
       {path:'features',component:FeaturesComponent},
       {path:'pricing',component:PricingComponent},
       {path:'support',component:SupportComponent}
     ]},
    {path:'template',component:TemplateComponent},
    {path:'reactive',component:ReactiveComponent}

    ])
      
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
