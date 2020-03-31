import { Injectable } from '@angular/core';
import { RestService } from './rest.service';
import { ResponseData } from 'src/app/model/response-data';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SignInService {

  /**
   * Post mapping of the controller
   */
  private url = '/account/signin';

  constructor(private rest: RestService) { }

  public signIn(email: string, password: string): Promise<boolean> {
    let requestData = this.createReqData(email, password);
    
    return this.post(requestData);
  }

  /**
   * Sends the request data to the backend and receives a promise back.
   * 
   * @param requestData { email, password }
   */
  private async post(requestData): Promise<boolean> {
    let promise = await this.rest.post<boolean>(this.url, requestData).toPromise();

    return promise.response;
  }

  /**
   * Combine the email and password into the desired 
   * request data for the backend service.
   * 
   * @param email - the email logging in with
   * @param password - the password logging in with
   */
  private createReqData(email: string, password: string) {
    return {
      email: email,
      password: password
    }
  }
}
