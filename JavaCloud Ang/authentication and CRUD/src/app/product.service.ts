import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  backendURL = 'http://localhost:8000/products';
  selectedProduct;

  constructor(public http: HttpClient) { }

  addProductRequest(data) {
    return this.http.post(`${this.backendURL}/add-product`, data);
  }

  getAllProductsRequest(): any {
    return this.http.get(`${this.backendURL}/get-products`);
  }

  updateProductRequest(data) {
    return this.http.put(`${this.backendURL}/update-product/${data._id}`, data);
  }

  deleteProductRequest(data) {
     return this.http.delete(`${this.backendURL}/delete-product/${data._id}`);
  }


}
