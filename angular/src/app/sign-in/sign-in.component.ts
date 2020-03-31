import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SignInService } from '../service/rest/sign-in.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {
  
  showLoginModal: boolean;
  registerForm: FormGroup;
  submitted = false;

  email: string;
  password: string;
  error: boolean;

  constructor(private formBuilder: FormBuilder, private service: SignInService) {
    //show-hide modal check
    this.showLoginModal = true;
   }

   //Bootstrap Modal Close event
   hide(){
     this.showLoginModal = false
   }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]]
    });
  }

  getErrorMessage(): string {
    return 'Invalid username / password';
  }

  login(): void {
    let promise = this.service.signIn(this.email, this.password);

    promise.then(success => {
      if (success) {
        console.log('SIGNED IN!!');
      } else {
        this.error = true;
      }
    });
  }
}
