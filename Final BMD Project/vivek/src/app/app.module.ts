import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdddoctorComponent } from './adddoctor/adddoctor.component';
import { DoctordetailsComponent } from './doctordetails/doctordetails.component';
import { HeaderComponent } from './header/header.component';
import { HttpClientModule } from '@angular/common/http';
import { PatientdetailsComponent } from './patientdetails/patientdetails.component';
import { AppointmentdetailsComponent } from './appointmentdetails/appointmentdetails.component';
import { RatingdetailsComponent } from './ratingdetails/ratingdetails.component';
import { AdminComponent } from './admin/admin.component';

@ NgModule({
  declarations: [
    AppComponent,
    AdddoctorComponent,
    DoctordetailsComponent,
    HeaderComponent,
    PatientdetailsComponent,
    AppointmentdetailsComponent,
    RatingdetailsComponent,
    AdminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
