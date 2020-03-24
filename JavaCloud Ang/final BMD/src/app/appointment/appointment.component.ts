import { Component, OnInit } from '@angular/core';
import { BookMyDocService } from '../book-my-doc.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css']
})
export class AppointmentComponent implements OnInit {
  appointments: any;

  constructor(private bookMyDoc: BookMyDocService,
              private router: Router) { 
    this.getAppointment();
  }

  ngOnInit() {
  }
  getAppointment() {
    console.log(this.bookMyDoc.doctorName);
    this.bookMyDoc.getAppointmentByName(this.bookMyDoc.doctorName).subscribe(response => {
      console.log(response);
      this.appointments = response.appiontmentBooking;
    }, err => {
      console.log(err);
    });
  }
  action(appointment){
    this.bookMyDoc.valueOfAppointmentDetails = appointment;
    this.router.navigateByUrl('/approve-action');

  }
}
