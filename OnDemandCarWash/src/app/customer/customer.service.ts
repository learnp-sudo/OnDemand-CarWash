import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http:HttpClient) { }
  WpView(){
    return this.http.get("http://localhost:8082/customer/seeWP")
  }
  getAllCustomers(){
    return this.http.get("http://localhost:8081/admins/AllCustomers")
  }
  getCustomerByUsername(username:any){
    return this.http.get(`http://localhost:8082/customer/${username}`)

  }
  updateCustomerDetails(payload:any){
    return this.http.put(`http://localhost:8082/customer/update/${payload.id}`,payload)
  }
  getWashPackById(pack_id:any){
    return this.http.get(`http://localhost:8082/customer/washpack/${pack_id}`)
  }
  getWashPackName(name:any){
    return this.http.get(`http://localhost:8082/customer/washpack/name/${name}`)
  }
 
}
