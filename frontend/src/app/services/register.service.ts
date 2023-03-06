import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  static getToken() {
    throw new Error('Method not implemented.');
  }

  Url="http://localhost:8084";

  constructor(private  http:HttpClient) { }
  
  doRegister(credentials:any)
  {
    return this.http.post(`${this.Url}/usersadd`,credentials)
  }
  // for registeruser
  registerUser(usersadd: string)
  {
    localStorage.setItem("usersadd",usersadd)
    return true;
  }
  isRegister()
  {
    const usersadd=localStorage.getItem("usersadd")
    if(usersadd==undefined|| usersadd===''|| usersadd==null )
    {
      return false
    }else{
      return true;
    }
  }
}
