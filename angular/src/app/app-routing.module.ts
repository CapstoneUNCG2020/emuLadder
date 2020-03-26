import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignUpComponent } from './sign-up/sign-up.component';
import {GameCardComponent} from './landing-page/game-card/game-card.component';
import { LandingPageComponent } from './landing-page/landing-page.component';


const routes: Routes = [
  { path: 'SignUp', component: SignUpComponent},
  { path: 'landingPage', component: LandingPageComponent},
  { path: 'gamecard', component: GameCardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
