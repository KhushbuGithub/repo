import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { BookMyDocService } from '../book-my-doc.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  message: any;
  error: any;

  constructor(private bookMyDoc: BookMyDocService,
    private router: Router) { }

  ngOnInit() {
  }
  login(form: NgForm) {
    this.bookMyDoc.loginUser(form.value).subscribe(res => {

      console.log(res);
      if (res.statusCode === 201) {
        this.bookMyDoc.doctorName = res.user[0].name;
        console.log(res.user[0].email);
        this.bookMyDoc.doctorEmail = res.user[0].email;
        this.bookMyDoc.doctorsId = res.user[0].userId;
        this.bookMyDoc.patientsName = res.user[0].name;
        this.bookMyDoc.patientsId = res.user[0].userId;
        this.bookMyDoc.patientsEmail = res.user[0].email;
        if (res.user[0].userType === 'patient') {
          form.reset();
          this.message = res.message;
          setTimeout(() => {
            this.message = null;
          }, 5000);
          console.log(res);
          localStorage.setItem('userDetails.user[0]', JSON.stringify(res));
          console.log('user details stored in local storage');
          this.router.navigateByUrl('/');

        } else if (res.user[0].userType === 'doctor') {
          form.reset();
          this.message = res.message;
          setTimeout(() => {
            this.message = null;
          }, 5000);
          console.log(res);
          localStorage.setItem('userDetails.user[0]', JSON.stringify(res));
          console.log('user details stored in local storage');
          this.router.navigateByUrl('/');
        } else {
          form.reset();
          this.message = res.message;
          setTimeout(() => {
            this.message = null;
          }, 5000);
          console.log(res);
          localStorage.setItem('userDetails.user[0]', JSON.stringify(res));
          console.log('user details stored in local storage');
          this.router.navigateByUrl('/admin');
        }
      } else {
        form.reset();
        this.error = res.description;
        setTimeout(() => {
          this.error = null;
        }, 5000);

      }

    });
  }
}
