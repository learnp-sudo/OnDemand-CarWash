import { Component, OnInit } from '@angular/core';
import { OrderService } from 'src/app/service/order.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-unassign-orders',
  templateUrl: './unassign-orders.component.html',
  styleUrls: ['./unassign-orders.component.css']
})
export class UnassignOrdersComponent implements OnInit{
 OrderList:any;
  constructor(private service:OrderService, private  location:Location){}
  ngOnInit(): void {
    this.unAssignedOrders();
  }
  unAssignedOrders()
    {
 this.service.getUnassigned().subscribe((data)=>{
  this.OrderList=data
 })
    }
    back(){
      this.location.back();
    }
  
}
