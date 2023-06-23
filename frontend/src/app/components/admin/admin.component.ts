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
    // This inital process so that restaurants are loaded onto the page
    this.getRestaurantUser();
  }

//Call this method will reload the page with an update of the restaurant list
  public getRestaurantUser(): void{
    this.restaurantService.getRestaurantUsers().subscribe(
      (response: RestaurantUser[]) => {
        this.restaurantUsers = response;
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      }
    )
  }
  public onAddRestaurantUser(addForm: NgForm): void{
    console.log("HELLO ADD USER");
    document.getElementById('add-restaurant-form')?.click();
    this.restaurantService.addRestaurantUser(addForm.value).subscribe(
      (response: RestaurantUser) =>{
        console.log(response);
        this.getRestaurantUser();
        addForm.reset();

      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
        addForm.reset();
      }
    )
  }
  public onDeleteRestaurantUser(r_UserId: number): void{
    this.restaurantService.deleteRestaurantUser(r_UserId).subscribe(
      (response: void) => {
        console.log(response);
        this.getRestaurantUser();
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      }
    )
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
    button.setAttribute('data-target', '#deleteRestaurantUserModal');
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
