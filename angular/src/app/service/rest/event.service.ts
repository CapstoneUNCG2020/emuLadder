import { Injectable } from '@angular/core';
import { RestService } from './rest.service';
import { Events } from 'src/app/model/events';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  private url = '/event/test'

  constructor(private rest: RestService) { } 

  public getEvents(): Promise<Array<Events>> {
    return this.get();
  }

  private async get(): Promise<Array<Events>> {
    let promise = await this.rest.get<Array<Events>>(this.url).toPromise()

    return promise.response;
  }
}
