import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookMyDocService } from '../book-my-doc.service';

@ Component({
  selector: 'app-appointmentdetails',
  templateUrl: './appointmentdetails.component.html',
  styleUrls: ['./appointmentdetails.component.css']
})
export class AppointmentdetailsComponent implements OnInit {
  success: string;
  failure: string;
  appointments;

  constructor(private appointmentDetails: BookMyDocService,
              private router: Router) {
      this.getAllAppointment();
     }

    deleteAppointment(appointment) {
      this.appointmentDetails.deleteAppointment(appointment).subscribe(data => {
        console.log(data);
        if (data.statusCode === 201 ) {
          this.appointments.splice(this.appointments.indexOf(appointment), 1);
          this.success = data.message;
          setTimeout(() => {
            this.success = null;
          }, 2000);
        }
      });
    }

    getAllAppointment(){
      this.appointmentDetails.getAllAppointment().subscribe(response => {
        console.log(response);
        if (response.statusCode === 201) {
          this.appointments =response.appiontmentBooking;
          this.success = response.description;
          localStorage.setItem('Appointment Details ', JSON.stringify(response));
          console.log('Appointment details are added');
          setTimeout(() => {
            this.success = null;
          }, 2000 );
        }
      });
    }

  ngOnInit() {
  }

}
