import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/model/customer';
import {  ActivatedRoute, Router } from '@angular/router';

import { Order } from 'src/app/model/order';
import { AuthenticationService } from 'src/app/service/authentication.service';
import { OrderService } from 'src/app/service/order.service';
declare let window: any;

@Component({
  selector: 'app-customer-my-orders',
  templateUrl: './customer-my-orders.component.html',
  styleUrls: ['./customer-my-orders.component.css']
})
export class CustomerMyOrdersComponent implements OnInit {
  OrderList: Array<Order> = [];
  currentUser: Customer = new Customer();
  cancelModal:any;
  idToCancel: any = "";
  
  user:any={
    username:'',
    password:''
  }

  
  constructor(private service:OrderService, private authentication:AuthenticationService, private router:Router){
    
  }
   username=this.authentication.getUsername()||''
  ngOnInit(): void {
   console.log(this.username)
    this.getOrderbyUsername(this.username);
    this.cancelModal=new window.bootstrap.Modal(
      document.getElementById("cancelModal")
     )
  }
  getOrderbyUsername(username:string){

    this.service.getOrderbyUsername(this.username).subscribe((data:any)=>{
      this.OrderList=data;

    })
  }
  openCancelModal(orderId: string){
    this.idToCancel =orderId;
    this.cancelModal.show();
    }

  
  cancelOrder(){
    this.service.cancelOrder(this.idToCancel).subscribe((data)=>{
     
      this.router.navigate(['user'])
      this.cancelModal.hide();
    })
  }
}
