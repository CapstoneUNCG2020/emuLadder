import { Injectable } from '@angular/core';
import { Contest } from 'src/app/model/contest';
import { RestService } from './rest.service';

@Injectable({
  providedIn: 'root'
})
export class PublicContestDetailsService {

  private url = '/games/leagueoflegends';

  constructor(private rest: RestService) { }

  public getPublicContestDetails() : Promise<Contest> {
    return this.get();
  }

  private async get(): Promise<Contest> {
    let promise = await this.rest.get<Contest>(this.url).toPromise();

    return promise.response;
  }
}
