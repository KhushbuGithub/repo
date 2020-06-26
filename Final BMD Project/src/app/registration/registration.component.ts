import { Component, OnInit } from '@angular/core';
import { BookMyDocService } from '../book-my-doc.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  form1=false;
  form2=true;
  form4=false;
  form3=true;
  constructor(private bookMyDoc: BookMyDocService) { }

  message: any;
  error: any;
  userName = 'patient';
  userName2 = 'doctor';
  ngOnInit() {
  }
  addUser(form: NgForm) {
    this.bookMyDoc.postRegistration(form.value).subscribe(data => {
      if (data.statusCode === 201){
        console.log(data);
        this.message = data.description;
      } else{
        console.log(data);
        this.error = data.description;
      }
      setTimeout(() => {
        this.message = null;
        this.error = null;
      }, 2000);
      form.reset();
    });
  }

  register(){
    this.form1=true;
    this.form2=false;
  }
  register2(){
    this.form4=true;
    this.form3=false;
  }
  back1(){
    this.form1=false;
    this.form2=true;
  }
  back2(){
    this.form4=false;
    this.form3=true;
  }
}
