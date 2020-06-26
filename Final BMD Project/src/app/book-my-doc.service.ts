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
  valueOfDoctorDetais;
  doctorName;
  doctorEmail;
  doctorsId;
  patientsName;
  patientsId;
  patientsEmail;
  api = `http://localhost:8080/template`;
  appointmentId;

  constructor(private http: HttpClient) { }
  getDataCity(search) {
    return this.http.get<any>(`${this.api}/search-doctorCity/${search}`,{
      withCredentials:true
    });
  }
  postRegistration(request): Observable<any> {
    return this.http.post<any>(`${this.api}/register-user`, request,{
      withCredentials:true
    }); 
  }
  loginUser(userCredentials): Observable<any> {
    return this.http.post<any>(`${this.api}/login`, userCredentials,{
      withCredentials:true
    });
  }
  addPatient(user): Observable<any> {
    return this.http.post<any>(`${this.api}/add-patient/${this.patientsId}`, user,{
      withCredentials:true
    });
  }
  addDoctor(user): Observable<any> {
    return this.http.post<any>(`${this.api}/add-doctor/${this.doctorsId}`, user,{
      withCredentials:true
    });
  }
  addAppointment(patient): Observable<any> {
    return this.http.post<any>(`${this.api}/add-appiontment/${this.appointmentId}`, patient,{
      withCredentials:true
    });
  }
  getPatient(search): Observable<any> {
    return this.http.get<any>(`${this.api}/view-patient/${search}`,{
      withCredentials:true
    });
  }
  getAppointment(patient): Observable<any> {
    return this.http.get<any>(`${this.api}/get-appiontment/${patient}`,{
      withCredentials:true
    });
  }
  addRating(request): Observable<any> {
    return this.http.post<any>(`${this.api}/add-ratingandreview`, request,{
      withCredentials:true
    });
  }
  getDoctor(search): Observable<any> {
    return this.http.get<any>(`${this.api}/view-doctor/${search}`, {
      withCredentials: true
    });
  }
  getAppointmentByName(doctor): Observable<any> {
    return this.http.get<any>(`${this.api}/get-appiontmentbyname/${doctor}`, {
    withCredentials:true
     } );
  }
  updateApprove(request): Observable<any> {
    return this.http.put<any>(`${this.api}/modify-Appiontment`, request,{
      withCredentials:true
    });
  }
  getRatingByName(doctor): Observable<any> {
    return this.http.get<any>(`${this.api}/get-ratingbyname/${doctor}`,{
      withCredentials:true
    });
  }
  updatePatient(request): Observable<any> {
    return this.http.put<any>(`${this.api}/modify-Patient`, request,{
      withCredentials:true
    });
  }
  deleteRating(rating) {
    return this.http.delete<any>(`${this.api}/delete-ratingandreview/${rating.ratingId}`,{
      withCredentials:true
    });
  }

  getAllRatings(): Observable<any> {
    return this.http.get<any>(`${this.api}/get-allratingandreviews`,{
      withCredentials:true
    } );
  }

  deletePatient(patient) {
    return this.http.delete<any>(`${this.api}/delete-patient/${patient.patientsId}`,{
      withCredentials:true
    });
  }

  getAllPatients(): Observable<any> {
    return this.http.get<any>(`${this.api}/view-allpatients`,{
      withCredentials:true
    });
  }

  deleteDoctor(doctor) {
    return this.http.delete<any>(`${this.api}/delete-doctor/${doctor.doctorsId}`,{
      withCredentials:true
    });
  }

  getAllDoctors(): Observable<any> {
    return this.http.get<any>(`${this.api}/get-alldoctors`, {
      withCredentials: true
    });
  }

  deleteAppointment(appointment) {
    return this.http.delete<any>(`${this.api}/delete-appointment/${appointment.appointmentId}`,{
      withCredentials:true
    });
  }

  getAllAppointment(): Observable<any> {
    return this.http.get<any>(`${this.api}/view-allappiontment`,{
      withCredentials:true
    });
  }
}
