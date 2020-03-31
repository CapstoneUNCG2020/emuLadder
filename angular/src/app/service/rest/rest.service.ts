import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ResponseData } from 'src/app/model/response-data';

@Injectable({
  providedIn: 'root'
})
export class RestService {

  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  public post<T>(url: string, request: any): Observable<ResponseData<T>> {
    return this.http.post<ResponseData<T>>(this.baseUrl + url, request);
  }

  public get<T>(url: string): Observable<ResponseData<T>> {
    return this.http.get<ResponseData<T>>(this.baseUrl + url);
  }
}
