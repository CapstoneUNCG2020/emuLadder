import { Injectable } from '@angular/core';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root'
})
export class SendEmailService {
  private url = '/email/send';
  constructor(private rest: RestService) { }

  public sendEmail(email: string, message: string, subject:string): Promise<boolean> {
    let requestData = this.createReqData(email, subject, message);
    
    return this.post(requestData);
  }

    /**
   * Sends the request data to the backend and receives a promise back.
   * 
   * @param requestData { email, message }
   */
  private async post(requestData): Promise<boolean> {
    let promise = await this.rest.post<boolean>(this.url, requestData).toPromise();

    return promise.response;
  }

  /**
   * request data for the backend service.
   * 
   * @param email 
   * @param message
   */
  private createReqData(email: string, subject: string, message: string) {
    return {
      recipient: email,
      content: message,
      subject: subject
    }
  }


}
