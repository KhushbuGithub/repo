import { Component, OnInit } from '@angular/core';
import { BookMyDocService } from '../book-my-doc.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-approve-action',
  templateUrl: './approve-action.component.html',
  styleUrls: ['./approve-action.component.css']
})
export class ApproveActionComponent implements OnInit {
  success: any;
  failure: any;

  constructor(private bookMyDoc: BookMyDocService) {
   }

  ngOnInit() {
  }
  addApprove(form: NgForm) {
    this.bookMyDoc.updateApprove(form.value).subscribe(data => {
      console.log(data);
      if (data.statusCode === 201) {
        this.success = data.description;
        setTimeout(() => {
        this.success = null;
      }, 2000);
        form.reset();
    } else {
      this.failure = data.description;
      setTimeout(() => {
        this.failure = null;
      }, 2000);
    }
    });
  }

}
