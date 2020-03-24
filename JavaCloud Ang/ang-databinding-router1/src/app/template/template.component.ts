import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-template',
  templateUrl: './template.component.html',
  styleUrls: ['./template.component.css']
})
export class TemplateComponent implements OnInit {
  @ViewChild('loginForm',{static:true}) loginValue:NgForm;


  constructor() { }

  ngOnInit() {
  }
  loginData(){
    console.log(this.loginValue.value);
  }

}
