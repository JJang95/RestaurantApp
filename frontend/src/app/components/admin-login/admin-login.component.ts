import { Component,Input, OnInit } from '@angular/core';
import { RestaurantService } from '../../restaurant.service'
import {FormControl, FormGroup, FormBuilder, Validators} from '@angular/forms'
import { Router } from '@angular/router'

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit{

  email: string = "";
  password: string = "";

  failed: boolean = false;

  adminForm!: FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router, private service: RestaurantService){

    //This is showing the email and password visible
    this.adminForm = new FormGroup({
      email: new FormControl(this.email, [Validators.required]),
      password: new FormControl(this.password, [Validators.required])
    });
  }

  async adminLogin(){
    let resp = this.service.login(this.adminForm.value);
    resp.subscribe({
      next: (response) => {
        if(response.toString()===("true")){
          this.router.navigate(["restaurant"]);
        }
      },//this.router.navigate(["restaurant"]),
      error: (error) => this.failed = true
    });
  }



  ngOnInit(){

  }
}
