import { Component, OnInit } from '@angular/core';
import { RestaurantUser } from '../../restaurantUser';
import { RestaurantService } from '../../restaurant.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm, FormsModule, ReactiveFormsModule} from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})



export class AdminComponent implements OnInit {
  public restaurantUsers: RestaurantUser[] = [];
  public editRestaurantUser: RestaurantUser | undefined;
  public deleteRestaurantUser: RestaurantUser | undefined;

  failed: boolean = false;
  constructor (private router: Router, private restaurantService: RestaurantService) {}

  ngOnInit() {
  //  this.getRestaurants();
  }

  public onAddRestaurantUser(addForm: NgForm): void{
    console.log("HELLO ADD USER");
    document.getElementById('add-restaurant-form')?.click();
  }

public onOpenModal(restaurantUser: RestaurantUser|null, mode:string): void{
  const container = document.getElementById('main-container');
  const button = document.createElement('button');
  button.type = 'button';
  button.style.display = 'none';
  button.setAttribute('data-toggle','modal');
  if(mode==='add'){
    console.log("ADD");
    button.setAttribute('data-target', '#addRestaurantUserModal');
  }
  if(mode === 'edit'){
    this.editRestaurantUser = restaurantUser || undefined;
  }
  if(mode === 'delete'){
    this.deleteRestaurantUser = restaurantUser || undefined;
    console.log("DELETE");
  }
  container?.appendChild(button);
  button.click();
}



  async logout(){
    let resp = this.restaurantService.logout();
  //   resp.subscribe({
  //     next: resp => this.router.navigate(["login"]),
  //     error:  (error) => this.failed=true//(error)=> this.failed = true
  //   })
  resp.subscribe(
    response => {
      console.log(response);
    },
    (error: HttpErrorResponse) =>{
      alert(error.message);
    }
  );
  }
}
