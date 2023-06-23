import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AdminComponent } from './components/admin/admin.component';
import {AdminLoginComponent} from './components/admin-login/admin-login.component';
import {RestaurantLoginComponent} from './components/restaurant-login/restaurant-login.component';
import { RestaurantComponent} from './components/restaurant/restaurant.component';
import { WelcomeComponent} from './components/welcome/welcome.component';
import { LoginComponent} from './components/login/login.component';
import { RestaurantService } from './restaurant.service';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    AdminLoginComponent,
    AdminComponent,
    RestaurantLoginComponent,
    RestaurantComponent,
    WelcomeComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
  ],
  providers: [RestaurantService],
  bootstrap: [AppComponent]
})
export class AppModule { }
