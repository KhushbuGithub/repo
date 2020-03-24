import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';
import { Product } from '../product';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  products: Product[];

  constructor(public service: ProductService, public router: Router) { }

  ngOnInit() {
    this.getProducts();
  }

  getProducts() {
    this.service.getAllProductsRequest().subscribe(resp => {
      console.log(resp.products);
      this.products = resp.products;
      console.log('product component', this.products);
    }, err => {
      console.log(err);
    }, () => {
      console.log('get request is sent');
    });
  }

}
