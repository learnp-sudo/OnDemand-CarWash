import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap,Router } from '@angular/router';
import { OrderService } from 'src/app/service/order.service';

@Component({
  selector: 'app-assign-washer',
  templateUrl: './assign-washer.component.html',
  styleUrls: ['./assign-washer.component.css']
})
export class AssignWasherComponent implements OnInit{
  AssignWashers: any={
    orderId:'',
    washerName:''   
  };
  constructor(private service:OrderService,private route:ActivatedRoute, private router:Router, private loaction : Location){}

  ngOnInit(): void {
    this.route.paramMap.subscribe((param)=> {let orderId = (param.get('orderId'))
    console.log(orderId);
    this.getOrderById(orderId);
    
  })
  }
  getOrderById(orderId:any){
    this.service.getOrderById(orderId).subscribe((data)=>{
      this.AssignWashers=data
    })
  }
  Assign(){
    this.service.AssignWasher(this.AssignWashers).subscribe({next:(data)=>{
      window.alert("Assigned successfully");
      // this.router.navigate(["/washer/unassigned"])
      this.loaction.back();
    },
    error:(error)=>console.log(error)
  }
    )
  }
  

  
}



 
