import { Injectable } from '@angular/core';
import { RestService } from './rest.service';
import { SignedInService } from '../signed-in.service';
import { RegisteredContests } from 'src/app/model/registered-contests';

/* Helper class is needed */
class MyContests {
  registeredContests: Array<RegisteredContests>;
}

@Injectable({
  providedIn: 'root'
})
export class RegisteredContestService {

  private url = '/contest/registered';

  constructor(private rest: RestService, private signedInService: SignedInService) { }

  public getRegisteredContests(): Promise<Array<RegisteredContests>> {
    // let email = this.signedInService.getEmail();
    let email = this.signedInService.getEmail();

    return this.post(email);
  }

  private async post(email): Promise<Array<RegisteredContests>> {
    let promise = await this.rest.post<MyContests>(this.url, email).toPromise();

    return promise.response.registeredContests;
  }
}
