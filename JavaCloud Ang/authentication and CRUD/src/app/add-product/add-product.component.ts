import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  constructor(public service: ProductService) { }

  ngOnInit() {
  }

  addProductData(form) {
    console.log(form.value);
    this.service.addProductRequest(form.value).subscribe(resp => {
      console.log(resp);
    }, err => {
      console.log(err);
    }, () => {
      console.log('add product request is sent');
    });
  }

}
