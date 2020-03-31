import { Component, OnInit } from '@angular/core';

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

}
