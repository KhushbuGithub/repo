import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@ Injectable({
  providedIn: 'root'
})
export class AppointmentService {
  api = 'http://localhost:8080';

  constructor(private http : HttpClient) { }

  deleteAppointment(appointment:Appointment) {
    return this.http.delete< any>(`${this.api}/delete-appointment/${appointment.appointmentId}`);
    }

    getAllAppointment(): Observable< any> {
      return this.http.get< any>(`${this.api}/view-allappointment`);
    }
}
