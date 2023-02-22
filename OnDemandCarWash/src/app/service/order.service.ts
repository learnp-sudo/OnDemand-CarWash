import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from '../model/order';
const Base_URL='http://localhost:8083/orders';
@Injectable({
  providedIn: 'root'
})
export class OrderService {
  [x: string]: any;
  

  constructor(private http:HttpClient) { }
  getAllOrders()
  {
    return this.http.get(Base_URL+'/findall');
  }
  getOrderById(orderId:any){
    return this.http.get(`http://localhost:8083/orders/findone/${orderId}`)
  }
  getComletedOrders()
  {
    return this.http.get(Base_URL+ '/findCompleted');
  }
  getCancelledOrders()
  {
    return this.http.get(Base_URL+'/findCancelled');
  }
  getPendingOrders(){
    return this.http.get(Base_URL+'/findPending');
  }
  getUnassigned(){
    return this.http.get(Base_URL+'/findUnassigned');
  }
  updateStatus(orderId:any):Observable<Object>{
    return this.http.put(Base_URL+'/updateStatus/completed/' + orderId,{
      headers: this['getHeaders'],
    } 
     );
  }
  AssignWasher(payload:any){
    return this.http.put(Base_URL+`/assignWasher/${payload.orderId}`,payload)
  }
getOrdersByEmail(useremailid:string){
  return this.http.get(Base_URL +'/findMyOrdes/'+useremailid);
}
getWasherOrders(washername:string){
  return this.http.get(Base_URL +'/washerSpecificOrder/'+washername);
  
}
cancelOrder(orderId:any):Observable<Object>{
  return this.http.put(Base_URL+`/cancelOrder/${orderId}`,{ headers: this['getHeaders'],})
}
deleteOrder(orderId:any)
{
  return this.http.delete(Base_URL+`/delete/${orderId}`)
}
placeOrder(orderDetails:Order){
  return this.http.post(Base_URL+'/placeOrder',orderDetails)
}
getOrderbyUsername(username:string){
  return this.http.get(Base_URL+`/findOneOrder/${username}`);
}
  

}
