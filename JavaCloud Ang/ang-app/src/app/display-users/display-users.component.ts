import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-display-users',
  templateUrl: './display-users.component.html',
  styleUrls: ['./display-users.component.css']
})
export class DisplayUsersComponent implements OnInit {
  @Input() userValue: {name:string,email:string};

  constructor() { }

  ngOnInit() {
  }

}
