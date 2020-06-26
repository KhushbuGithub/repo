import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { BookMyDocService } from '../book-my-doc.service';

@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.css']
})
export class AddPatientComponent implements OnInit {

  success: string;
  failure: string;
  constructor(private patient: BookMyDocService) { }

  ngOnInit() {
  }
  addPatient(form: NgForm) {
    this.patient.addPatient(form.value).subscribe(data => {
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
