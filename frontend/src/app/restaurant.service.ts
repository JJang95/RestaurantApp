import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Restaurant } from './restaurant';
import { RestaurantUser} from './restaurantUser'
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class RestaurantService {
  headers:any;

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
  /** CRUD For Restaurant Users **/
public getRestaurantUsers(): Observable<any>{
  return this.http.get<any>(`${this.apiServerUrl}/user/all`);
}
public addRestaurantUser(resUser: RestaurantUser): Observable<RestaurantUser>{

}



  public login(auth: any){
    const email = auth.email;
    const password = auth.password
    const headers = new HttpHeaders({Authorization: 'Basic '+btoa(email+":"+password)});
    //
    // this.headers = new HttpHeaders ({Authorization: 'Basic '+btoa(email+":"+password)});
    sessionStorage.setItem("headers", btoa(email+":"+password));
    return  this.http.get("http://localhost:8080/authentication",{headers, responseType: 'text' as 'json'});
  }

  public logout(){
    const url:string = `${this.apiServerUrl}`+"logout";
    sessionStorage.removeItem("headers");
    return this.http.get(url);
  }
  // http://localhost:8080/authentication
  //
  // public async userid(username: string):Promise<string>{
  //   var uid! : string;
  //   const usernameURL: string = "httpL//localhost:8080/admin/find/";
  // }

}
