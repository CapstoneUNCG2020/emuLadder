import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignUpComponent } from './sign-up/sign-up.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { DraftingPageComponent } from './drafting-page/drafting-page.component';


const routes: Routes = [
  { path: 'signUp', component: SignUpComponent},
  { path: 'signIn', component: SignInComponent},
  { path: 'drafting', component: DraftingPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
