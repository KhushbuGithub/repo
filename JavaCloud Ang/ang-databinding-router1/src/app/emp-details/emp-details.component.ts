import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-emp-details',
  templateUrl: './emp-details.component.html',
  styleUrls: ['./emp-details.component.css']
})
export class EmpDetailsComponent implements OnInit {
  name;
  price;
  Product:{name:string,price:string}[]=[];

  constructor() { }

  ngOnInit() {
  }

  onAddedProduct(data){
    console.log("product-details", data);
    console.log("on added method");
    this.Product.push(data);
  }

}
