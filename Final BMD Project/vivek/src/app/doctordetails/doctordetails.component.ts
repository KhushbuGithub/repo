import { Component, OnInit } from '@angular/core';
import { DoctorService } from '../doctor.service';
import { Router } from '@angular/router';

@ Component({
  selector: 'app-doctordetails',
  templateUrl: './doctordetails.component.html',
  styleUrls: ['./doctordetails.component.css']
})
export class DoctordetailsComponent implements OnInit {
  success: string;
  failure: string;
  doctors: Doctor[];

  constructor(private doctorDetails: DoctorService,
    private router: Router) {
      this.viewAllDoctors();
     }

  deleteDoctor(doctor: Doctor) {
    this.doctorDetails.deleteDoctor(doctor).subscribe(data => {
      console.log(data);
      if (data.statusCode === 201 ) {
        this.doctors.splice(this.doctors.indexOf(doctor), 1);
        this.success = data.message;
        setTimeout(() => {
          this.success = null;
        }, 2000);
      }
    });
  }

  viewAllDoctors(){
    this.doctorDetails.getAllDoctors().subscribe(response => {
      console.log(response);
      if (response.statusCode === 201) {
        this.doctors =response.bean;
        this.success = response.description;
        localStorage.setItem('doctor Details ', JSON.stringify(response));
        console.log('Doctor details are added');
        setTimeout(() => {
          this.success = null;
        }, 2000 );
      }
    });
  }

  ngOnInit() {
  }

}
