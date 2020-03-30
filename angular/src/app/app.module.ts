import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';

import { SignUpComponent } from './sign-up/sign-up.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { ContestManagementComponent } from './contest-management/contest-management.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { CreateContestComponent } from './create-contest/create-contest.component';
import { DraftingPageComponent } from './drafting-page/drafting-page.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { LeagueOfLegendsPageComponent } from './league-of-legends-page/league-of-legends-page.component';

@NgModule({
  declarations: [
    AppComponent,
    SignUpComponent,
    SignInComponent,
    ContestManagementComponent,
    NavBarComponent,
    CreateContestComponent,
    DraftingPageComponent,
    LandingPageComponent,
    LeagueOfLegendsPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
