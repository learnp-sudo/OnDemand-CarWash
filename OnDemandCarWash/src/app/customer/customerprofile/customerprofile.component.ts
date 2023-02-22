import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/service/authentication.service';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customerprofile',
  templateUrl: './customerprofile.component.html',
  styleUrls: ['./customerprofile.component.css']
})
export class CustomerprofileComponent implements OnInit {
  customer:any={
    id:'',
    email:'',
    fullName:'',
    phoneNumber:0,
    username:''
  };
  
  constructor(private authentication:AuthenticationService, private service:CustomerService, private location:Location, private router:Router){}
  username=this.authentication.getUsername()||''
  
  ngOnInit(): void {
    console.log(this.username)
    this.getCustomerByusername(this.username);
  }
  getCustomerByusername(username:any){
    this.service.getCustomerByUsername(this.username).subscribe((data:any)=>{
      this.customer=data;
    })
  }
  
  updateCustomerDetails(){ 
   this.service.updateCustomerDetails(this.customer[0]).subscribe({
    next:(data)=> {
      this.router.navigate(['user'])
            },
            error:(error)=>console.log(error)
          })
  

}
back(){
  this.location.back();
}
}
