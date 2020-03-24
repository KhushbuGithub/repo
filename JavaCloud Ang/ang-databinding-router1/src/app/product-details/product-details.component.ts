import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  price;
  rating;
  Product1:{price:string,rating:number}[]=[];

  constructor() { }

  ngOnInit() {
  }

  onAddedProduct(data){
    console.log("product-details",data);
    console.log("on added method");
    this.Product1.push(data);
  }

}
