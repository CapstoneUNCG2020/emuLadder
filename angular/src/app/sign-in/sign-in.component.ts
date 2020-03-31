import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {
  
  showLoginModal: boolean;
  registerForm: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder) {
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

  get form(){
    return this.registerForm.controls;
  }

  onSubmit(){
    this.submitted = true;
    //checks if form is valid
    if(this.registerForm.invalid){
      return;
    }
    if(this.submitted){
      this.showLoginModal = false;
    }
  }
}
