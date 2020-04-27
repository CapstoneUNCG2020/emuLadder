import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SignedInService {

  private signedIn: boolean;
  private email: string;

  constructor() { }

  public signIn(email: string): void {
    this.signedIn = true;
    this.email = email;
  }

  public signOut(): void {
    this.signedIn = false;
    this.email = undefined;
  }

  public getStatus(): boolean {
    return this.signedIn;
  }

  public getEmail(): string {
    return this.email;
  }
}
