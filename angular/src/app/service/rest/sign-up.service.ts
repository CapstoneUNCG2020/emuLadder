import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SignUpService {

  private url = 'account/signup';

  constructor() { }

  private createRequestData(firstName: string, lastName: string, email: string, 
    phoneNumber: string, password: string) {
      return {
        firstName: firstName,
        lastName: lastName,
        email: email,
        phoneNumber: phoneNumber,
        password: password
      }
  }
}
