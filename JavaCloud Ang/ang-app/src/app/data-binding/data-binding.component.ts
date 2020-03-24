import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-data-binding',
  templateUrl: './data-binding.component.html',
  styleUrls: ['./data-binding.component.css']
})
export class DataBindingComponent implements OnInit {

fullname='John'
imgurl= 'https://pixabay.com/photos/hoan-kiem-lake-ha-noi-viet-nam-4792884/'
Person={
  name:'ramu',
  age:12
}
 inputvalueofemail:string;
flag=true;
colSpanValue=2;

constructor(){
  setInterval(() => {
    this.flag=!this.flag;
  },2000);

}
ngOnInit(){

}

keyupData(inputTag){
  console.log(inputTag.value);
  this.inputvalueofemail=inputTag.value;
}

}
