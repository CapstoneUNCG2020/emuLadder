import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RestService {

  private baseUrl: string;

  constructor(private http: HttpClient) { }

  public post<T>(url: string, request: any): Observable<T> {
    return this.http.post<T>(this.baseUrl + url, request);
  }

  public get<T>(url: string): Observable<T> {
    return this.http.get<T>(this.baseUrl + url);
  }
}
