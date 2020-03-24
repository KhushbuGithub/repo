import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NgForm } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})



export class BookMyDocService {

  valueOfPatientDetails;
  valueOfAppointmentDetails;
  valueOfSearchCity;
  valueOfSearchSpecialization;
  valueOfDoctorDetais;
  doctorName;
  doctorEmail;
  doctorsId;
  patientsName;
  patientsId;
  patientsEmail;
  api = `http://localhost:8080`;

  constructor(private http: HttpClient) { }
  getDataCity(search) {
    return this.http.get<any>(`${this.api}/search-doctorCity/${search}`);
  }
  getDataSpecialization(search): Observable<any> {
    return this.http.get<any>(`${this.api}/search-doctorCity/${search}`);
  }
  postRegistration(request): Observable<any> {
    return this.http.post<any>(`${this.api}/register-user`, request);
  }
  loginUser(userCredentials): Observable<any> {
    return this.http.post<any>(`${this.api}/auth`, userCredentials);
  }
  addPatient(request): Observable<any> {
    return this.http.post<any>(`${this.api}/add-patient`, request);
  }
  addDoctor(request): Observable<any> {
    return this.http.post<any>(`${this.api}/add-doctor`, request);
  }
  addAppointment(request): Observable<any> {
    return this.http.post<any>(`${this.api}/add-appiontment`, request);
  }
  getPatient(search): Observable<any> {
    return this.http.get<any>(`${this.api}/view-patient/${search}`);
  }
  getAppointment(patient): Observable<any> {
    return this.http.get<any>(`${this.api}/get-appiontment/${patient}`);
  }
  addRating(request): Observable<any> {
    return this.http.post<any>(`${this.api}/add-ratingandreview`, request);
  }
  getDoctor(search): Observable<any> {
    return this.http.get<any>(`${this.api}/view-doctor/${search}`);
  }
  getAppointmentByName(doctor): Observable<any> {
    return this.http.get<any>(`${this.api}/get-appiontmentbyname/${doctor}`);
  }
  updateApprove(request): Observable<any> {
    return this.http.put<any>(`${this.api}/modify-Appiontment`, request);
  }
  getRatingByName(doctor): Observable<any> {
    return this.http.get<any>(`${this.api}/get-ratingbyname/${doctor}`);
  }
  updatePatient(request): Observable<any> {
    return this.http.put<any>(`${this.api}/modify-Patient`, request);
  }
  deleteRating(rating) {
    return this.http.delete<any>(`${this.api}/delete-ratingandreview/${rating.ratingId}`);
  }

  getAllRatings(): Observable<any> {
    return this.http.get<any>(`${this.api}/get-allratingandreviews`);
  }

  deletePatient(patient) {
    return this.http.delete<any>(`${this.api}/delete-patient/${patient.patientId}`);
  }

  getAllPatients(): Observable<any> {
    return this.http.get<any>(`${this.api}/view-allpatients`);
  }

  deleteDoctor(doctor) {
    return this.http.delete<any>(`${this.api}/delete-doctor/${doctor.doctorId}`);
  }

  getAllDoctors(): Observable<any> {
    return this.http.get<any>(`${this.api}/get-alldoctors`);
  }

  deleteAppointment(appointment) {
    return this.http.delete<any>(`${this.api}/delete-appointment/${appointment.appointmentId}`);
  }

  getAllAppointment(): Observable<any> {
    return this.http.get<any>(`${this.api}/view-allappiontment`);
  }
}
