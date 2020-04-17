import { Injectable } from '@angular/core';
import { Contest } from 'src/app/model/contest';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root'
})
export class ContestDetailsService {

  private url = '/contest/';

  constructor(private rest: RestService) { }

  public getContestDetails(contestId: string): Promise<Contest> {
    return this.get(contestId);
  }

  private async get(contestId: string): Promise<Contest> {
    let promise = await this.rest.get<Contest>(this.url + contestId).toPromise();

    return promise.response;
  }
}
