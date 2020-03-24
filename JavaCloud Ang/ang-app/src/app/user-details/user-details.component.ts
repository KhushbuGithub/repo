import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

  name;
  email;
  User:{name:string,email:string}[]=[];
  

  constructor() { }

  ngOnInit() {
  }
  // addUser(){
  //   console.log(this.name);
  //   console.log(this.email);
  // this.User.push({
  //   name:this.name,
  //   email:this.email
  // })
  // }
  onAddedUser(data){
    console.log("user-details", data);
    console.log("on added method is called");
    this.User.push(data);
  }

}
