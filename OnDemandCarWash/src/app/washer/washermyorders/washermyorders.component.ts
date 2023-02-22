import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Order } from 'src/app/model/order';
import { AuthenticationService } from 'src/app/service/authentication.service';
import { OrderService } from 'src/app/service/order.service';

@Component({
  selector: 'app-washermyorders',
  templateUrl: './washermyorders.component.html',
  styleUrls: ['./washermyorders.component.css']
})
export class WashermyordersComponent implements OnInit {
  OrderList:Array<Order> = [];
  
  
  user:any={
    username:'',
    password:''
  }

  
  constructor(private service:OrderService, private authentication:AuthenticationService, private router:ActivatedRoute){
    
  }
   username=this.authentication.getUsername()||''
  ngOnInit(): void {
   console.log(this.username)
    this.getWasherOrders(this.username);
  }
  getWasherOrders(username:string){

    this.service.getWasherOrders(this.username).subscribe((data:any)=>{
      this.OrderList=data;

    })
  }
  CompletedOrder(orderId:any)
  {
    this.service.updateStatus(orderId).subscribe((data)=>{
      window.alert('Updated Successfully');
     
    });
  }
  
}
