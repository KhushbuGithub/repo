import { Component, OnInit } from '@angular/core';
import { BookMyDocService } from '../book-my-doc.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {
  doctors;
  doctorsName: any;
  constructor(private bookMyDoc: BookMyDocService,
              private router: Router) {
                this.getDoctor();
                this.getDoctorByName();
              }

  ngOnInit() {
  }

  details(){
    this.router.navigateByUrl('/add-doctor');
  }
  appointment(){
    this.router.navigateByUrl('/appointment');
  }
  getDoctor() {
    console.log(this.bookMyDoc.patientsId);
    this.bookMyDoc.getDoctor(this.bookMyDoc.patientsId).subscribe(response => {
      console.log(response);
      this.bookMyDoc.doctorName = response.bean[0].doctorName;
      this.doctors = response.bean;
    });
  }
  getDoctorByName(){
    console.log(this.bookMyDoc.doctorName);
    this.bookMyDoc.getDoctor(this.bookMyDoc.doctorName).subscribe(response => {
      console.log(response);
      this.bookMyDoc.doctorName = response.bean[0].doctorName;
      this.doctorsName = response.bean;
    });
  }

}
