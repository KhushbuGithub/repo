import { Component, OnInit, DoCheck } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit , DoCheck{

  role = null;
  constructor(public router: Router) { }

  ngOnInit() {
    // if (localStorage.getItem('user')) {
    //   this.role = JSON.parse(localStorage.getItem('user')).role;
    // } else {
    //   this.role = null;
    // }
  }

  ngDoCheck() {
    if (localStorage.getItem('user')) {
      this.role = JSON.parse(localStorage.getItem('user')).role;
    } else {
      this.role = null;
    }
  }

  logout() {
    localStorage.clear();
    this.role = null;
    this.router.navigateByUrl('/login');
  }

}
