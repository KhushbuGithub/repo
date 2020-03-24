import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {

  constructor(public service: ProductService, public router: Router) { }

  ngOnInit() {
  }

  updateProductData(form) {
    console.log(form.value);
    this.service.updateProductRequest(form.value).subscribe(resp => {
      console.log(resp);
      this.router.navigateByUrl('/products');
    }, err => {
      console.log(err);
    }, () => {
      console.log('update product request sent');
    });
  }
}
