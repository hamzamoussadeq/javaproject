import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) { }
  url="http://localhost:8081/product"

  getProducts(){
    return this.http.get(`${this.url}/all-products`)
  }

  getProductByName(search:any){
    return this.http.get(`${this.url}/products/name/${search}`)
  }
}
