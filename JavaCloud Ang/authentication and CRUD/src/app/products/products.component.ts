import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Product } from '../product';
import { Router } from '@angular/router';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

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

  selectedProduct(product) {
    console.log(product);
    this.service.selectedProduct = product;
    console.log(this.service.selectedProduct);
    this.router.navigateByUrl('/update-product');
  }

  selectProduct(product) {
    this.service.deleteProductRequest(product).subscribe(resp => {
      console.log(resp);
      this.products.splice(this.products.indexOf(product), 1);
    }, err => {
      console.log(err);
    }, () => {
      console.log('delete request sent');
    });
  }
}
