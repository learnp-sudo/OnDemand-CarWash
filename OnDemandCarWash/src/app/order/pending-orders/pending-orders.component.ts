
import { Component, OnInit } from '@angular/core';
import { OrderService } from 'src/app/service/order.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-pending-orders',
  templateUrl: './pending-orders.component.html',
  styleUrls: ['./pending-orders.component.css']
})
export class PendingOrdersComponent implements OnInit{
  OrderList:any;
  constructor(private service:OrderService, private location:Location){}
  ngOnInit(): void {
    this.getPendingOrders();
  }
  getPendingOrders()
  {
     this.service.getPendingOrders().subscribe((data)=>{
      this.OrderList=data
     });
  }
  back()
  {
    this.location.back();
  }
  CompletedOrder(orderId:any)
  {
    this.service.updateStatus(orderId).subscribe((data)=>{
      window.alert('Updated Successfully');
      this.getPendingOrders();
    });
  }
  


}
