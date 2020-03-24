import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-databinding',
  templateUrl: './databinding.component.html',
  styleUrls: ['./databinding.component.css']
})
export class DatabindingComponent implements OnInit {

  month='January'
  day=21
  img='https://pixabay.com/photos/pisa-italy-tower-architecture-4840084/'
  student={
    name:'ram',
    age:21
  }

  flag=true;
  colSpan=2;
  inputvalueofemail:string;
  constructor() {
    setInterval(() =>{
      this.flag=!this.flag
    },
    2000)
   }

  ngOnInit() {
  }

  keyupData(inputTag){
    console.log(inputTag.value);
    this.inputvalueofemail=inputTag.value;
  }

}
