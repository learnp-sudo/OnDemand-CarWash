import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderService } from 'src/app/service/order.service';
import { Location } from '@angular/common';
declare var window: any;
@Component({
  selector: 'app-cancelled-orders',
  templateUrl: './cancelled-orders.component.html',
  styleUrls: ['./cancelled-orders.component.css']
})
export class CancelledOrdersComponent implements OnInit{
OrderList: any;
deleteModal:any;
  idToDelete: any = "";
constructor(private service:OrderService, private route:Router, private location:Location){}
  ngOnInit(): void {
   this.getCancelledOrders();
   this.deleteModal=new window.bootstrap.Modal(
    document.getElementById("deleteModal")
   )
  }
  getCancelledOrders()
  {
  this.service.getCancelledOrders().subscribe((data)=>{
    this.OrderList=data;
  })
  }
  back()
  {
    // this.route.navigate(['/orders']); 
    this.location.back(); 
  
  }
  openDeleteModal(orderId: string){
    this.idToDelete =orderId;
    this.deleteModal.show();
    }
  
  deleteOrder(){
    this.service.deleteOrder(this.idToDelete).subscribe((data)=>{
      this.OrderList=this.OrderList.filter((_: { orderId:any }) => _.orderId !== this.idToDelete);
      this.deleteModal.hide();
    })
  }


}
