import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './model/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  private url: string;

  constructor(private http: HttpClient) {
    this.url = "http://localhost:8080/getName";
   }

  public getName(user: User): Observable<string> {
      let o = this.http.post<string>(this.url, user);

      o.subscribe(x => {
        console.log(x);
      })

      return o;
  }
}
