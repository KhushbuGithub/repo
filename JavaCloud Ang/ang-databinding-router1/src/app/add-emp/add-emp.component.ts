import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-add-emp',
  templateUrl: './add-emp.component.html',
  styleUrls: ['./add-emp.component.css']
})
export class AddEmpComponent implements OnInit {
  @Output() addProduct=new EventEmitter();
  name;
  price;

  constructor() { }

  ngOnInit() {
  }

  onAddedProduct(){
    console.log("method is called");
    console.log(this.name);
    console.log(this.price);
    this.addProduct.emit({
      name:this.name,
      price:this.price
    })
  }
}
