import { Injectable } from '@angular/core';
import { RestService } from './rest.service';
import { Events } from 'src/app/model/events';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  private url = '/event/test'
  private url2 = '/event/latest'

  constructor(private rest: RestService) { } 

  public getEvents(): Promise<Array<Events>> {
    return this.get();
  }

  public getLatestEvents(): Promise<Array<Events>> {
    return this.get2();
  }

  private async get(): Promise<Array<Events>> {
    let promise = await this.rest.get<Array<Events>>(this.url).toPromise()

    return promise.response;
  }

  private async get2(): Promise<Array<Events>> {
    let promise = await this.rest.get<Array<Events>>(this.url2).toPromise()

    return promise.response;
  }
}
