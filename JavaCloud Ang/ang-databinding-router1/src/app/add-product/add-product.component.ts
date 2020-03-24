import { Component, OnInit, EventEmitter, Output,   } from '@angular/core';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  @Output() addPro= new EventEmitter();
  price;
  rating;


  constructor() { }

  ngOnInit() {
  }

  addProductDetails(){
    console.log("method is called");
    console.log(this.price);
    console.log(this.rating);
    this.addPro.emit({
      price:this.price,
       rating:this.rating
    })
  }

}
