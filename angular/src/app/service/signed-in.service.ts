import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SignedInService {

  private signedIn: boolean;

  constructor() { }

  public signIn(): void {
    this.signedIn = true;
  }

  public signOut(): void {
    this.signedIn = false;
  }

  public getStatus(): boolean {
    return this.signedIn;
  }
}
