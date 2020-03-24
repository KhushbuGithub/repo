import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-template-register',
  templateUrl: './template-register.component.html',
  styleUrls: ['./template-register.component.css']
})
export class TemplateRegisterComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  loginData(registerForm){
    console.log(registerForm.value);
  }

}
