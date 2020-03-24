import { UserService } from './../user.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(public service: UserService, public router: Router) { }

  ngOnInit() {
  }

  loginData(form) {
    console.log(form.value);
    this.service.loginRequest(form.value).subscribe(resp => {
      console.log(resp);
      localStorage.setItem('user', JSON.stringify(resp));
      if (resp.role === 'admin') {
        this.router.navigateByUrl('/products');
      } else if (resp.role === 'user') {
        this.router.navigateByUrl('/');
      }
    }, err => {
      console.log(err);
    }, () => {
      console.log('login request is gone');
    });
  }

}
