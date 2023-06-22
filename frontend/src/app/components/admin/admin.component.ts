import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../../restaurant';
import { RestaurantService } from '../../restaurant.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm} from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  public restaurants: Restaurant[] = [];
  public editRestaurant: Restaurant | undefined;
  public deleteRestaurant: Restaurant | undefined;

  failed: boolean = false;
  constructor (private router: Router, private restaurantService: RestaurantService) {}

  ngOnInit() {
    this.getRestaurants();
  }

  public getRestaurants(): void {
    this.restaurantService.getRestaurants().subscribe(
      (response: Restaurant[]) => {
        this.restaurants = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddRestaurant(addForm: NgForm): void {
    document.getElementById('add-restaurant-form')?.click();
    this.restaurantService.addRestaurant(addForm.value).subscribe(
      (response: Restaurant) => {
        console.log(response);
        this.getRestaurants();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateRestaurant(restaurant: Restaurant): void {
    this.restaurantService.updateRestaurant(restaurant).subscribe(
      (response: Restaurant) => {
        console.log(response);
        this.getRestaurants();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteRestaurant(restaurantId: number): void {
    this.restaurantService.deleteRestaurant(restaurantId).subscribe(
      (response: void) => {
        console.log(response);
        this.getRestaurants();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchRestaurants(key: string): void {
    const results: Restaurant[] = [];
    for(const restaurant of this.restaurants) {
      if (restaurant.name.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || restaurant.type.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || restaurant.price.toString().indexOf(key.toLowerCase()) !== -1) {
        results.push(restaurant)
      }
    }
    this.restaurants = results;
    if (results.length === 0 || !key) {
      this.getRestaurants();
    }
  }

  public onOpenModal(restaurant: Restaurant|null, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addRestaurantModal');
    }
    if (mode === 'edit') {
      this.editRestaurant = restaurant || undefined;
      button.setAttribute('data-target', '#updateRestaurantModal');
    }
    if (mode === 'delete') {
      this.deleteRestaurant = restaurant || undefined;
      button.setAttribute('data-target', '#deleteRestaurantModal');
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

  //
  // (response: this.restaurantService.logout()) => {
  //   this.restaurants = response;
  // },
  // (error: HttpErrorResponse) => {
  //   alert(error.message);
  // }
  }
}
