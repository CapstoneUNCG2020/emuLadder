import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SentEmailService {

  private isSent:boolean;
  
  constructor() { }

  public sent(): void{
    this.isSent = true;
  }

  public sentStatus(): boolean{
    return this.isSent;
  }
}
