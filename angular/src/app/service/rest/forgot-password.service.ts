import { Injectable } from '@angular/core';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root'
})
export class ForgotPasswordService {

  private url = '/account/forgotPassword'

  constructor(private rest: RestService) { }

  public forgotPassword(email: string): Promise<boolean> {
    return this.post(email);
  }

  private async post(email: string): Promise<boolean> {
    let promise = await this.rest.post<boolean>(this.url, email).toPromise();

    return promise.response;
  }
}
