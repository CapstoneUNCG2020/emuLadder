import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignUpComponent } from './sign-up/sign-up.component';
import { GameCardComponent } from './landing-page/game-card/game-card.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { InviteBarComponent } from './invite-bar/invite-bar.component';
import { DraftingPageComponent } from './drafting-page/drafting-page.component';
import { ContestManagementComponent } from './contest-management/contest-management.component';
import { LeagueOfLegendsPageComponent } from './league-of-legends-page/league-of-legends-page.component';
import { CreateContestComponent } from './create-contest/create-contest.component';
import { GetStartedComponent } from './landing-page/get-started/get-started.component';

const routes: Routes = [
  { path: 'SignUp', component: SignUpComponent},
  { path: 'SignIn', component: SignInComponent},
  { path: 'invite', component: InviteBarComponent},
  { path: 'drafting', component: DraftingPageComponent},
  { path: 'contests', component: ContestManagementComponent},
  { path: 'LeagueOfLegends', component: LeagueOfLegendsPageComponent},
  { path: 'landingPage', component: LandingPageComponent},
  { path: 'gamecard', component: GameCardComponent},
  { path: 'create', component: CreateContestComponent},
  { path: 'getStarted', component: GetStartedComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }