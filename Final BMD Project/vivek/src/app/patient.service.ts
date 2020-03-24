import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@ Injectable({
  providedIn: 'root'
})
export class PatientService {
  api = 'http://localhost:8080';

  constructor(private http : HttpClient) { }

  addPatient(patientDetails): Observable< any> {
    return this.http.post< any>(
      `${this.api}/add-patient`,
      patientDetails);
    }

    deletePatient(patient:Patient) {
      return this.http.delete< any>(`${this.api}/delete-patient/${patient.patientId}`);
      }

      getAllPatients(): Observable< any> {
        return this.http.get< any>(`${this.api}/view-allpatients`);
      }
}
