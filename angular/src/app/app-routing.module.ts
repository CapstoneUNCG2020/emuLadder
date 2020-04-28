import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignUpComponent } from './sign-up/sign-up.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { InviteBarComponent } from './invite-bar/invite-bar.component';
import { DraftingPageComponent } from './drafting-page/drafting-page.component';
import { ContestManagementComponent } from './contest-management/contest-management.component';
import { LeagueOfLegendsPageComponent } from './league-of-legends-page/league-of-legends-page.component';
import { CreateContestComponent } from './create-contest/create-contest.component';
import { FaqComponent } from './faq/faq.component';
import { ScoringRosterBreakdownComponent } from './scoring-roster-breakdown/scoring-roster-breakdown.component';
import { ComingSoonPageComponent } from './coming-soon-page/coming-soon-page.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { ResetPasswordComponent } from './reset-password/reset-password.component';
import { TermsComponent } from './terms/terms.component';
import { PrivacyComponent } from './privacy/privacy.component';

const routes: Routes = [
  { path: 'account/signup', component: SignUpComponent},
  { path: 'account/signin', component: SignInComponent},
  { path: 'contest/invite', component: InviteBarComponent},
  { path: 'contest/draft/:contestId', component: DraftingPageComponent},
  { path: 'contest/view', component: ContestManagementComponent},
  { path: 'games/leagueoflegends', component: LeagueOfLegendsPageComponent},
  { path: '', component: LandingPageComponent},
  { path: 'games/leagueoflegends/contest/create', component: CreateContestComponent},
  { path: 'info/faq', component: FaqComponent },
  { path: 'games/leagueoflegends/breakdown', component: ScoringRosterBreakdownComponent},
  { path: 'games/comingsoon', component: ComingSoonPageComponent},
  { path: 'account/forgotPassword', component: ForgotPasswordComponent},
  { path: 'account/resetPassword', component: ResetPasswordComponent},
  { path: 'info/terms', component: TermsComponent },
  { path: 'info/privacy', component: PrivacyComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }