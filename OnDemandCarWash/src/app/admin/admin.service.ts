import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http:HttpClient) { 

  }
  get(){
    return this.http.get("http://localhost:8081/admins/all/findWP")
  }

  add(payload:any){
    return this.http.post("http://localhost:8081/admins/addWP",payload)
  }
  getById(pack_id:any){
    return this.http.get(`http://localhost:8081/admins/all/findWP/${pack_id}`)
  }
  update(payload:any){
    return this.http.put(`http://localhost:8081/admins/updateWP/${payload.pack_id}`, payload)
  }
  delete(pack_id:any){
    return this.http.delete(`http://localhost:8081/admins/deleteWP/${pack_id}`)
  }
}
  
