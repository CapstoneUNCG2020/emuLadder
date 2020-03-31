import { Component, OnInit } from '@angular/core';
import { SignedInService } from '../service/signed-in.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  constructor(private signedInService: SignedInService, private router: Router) { }

  ngOnInit() {
  }

  logout(): void {
    this.signedInService.signOut();
    this.router.navigateByUrl('');
  }

  isSignedIn(): boolean {
    return this.signedInService.getStatus();
  }
}
