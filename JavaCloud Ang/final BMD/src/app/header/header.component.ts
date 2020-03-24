import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }
  isPatient() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails.user[0]'));
    if (userDetails && userDetails.user[0].userType === 'patient') {
      return true;
    } else {
      return false;
    }
  }
  isDoctor() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails.user[0]'));
    if (userDetails && userDetails.user[0].userType === 'doctor') {
      return true;
    } else {
      return false;
    }
  }

  isLoggedIn() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails.user[0]'));
    if (userDetails) {
      return true;
    } else {
      return false;
    }

  }
  isAdmin(){
    let userDetails = JSON.parse(localStorage.getItem('userDetails.user[0]'));
    if (userDetails) {
      return true;
    } else {
      return false;
    }
  }
  logout() {
    localStorage.removeItem('userDetails.user[0]');
    this.router.navigateByUrl('/');
  }
}
