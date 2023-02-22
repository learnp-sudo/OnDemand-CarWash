import { Component, OnInit } from '@angular/core';
import { OrderService } from 'src/app/service/order.service';
import { Location } from '@angular/common'
declare var window: any;

@Component({
  selector: 'app-completed-orders',
  templateUrl: './completed-orders.component.html',
  styleUrls: ['./completed-orders.component.css']
})
export class CompletedOrdersComponent implements OnInit {
  OrderList:any;
  deleteModal:any;
  idToDelete: any = "";
  constructor(private service:OrderService, private location:Location){}
  ngOnInit(): void {
    this.getCompletedOrders();
    this.deleteModal=new window.bootstrap.Modal(
      document.getElementById("deleteModal")
    )

  }
  getCompletedOrders()
  {
    this.service.getComletedOrders().subscribe((data)=>{
      this.OrderList=data;
    })
  }
  back(){
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
