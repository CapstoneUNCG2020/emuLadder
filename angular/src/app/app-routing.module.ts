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
import { FaqComponent } from './faq/faq.component';
import { ScoringRosterBreakdownComponent } from './scoring-roster-breakdown/scoring-roster-breakdown.component';

const routes: Routes = [
  { path: 'account/signup', component: SignUpComponent},
  { path: 'account/signin', component: SignInComponent},
  { path: 'contest/invite', component: InviteBarComponent},
  { path: 'contest/draft', component: DraftingPageComponent},
  { path: 'contest/view', component: ContestManagementComponent},
  { path: 'games/leagueoflegends', component: LeagueOfLegendsPageComponent},
  { path: '', component: LandingPageComponent},
  { path: 'gamecard', component: GameCardComponent},
  { path: 'games/leagueoflegends/contest/create', component: CreateContestComponent},
  { path: 'info/faq', component: FaqComponent },
  { path: 'games/leagueoflegends/breakdown', component: ScoringRosterBreakdownComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }