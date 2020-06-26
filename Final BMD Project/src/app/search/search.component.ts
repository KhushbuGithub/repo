import { Component, OnInit } from '@angular/core';
import { BookMyDocService } from '../book-my-doc.service';
import { Router } from '@angular/router';
import { NgbRatingConfig } from '@ng-bootstrap/ng-bootstrap';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  valueSearch;
  doctors;
  rating= 4;
  
  constructor(private httpClient: HttpClient,
              private bookMyDoc: BookMyDocService,
              private router: Router,
              config: NgbRatingConfig) {
                config.max = 5;
                config.readonly = true;
                this.getDoctor();
  }

  ngOnInit() {
    // this.httpClient.getSearch().subscribe(
    //   response => this.handleSuccessfulResponse(response),
    // );
  }
  handleSuccessfulResponse(response) {
    this.valueSearch = response;
  }
  getDoctor() {
      console.log(this.bookMyDoc.valueOfSearchCity);
      this.bookMyDoc.getDataCity(this.bookMyDoc.valueOfSearchCity).subscribe(response => {
        console.log(response);
        this.doctors = response.bean;
      });
    }
    isPatient() {
      let userDetails = JSON.parse(localStorage.getItem('userDetails.user[0]'));
      if (userDetails && userDetails.user[0].userType === 'patient') {
        return true;
      } else {
        return false;
      }
    }
    loginFirst(){
      alert('You must login first');
      this.router.navigateByUrl('/login');
    }
    appointment(doctor){
      this.bookMyDoc.valueOfDoctorDetais = doctor;
      this.router.navigateByUrl('/add-appointment');
    }
  }
