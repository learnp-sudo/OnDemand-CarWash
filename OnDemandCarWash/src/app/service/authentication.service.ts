import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  currentUser: any;

  constructor(private http:HttpClient, private router:Router) { }
  register(payload: any) {
    return this.http.post("http://localhost:8082/customer/register", payload);
  }
  login(payload:any){
    return this.http.post("http://localhost:8082/customer/login",payload);
  }
  registerAdmin(payload:any){
    return this.http.post("http://localhost:8081/admins/register",payload);
  }
  loginAdmin(payload:any){
    return this.http.post("http://localhost:8081/admins/login",payload);
  }
  loginWasher(payload:any){
    return this.http.post("http://localhost:8084/washers/login",payload);
  }
  registerWasher(payload:any){
    return this.http.post("http://localhost:8084/washers/register",payload)
  }
loggedIn(){
  return !!localStorage.getItem('token')
}

getToken(){
  return localStorage.getItem('token')
}
getUsername(){
  return localStorage.getItem('username')
}
logoutUser(){
  localStorage.removeItem('token');
  localStorage.removeItem('username')
  this.router.navigate(['/landing-page'])
}

}
