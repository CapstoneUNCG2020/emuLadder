import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignUpComponent } from './sign-up/sign-up.component';
import { LeagueOfLegendsPageComponent } from './league-of-legends-page/league-of-legends-page.component';


const routes: Routes = [
  { path: 'SignUp', component: SignUpComponent},
  { path: 'LeagueOfLegends', component: LeagueOfLegendsPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
