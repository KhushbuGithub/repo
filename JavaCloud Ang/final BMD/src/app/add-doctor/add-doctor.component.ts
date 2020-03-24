import { Component, OnInit } from '@angular/core';
import { BookMyDocService } from '../book-my-doc.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-doctor',
  templateUrl: './add-doctor.component.html',
  styleUrls: ['./add-doctor.component.css']
})
export class AddDoctorComponent implements OnInit {
  name;
  success: any;
  failure: any;

  constructor(private bookMyDoc: BookMyDocService) { 
                  this.name=this.bookMyDoc.doctorName;
                  this.name=this.bookMyDoc.doctorEmail;
  }

  ngOnInit() {
  }
  doctor(form: NgForm) {
    this.bookMyDoc.addDoctor(form.value).subscribe(data => {
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
