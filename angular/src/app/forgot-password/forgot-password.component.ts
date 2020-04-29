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
  errorMsg: string;

  constructor(private service: ForgotPasswordService) { }

  ngOnInit() { }

  forgotPassword(): void {
    if (this.verifyEmail()) {
      let promise = this.service.forgotPassword(this.email);

      promise.then(response => {
        if (response) {
          this.status = 'SUCCESS';
        } else {
          this.status = 'ERROR';
          let email = this.email;
          this.email = undefined;
          this.errorMsg = 'Unable to find account associated with email address <b>' + email + '</b>';
        }
      });
    }
  }

  verifyEmail(): boolean {
    let regex = '^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$';

    if (this.email == undefined || this.email == '' || !this.email.match(new RegExp(regex))) {
      this.errorMsg = 'Invalid email';
      this.status = 'ERROR';
      return false;
    } else {
      return true;
    }
  }

  getColor(): string {
    let color: string;

    if (this.status == 'SUCCESS') {
      color = 'green';
    } else {
      color = 'red';
    }

    return 'color: ' + color;
  }
}
