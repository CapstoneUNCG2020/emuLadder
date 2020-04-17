import { Injectable } from '@angular/core';
import { Contest } from 'src/app/model/contest';
import { RestService } from './rest.service';
import { SignedInService } from '../signed-in.service';

@Injectable({
  providedIn: 'root'
})
export class CreateContestService {

  private REGION = 'LCS';
  private URL = '/contest/create';

  constructor(private rest: RestService, private signedInService: SignedInService) { }

  public createContest(contestType: number, entryFee: number, name: string, startDate: string): Promise<Contest> {
    let requestData = this.createRequestData(contestType, entryFee, name, startDate);

    return this.post(requestData);
  }

  private async post(requestData): Promise<Contest> {
    let promise = await this.rest.post<Contest>(this.URL, requestData).toPromise();

    return promise.response;
  }

  private createRequestData(contestType: number, entryFee: number, name: string, startDate: string) {
    return {
      start: startDate,
      entreeFee: entryFee,
      contestType: contestType,
      name: name,
      createdBy: this.signedInService.getEmail(),
      region: this.REGION
    }
  }
}
