import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SentEmailService {

  private isSent:boolean;
  
  constructor() { }
}
