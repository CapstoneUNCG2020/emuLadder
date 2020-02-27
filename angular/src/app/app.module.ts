import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { SignUpComponent } from './sign-up/sign-up.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { ContestManagementComponent } from './contest-management/contest-management.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { CreateContestComponent } from './create-contest/create-contest.component';
import { DraftingPageComponent } from './drafting-page/drafting-page.component';

@NgModule({
  declarations: [
    AppComponent,
    SignUpComponent,
    SignInComponent,
    ContestManagementComponent,
    NavBarComponent,
    CreateContestComponent,
    DraftingPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
