import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http:HttpClient) { }
  url="http://localhost:8082/cart"

  addToCart(cartData:any){
    return this.http.post(`${this.url}/addToCart`,cartData)
  }

  getCartItems(user:any){
    return this.http.post(`${this.url}/findByUser`,user)
  }
}
