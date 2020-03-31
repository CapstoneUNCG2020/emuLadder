import { Component, OnInit } from '@angular/core';
import { EventEmitter } from 'events';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  error: boolean;

  constructor() { }

  ngOnInit() {
  }

  getErrorMessage(): string {
    return 'Error creating account.';
  }

  signUp(): void {
    this.error = !this.error;
  }

  openLogIn(): void {
    // Close the Sign Up modal
    document.getElementById('close-signup-btn').click();

    // // Open the Log In modal
    let element = document.body.children[0].children[0]
      .children[0].children[0].children[2].children[0]
      .children[0].children[1] as HTMLElement;

    element.click();
  }

}