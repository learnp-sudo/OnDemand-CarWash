import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit{
  customerList:any;
  constructor(private service:CustomerService){}
  ngOnInit(): void {
    this.getAllCustomers();
  }
getAllCustomers(){
  this.service.getAllCustomers().subscribe((data)=>{
    this.customerList=data;
  })
}
}
