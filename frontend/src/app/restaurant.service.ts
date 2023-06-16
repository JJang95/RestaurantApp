import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Restaurant } from './restaurant';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  private apiServerUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) { }

  public getRestaurants(): Observable<any>{
    return this.http.get<any>(`${this.apiServerUrl}/restaurant/all`);
  }

  public addRestaurant(restaurant: Restaurant): Observable<Restaurant>{
    return this.http.post<Restaurant>(`${this.apiServerUrl}/restaurant/add`, restaurant);
  }

  public updateRestaurant(restaurant: Restaurant): Observable<Restaurant>{
    return this.http.put<Restaurant>(`${this.apiServerUrl}/restaurant/update`, restaurant);
  }

  public deleteRestaurant(restaurantId: number): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/restaurant/delete/${restaurantId}`);
  }

}
