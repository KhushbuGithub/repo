import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@ Injectable({
  providedIn: 'root'
})
export class DoctorService {

  api = 'http://localhost:8080';

  constructor(private http : HttpClient) { }

  addDoctor(doctorDetails): Observable< any> {
    return this.http.post< any>(
      `${this.api}/add-doctor`,
      doctorDetails);
    }

    deleteDoctor(doctor:Doctor) {
      return this.http.delete< any>(`${this.api}/delete-doctor/${doctor.doctorId}`);
      }

      getAllDoctors(): Observable< any> {
        return this.http.get< any>(`${this.api}/get-alldoctors`);
      }
}
