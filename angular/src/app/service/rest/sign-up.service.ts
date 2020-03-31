import { Injectable } from '@angular/core';
import { ResponseData } from 'src/app/model/response-data';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root'
})
export class SignUpService {

  private url = 'account/signup';

  constructor(private rest: RestService) { }

  public signUp(firstName: string, lastName: string, email: string, 
    phoneNumber: string, password: string): Promise<ResponseData<boolean>> {
      let requestData = this.createRequestData(firstName, lastName, email, phoneNumber, password);

      return this.post(requestData);
  }

  private post(requestData): Promise<ResponseData<boolean>> {
    return this.rest.post<boolean>(this.url, requestData).toPromise();
  }

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
