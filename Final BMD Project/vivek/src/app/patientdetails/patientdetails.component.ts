import { Component, OnInit } from '@angular/core';
import { PatientService } from '../patient.service';
import { Router } from '@angular/router';

@ Component({
  selector: 'app-patientdetails',
  templateUrl: './patientdetails.component.html',
  styleUrls: ['./patientdetails.component.css']
})
export class PatientdetailsComponent implements OnInit {
  success: string;
  failure: string;
  patients: Patient[];

  constructor(private patientDetails: PatientService,
    private router: Router) {
      this.viewAllPatients();
     }

    deletePatient(patient: Patient) {
      this.patientDetails.deletePatient(patient).subscribe(data => {
        console.log(data);
        if (data.statusCode === 201 ) {
          this.patients.splice(this.patients.indexOf(patient), 1);
          this.success = data.message;
          setTimeout(() => {
            this.success = null;
          }, 2000);
        }
      });
    }

    viewAllPatients(){
      this.patientDetails.getAllPatients().subscribe(response => {
        console.log(response);
        if (response.statusCode === 201) {
          this.patients =response.patient;
          this.success = response.description;
          localStorage.setItem('patient Details ', JSON.stringify(response));
          console.log('Patient details are added');
          setTimeout(() => {
            this.success = null;
          }, 2000 );
        }
      });
    }

  ngOnInit() {
  }

}
