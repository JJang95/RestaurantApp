import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import {FormControl, FormGroup, FormBuilder, Validators} from '@angular/forms'

@Component({
  selector: 'app-restaurant-login',
  templateUrl: './restaurant-login.component.html',
  styleUrls: ['./restaurant-login.component.css']
})
export class RestaurantLoginComponent implements OnInit {

  email: string= "";
  password: string = "";

  restaurantForm!: FormGroup;

  constructor(private formBuilder: FormBuilder, private router:Router){
    this.restaurantForm = new FormGroup({
      email: new FormControl(this.email,[Validators.required]),
      password: new FormControl(this.password, [Validators.required])
    });
  }

  async restaurantLogin(){
    console.log('hello world');
    this.router.navigate(['adminLogin']);

  }

  ngOnInit(){

  }
}
