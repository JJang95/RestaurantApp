import { Component,Input, OnInit } from '@angular/core';
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

  adminForm!: FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router){

    //This is showing the email and password visible
    this.adminForm = new FormGroup({
      email: new FormControl(this.email, [Validators.required]),
      password: new FormControl(this.password, [Validators.required])
    });
  }

  async adminLogin(){
    console.log(this.adminForm.value);
    this.router.navigate(["restaurant"]);
  }

  ngOnInit(){

  }
}
