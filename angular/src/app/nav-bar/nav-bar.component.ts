import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  public signedIn: boolean;

  constructor(private router: Router) { }

  ngOnInit() {
  }

  public signIn(): void {
    this.signedIn = true;
  }

  public signOut(): void {
    this.signedIn = false;
    this.router.navigateByUrl('');
  }
}
