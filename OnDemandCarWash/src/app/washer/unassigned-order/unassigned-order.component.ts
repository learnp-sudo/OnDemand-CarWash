import { Component, OnInit } from '@angular/core';
import { OrderService } from 'src/app/service/order.service';

@Component({
  selector: 'app-unassigned-order',
  templateUrl: './unassigned-order.component.html',
  styleUrls: ['./unassigned-order.component.css']
})
export class UnassignedOrderComponent implements OnInit { 
  OrderList:any;
   constructor(private service:OrderService){}
   ngOnInit(): void {
     this.unAssignedOrders();
   }
   unAssignedOrders()
     {
  this.service.getUnassigned().subscribe((data)=>{
   this.OrderList=data
  })
}
}
