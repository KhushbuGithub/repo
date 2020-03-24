import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-add-users',
  templateUrl: './add-users.component.html',
  styleUrls: ['./add-users.component.css']
})
export class AddUsersComponent implements OnInit {
  @Output() addUser= new EventEmitter();
  name;
  email;

  constructor() { }

  ngOnInit() {
  }

  addUserDetails(){
    console.log("method is called");
    console.log(this.name);
    console.log(this.email);
    this.addUser.emit({
      name:this.name,
      email:this.email
    });
  }

}
