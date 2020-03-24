import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { DoctordetailsComponent } from './doctordetails/doctordetails.component';
import { PatientdetailsComponent } from './patientdetails/patientdetails.component';
import { AppointmentdetailsComponent } from './appointmentdetails/appointmentdetails.component';
import { RatingdetailsComponent } from './ratingdetails/ratingdetails.component';
import { AdminComponent } from './admin/admin.component';


const routes: Routes = [
  {path: 'body', component:HeaderComponent},
  {path: 'admin', component:AdminComponent, children:[
  {path: 'doctordetails', component:DoctordetailsComponent},
    {path: 'patientdetails', component:PatientdetailsComponent},
    {path: 'appointmentdetails', component:AppointmentdetailsComponent},
    {path: 'ratingdetails', component:RatingdetailsComponent}
  ]
}
];

@ NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
