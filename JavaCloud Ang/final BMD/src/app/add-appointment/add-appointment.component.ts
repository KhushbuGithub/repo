import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { BookMyDocService } from '../book-my-doc.service';

@Component({
  selector: 'app-add-appointment',
  templateUrl: './add-appointment.component.html',
  styleUrls: ['./add-appointment.component.css']
})
export class AddAppointmentComponent implements OnInit {

  success: string;
  failure: string;
  pending;
  today = Date.now();
  constructor(private appointment: BookMyDocService) { 
    this.pending = 'pending';
  }

  ngOnInit() {
  }
  addAppointment(form: NgForm) {
    this.appointment.addAppointment(form.value).subscribe(data => {
      console.log(data);
      if (data.statusCode === 201) {
        this.success = data.description;
        setTimeout(() => {
        this.success = null;
      }, 2000);
        form.reset();
    } else {
      this.failure = data.description;
      setTimeout(() => {
        this.failure = null;
      }, 2000);
    }
    });
  }

}
