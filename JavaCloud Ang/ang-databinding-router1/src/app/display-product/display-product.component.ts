import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-display-product',
  templateUrl: './display-product.component.html',
  styleUrls: ['./display-product.component.css']
})
export class DisplayProductComponent implements OnInit {
  @Input() userValue:{price:string,rating:number};

  constructor() { }

  ngOnInit() {
  }

}
