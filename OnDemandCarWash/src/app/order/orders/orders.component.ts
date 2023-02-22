import { Component, OnInit } from '@angular/core';
import { OrderService } from 'src/app/service/order.service';
declare var window: any;
@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})

 
export class OrdersComponent implements OnInit {
  deleteModal:any;
  idToDelete: any = "";
  OrderList:any;
  constructor(private service:OrderService){}
  

  ngOnInit(){
    this.getAllOrders();
   
    
  }
  getAllOrders()
  {
    this.service.getAllOrders().subscribe((data)=>{
      this.OrderList=data;
    })
  }
    
}


