import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  static getToken() {
    throw new Error('Method not implemented.');
  }

  url="http://localhost:8084"

  constructor(private http:HttpClient) { }

  // calling the server to generate token

 generateToken(credentials:any){
  return this.http.post(`${this.url}/token`,credentials)
  }

  signinUser(credentials:any){
    return this.http.post(`${this.url}/loginuser`,credentials);
  }

  getUser(){
    const id=localStorage.getItem("id");
    return this.http.get(`${this.url}/user/${id}`);
  }

  setUser(data:any){
    localStorage.setItem("id",data);
    
  }

  //for login user

loginUser(token: string)
{
  localStorage.setItem("token",token)
  return true;
}
//to check user login or not
isLoggedIn()
{
  const token=localStorage.getItem("token");
  if(token==undefined || token==='' || token==null)
  {
    return false;
  }
  else
  {
    return true;
  }
}
//for logout the user
logout(){
  localStorage.removeItem('token');
  return true;
}
//for getting token
getToken()
{
  return localStorage.getItem("token")
}


}