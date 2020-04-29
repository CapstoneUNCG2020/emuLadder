import { Component, OnInit } from '@angular/core';
import { ResetPasswordService } from '../service/rest/reset-password.service';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent implements OnInit {

  status: string;
  errorMsg: string;

  email: string;
  oldPassword: string;
  password: string;
  password2: string;

  constructor(private service: ResetPasswordService) { }

  ngOnInit(): void { }

  resetPassword(): void {
    if (this.confirmPassword()) {
      let promise = this.service.resetPassword(this.email, this.oldPassword, this.password);

      promise.then(response => {
        if (response) {
          this.status = 'SUCCESS';
        } else {
          this.status = 'ERROR';
          this.errorMsg = 'Invalid email/password combination.'
          this.clearPasswords();
        }
      });
    } else {
      this.status = 'ERROR';
      this.clearPasswords();
    }
  }

  confirmPassword(): boolean {
    let p1 = this.password;
    let p2 = this.password2;

    if (p1 != p2) {
      this.errorMsg = 'Passwords do not match.';
      return false;
    } else if (p1 == undefined || p1 == '') {
      this.errorMsg = 'Password cannot be blank.';
      return false;
    } else if (p1 == this.oldPassword) {
      this.errorMsg = 'New password cannot be old password.';
      return false;
    }

    return true;
  }

  clearPasswords(): void {
    this.password = undefined;
    this.password2 = undefined;
    this.oldPassword = undefined;
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
