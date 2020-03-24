import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookMyDocService } from '../book-my-doc.service';

@ Component({
  selector: 'app-ratingdetails',
  templateUrl: './ratingdetails.component.html',
  styleUrls: ['./ratingdetails.component.css']
})
export class RatingdetailsComponent implements OnInit {
  success: string;
  failure: string;
  ratings;

  constructor(private ratingDetails: BookMyDocService,
              private router: Router) {
                this.viewAllRatings();
               }

    deleteRaing(rating) {
      this.ratingDetails.deleteRating(rating).subscribe(data => {
        console.log(data);
        if (data.statusCode === 201 ) {
          this.ratings.splice(this.ratings.indexOf(rating), 1);
          this.success = data.message;
          setTimeout(() => {
            this.success = null;
          }, 2000);
        }
      });
    }

    viewAllRatings(){
      this.ratingDetails.getAllRatings().subscribe(response => {
        console.log(response);
        if (response.statusCode === 201) {
          this.ratings =response.bean;
          this.success = response.description;
          localStorage.setItem('rating Details ', JSON.stringify(response));
          console.log('Rating details are added');
          setTimeout(() => {
            this.success = null;
          }, 2000 );
        }
      });
    }


  ngOnInit() {
  }

}
