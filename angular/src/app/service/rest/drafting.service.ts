import { Injectable } from '@angular/core';
import { RestService } from './rest.service';
import { Player } from 'src/app/model/player';
import { SignedInService } from '../signed-in.service';

@Injectable({
  providedIn: 'root'
})
export class DraftingService {

  private url = '/drafting/draft';

  constructor(private rest: RestService, private signedInService: SignedInService) { }

  public draftPlayers(players: Array<Player>, contestId: number): Promise<boolean> {
    let requestData = this.getRequestData(players, contestId);

    return this.post(requestData);
  }

  private getRequestData(players: Array<Player>, contestId: number) {
    return {
      email: this.signedInService.getEmail(),
      contestId: contestId,
      bottom: players[0],
      jungle: players[1],
      mid: players[2],
      support: players[3],
      top: players[4]
    }

  }

  private async post(requestData): Promise<boolean> {
    let promise = await this.rest.post<boolean>(this.url, requestData).toPromise();

    return promise.response;
  }
}
