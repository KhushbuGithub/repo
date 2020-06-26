import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule, NgbRatingConfig } from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { RegistrationComponent } from './registration/registration.component';
import { SearchComponent } from './search/search.component';
import { LoginComponent } from './login/login.component';
import { DoctorComponent } from './doctor/doctor.component';
import { AddDoctorComponent } from './add-doctor/add-doctor.component';
import { UpdateDoctorComponent } from './update-doctor/update-doctor.component';
import { AddPatientComponent } from './add-patient/add-patient.component';
import { UpdatePatientComponent } from './update-patient/update-patient.component';
import { PatientComponent } from './patient/patient.component';
import { AboutComponent } from './about/about.component';
import { FaqComponent } from './faq/faq.component';
import { FooterComponent } from './footer/footer.component';
import { AddAppointmentComponent } from './add-appointment/add-appointment.component';
import { AppointmentComponent } from './appointment/appointment.component';
import { ApproveActionComponent } from './approve-action/approve-action.component';
import { AppointmentdetailsComponent } from './appointmentdetails/appointmentdetails.component';
import { DoctordetailsComponent } from './doctordetails/doctordetails.component';
import { PatientdetailsComponent } from './patientdetails/patientdetails.component';
import { RatingdetailsComponent } from './ratingdetails/ratingdetails.component';
import { AdminComponent } from './admin/admin.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    RegistrationComponent,
    SearchComponent,
    LoginComponent,
    DoctorComponent,
    AddDoctorComponent,
    UpdateDoctorComponent,
    AddPatientComponent,
    UpdatePatientComponent,
    PatientComponent,
    AboutComponent,
    FaqComponent,
    FooterComponent,
    AddAppointmentComponent,
    AppointmentComponent,
    ApproveActionComponent,
    AppointmentdetailsComponent,
    DoctordetailsComponent,
    PatientdetailsComponent,
    RatingdetailsComponent,
    AdminComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    NgbModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: '', component: HomeComponent },
      { path: 'registration', component: RegistrationComponent },
      { path: 'view-search', component: SearchComponent },
      { path: 'login', component: LoginComponent },
      { path: 'doctor', component: DoctorComponent},
      { path: 'add-doctor', component: AddDoctorComponent },
      { path: 'update-doctor', component: UpdateDoctorComponent },
      { path: 'patient', component: PatientComponent },
      { path: 'add-patient', component: AddPatientComponent },
      { path: 'update-patient', component: UpdatePatientComponent },
      { path: 'about', component: AboutComponent },
      { path: 'faq', component: FaqComponent },
      { path: 'add-appointment', component: AddAppointmentComponent },
      { path: 'appointment', component: AppointmentComponent },
      { path: 'approve-action', component: ApproveActionComponent },
      { path: 'footer', component: FooterComponent },
      {
        path: 'admin', component: AdminComponent, children: [
          { path: 'doctordetails', component: DoctordetailsComponent },
          { path: 'patientdetails', component: PatientdetailsComponent },
          { path: 'appointmentdetails', component: AppointmentdetailsComponent },
          { path: 'ratingdetails', component: RatingdetailsComponent }
         
        ]
      },
    ])
  ],
  providers: [NgbRatingConfig],
  bootstrap: [AppComponent]
})
export class AppModule { }
