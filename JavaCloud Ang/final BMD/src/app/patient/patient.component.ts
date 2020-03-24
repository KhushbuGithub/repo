import { Component, OnInit } from '@angular/core';
import { NgForm, FormControl, Validators } from '@angular/forms';
import { BookMyDocService } from '../book-my-doc.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {

  success: string;
  failure: string;
  patients: any;
  search;
  appointments: any;
  appointments2: any;
  currentRate = 3;
  message: any;
  error: any;
  patientId;
  constructor(private bookMyDoc: BookMyDocService,
              private router: Router) { 
  }

  ngOnInit() {
    this.getPatients();
    this.getAppointment();
  }
  getPatients() {
    this.patientId=this.bookMyDoc.patientsId;
    console.log(this.patientId);
    this.bookMyDoc.getPatient(this.patientId).subscribe(response => {
      console.log(response);
      this.patients = response.patient;
    }, err => {
      console.log(err);
    });
  }
  getAppointment() {
    console.log(this.bookMyDoc.patientsId);
    this.bookMyDoc.getAppointment(this.bookMyDoc.patientsId).subscribe(response => {
      console.log(response);
      this.appointments = response.appiontmentBooking;
      this.appointments2 = response.appiontmentBooking;
    }, err => {
      console.log(err);
    });
  }
  updatePatient(patient){
    this.bookMyDoc.valueOfPatientDetails = patient;
    this.router.navigateByUrl('/patient');
  }
  addRating(form: NgForm) {
    this.bookMyDoc.addRating(form.value).subscribe(data => {
      if (data.statusCode === 201){
        console.log(data);
        this.message = data.message;
      } else{
        console.log(data);
        this.error = data.message;
      }
      setTimeout(() => {
        this.message = null;
      }, 2000);
      form.reset();
    });
  }
}
