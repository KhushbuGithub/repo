import { Component } from "@angular/core";
import { GlobalService } from '../global.service';

   
     @Component({
        selector:"app-Welcome",
        template:'<h1>Hello World Welcome</h1>',
        styles:['h1{background color:blue}']


     })



   export class WelcomeComponent{
       age:number=23;
       firstname;
        constructor(public service:GlobalService){
          this.firstname=this.service.name;
        }
  
   }