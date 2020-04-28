import { Injectable } from '@angular/core';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root'
})
export class ResetPasswordService {

  private url = '/account/resetPassword';

  constructor(private rest: RestService) { }

  public resetPassword(email: string, oldPassword: string, newPassword: string): Promise<boolean> {
    let requestData = this.getReqData(email, oldPassword, newPassword);

    return this.post(requestData);
  }

  private getReqData(email: string, oldPassword: string, newPassword: string) {
    return {
      email: email,
      oldPassword: oldPassword,
      newPassword: newPassword
    }
  }

  private async post(requestData): Promise<boolean> {
    let promise = await this.rest.post<boolean>(this.url, requestData).toPromise();

    return promise.response;
  }
}
