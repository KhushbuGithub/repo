import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { BookMyDocService } from '../book-my-doc.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  constructor(private docService: BookMyDocService,
              private router: Router) { 
              }

  ngOnInit() {
  }
  search(city: HTMLInputElement){
    this.docService.valueOfSearchCity = city.value;
    this.router.navigateByUrl('/view-search');
  }
}
