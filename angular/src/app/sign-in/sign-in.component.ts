import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SignInService } from '../service/rest/sign-in.service';
import { Router } from '@angular/router';
import { SignedInService } from '../service/signed-in.service';


@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {
  email: string;
  password: string;
  error: boolean;

  constructor(private service: SignInService, private signedInService: SignedInService) { }

  ngOnInit() { }

  getErrorMessage(): string {
    return 'Invalid username / password';
  }

  login(): void {
    let promise = this.service.signIn(this.email, this.password);

    promise.then(success => {
      if (success) {
        this.signedInService.signIn();
        this.close();
      } else {
        this.error = true;
      }
    });
  }

  close(): void {
    document.getElementById('close-login-btn').click();
  }

  openSignUp(): void {
    this.close();

    // Open the Log In modal
    let element = document.body.children[0].children[0]
      .children[0].children[0].children[2].children[1]
      .children[0].children[1] as HTMLElement;

    element.click();
  }
}
