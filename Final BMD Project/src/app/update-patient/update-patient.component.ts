import { Component, OnInit } from '@angular/core';
import { BookMyDocService } from '../book-my-doc.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-patient',
  templateUrl: './update-patient.component.html',
  styleUrls: ['./update-patient.component.css']
})
export class UpdatePatientComponent implements OnInit {
  success: any;
  failure: any;

  constructor(private bookMyDoc: BookMyDocService,
              private router: Router) { }

  ngOnInit() {
  }
  updatePatient(form: NgForm) {
    this.bookMyDoc.updatePatient(form.value).subscribe(data => {
      console.log(data);
      if (data.statusCode === 201) {
        this.success = data.description;
        setTimeout(() => {
        this.success = null;
      }, 2000);
        form.reset();
        this.router.navigateByUrl('/patient')
    } else {
      this.failure = data.description;
      setTimeout(() => {
        this.failure = null;
      }, 2000);
    }
    });
  }

}
