import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-display-emp',
  templateUrl: './display-emp.component.html',
  styleUrls: ['./display-emp.component.css']
})
export class DisplayEmpComponent implements OnInit {
  @Input() userValue:{name:string ,price:string};

  constructor() { }

  ngOnInit() {
  }

}
