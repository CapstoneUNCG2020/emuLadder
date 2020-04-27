import { Component, OnInit } from '@angular/core';
import { ForgotPasswordService } from '../service/rest/forgot-password.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  email: string;
  status: string;

  constructor(private service: ForgotPasswordService) { }

  ngOnInit() { }

  forgotPassword(): void {
    let promise = this.service.forgotPassword(this.email);

    promise.then(response => {
      if (response) {
        this.status = "SUCCESS!";
      } else {
        this.status = "ERROR";
      }
    })
  }

}
