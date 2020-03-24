import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormArray } from '@angular/forms';

@Component({
  selector: 'app-reactive',
  templateUrl: './reactive.component.html',
  styleUrls: ['./reactive.component.css']
})
export class ReactiveComponent implements OnInit {
  loginForm:FormGroup;

  constructor() { }

  ngOnInit() {
    this.loginForm= new FormGroup({
      email: new FormControl(''),
      Password: new FormControl(''),
      address: new FormGroup({
        street:new FormControl(''),
        city: new FormControl(''),
        pincode:new FormControl('')
      }),
      contacts :new FormArray([
        new FormControl()
      ])
    });
    console.log(this.loginForm);
  }

  loginValue(){
    console.log(this.loginForm.value);
  }
  addContact(){
    (this.loginForm.get('contacts') as FormArray).push(new FormControl());
  }
  removeContact(i){
    (this.loginForm.get('contacts') as FormArray).removeAt(i);
  }

}
