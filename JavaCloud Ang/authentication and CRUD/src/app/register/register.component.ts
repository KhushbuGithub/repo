import { UserService } from './../user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(public service: UserService) { }

  ngOnInit() {
  }

  registerData(form) {
    console.log(form.value);
    this.service.registerRequest(form.value).subscribe(resp => {
      console.log('backend response', resp);
    }, err => {
      console.log(err);
      console.log('register request is gone');
    });
  }

}
