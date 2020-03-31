import { Component, OnInit } from '@angular/core';
import { EventEmitter } from 'events';
import { stringify } from 'querystring';
import { SignUpService } from '../service/rest/sign-up.service';
import { SignedInService } from '../service/signed-in.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  firstName: string;
  lastName: string;
  phoneNumber: string;
  email: string;
  password: string;
  password2: string;

  /**
   * Whether or not the user has selected the agree to terms button.
   */
  agreed: boolean;

  errorMessage: string;

  constructor(private service: SignUpService, private signedInService: SignedInService) { }

  ngOnInit() {
  }

  signUp(): void {
    this.errorMessage = undefined;

    if (!this.verifyFieldsNotEmpty()) {
         this.errorMessage = 'All fields are required.';
    } else if (this.password != this.password2) {
      this.errorMessage = 'Password do not match.';
    } else if (!this.agreed) {
      this.errorMessage = 'Please agree to terms';
    } else {
      let promise = this.service.signUp(this.firstName, this.lastName, 
        this.email, this.phoneNumber, this.password);

      promise.then(response => {
        if (response.response) {
          this.signedInService.signIn();
          this.close();
        } else {
          this.errorMessage = response.errors.toString();
        }
      })
    }
  }

  verifyFieldsNotEmpty(): boolean {
    if (this.firstName == undefined || this.firstName == '') {
      return false;
    }

    if (this.lastName == undefined || this.lastName == '') {
      return false;
    }

    if (this.email == undefined || this.email == '') {
      return false;
    }

    if (this.phoneNumber == undefined || this.phoneNumber == '') {
      return false;
    }

    if (this.password == undefined || this.password == '') {
      return false;
    }

    return true;
  }

  close(): void {
    document.getElementById('close-signup-btn').click();
  }

  openLogIn(): void {
    this.close();

    // // Open the Log In modal
    let element = document.body.children[0].children[0]
      .children[0].children[0].children[2].children[0]
      .children[0].children[1] as HTMLElement;

    element.click();
  }

}