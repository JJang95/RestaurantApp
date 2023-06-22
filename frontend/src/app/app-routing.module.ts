//ng generate module app-routing --module app --flat

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { AdminLoginComponent} from './components/admin-login/admin-login.component';
import { RestaurantLoginComponent} from './components/restaurant-login/restaurant-login.component';
import { RestaurantComponent} from './components/restaurant/restaurant.component';
import { WelcomeComponent} from './components/welcome/welcome.component';
import { LoginComponent} from './components/login/login.component';
import { AdminComponent } from './components/admin/admin.component';

const routes: Routes = [
  { path: '', component: WelcomeComponent},
  { path: 'welcome', component: WelcomeComponent},
  { path: 'adminLogin', component: AdminLoginComponent},
  { path: 'restauarantLogin', component: RestaurantLoginComponent},
  { path: 'restaurant', component: RestaurantComponent},
  { path: 'login', component: LoginComponent},
  { path: 'admin', component: AdminComponent}
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})



export class AppRoutingModule { }
