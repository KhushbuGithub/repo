import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@ Injectable({
  providedIn: 'root'
})
export class RatingService {
  api = 'http://localhost:8080';

  constructor(private http : HttpClient) { }

  deleteRating(rating:Rating) {
    return this.http.delete< any>(`${this.api}/delete-ratingandreview/${rating.ratingId}`);
    }

    getAllRatings(): Observable< any> {
      return this.http.get< any>(`${this.api}/get-allratingandreviews`);
    }
}
