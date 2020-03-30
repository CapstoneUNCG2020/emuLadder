import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignUpComponent } from './sign-up/sign-up.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { InviteBarComponent } from './invite-bar/invite-bar.component';
import { DraftingPageComponent } from './drafting-page/drafting-page.component';
import { ContestManagementComponent } from './contest-management/contest-management.component';
import { LeagueOfLegendsPageComponent } from './league-of-legends-page/league-of-legends-page.component';

const routes: Routes = [
  { path: 'signUp', component: SignUpComponent},
  { path: 'signIn', component: SignInComponent},
  { path: 'invite', component: InviteBarComponent},
  { path: 'drafting', component: DraftingPageComponent},
  { path: 'contests', component: ContestManagementComponent},
  { path: 'LeagueOfLegends', component: LeagueOfLegendsPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }