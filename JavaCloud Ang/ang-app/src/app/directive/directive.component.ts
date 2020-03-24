import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directive',
  templateUrl: './directive.component.html',
  styleUrls: ['./directive.component.css']
})
export class DirectiveComponent implements OnInit {

  product :{name:string , cost:number,imgurl:string}[]=[
    {
    name:'Moblie',
    cost:2600000,
    imgurl:'https://www.91-img.com/gallery_images_uploads/6/8/68f046ed076c6cfd9f2d5429d3f34f786edc4208.jpeg?tr=h-550,w-0,c-at_max'
    },
    {
      name:'Laptop',
    cost:2600000,
    imgurl:'https://www.91-img.com/gallery_images_uploads/6/8/68f046ed076c6cfd9f2d5429d3f34f786edc4208.jpeg?tr=h-550,w-0,c-at_max'
    }
  ]

  isActive=false;
  constructor() { 
    setTimeout(() => {
      this.isActive = true;
    }, 2000);
  }

  ngOnInit() {
  }

}
