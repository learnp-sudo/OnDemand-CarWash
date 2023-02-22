import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/service/authentication.service';
import { WasherService } from 'src/app/service/washer.service';

@Component({
  selector: 'app-washer-profile',
  templateUrl: './washer-profile.component.html',
  styleUrls: ['./washer-profile.component.css']
})
export class WasherProfileComponent implements OnInit {
  washer:any={
    id:'',
    email:'',
    fullName:'',
    status:'',
    phoneNunmber:'',
    username:''
  };
  
  constructor(private authentication:AuthenticationService, private service:WasherService, private location:Location, private router:Router){}
  username=this.authentication.getUsername()||''
  
  ngOnInit(): void {
    console.log(this.username)
    this.getWasherByusername(this.username);
  }
  getWasherByusername(username:any){
    this.service.getWasherByUsername(this.username).subscribe((data:any)=>{
      this.washer=data;
    })
  }
  
  updateWasherDetails(){ 
   this.service.updateWasherByEmail(this.washer[0]).subscribe({
    next:(data)=> {
      this.router.navigate(['washer'])
            },
            error:(error)=>console.log(error)
          })
  

}
back(){
  this.location.back();
}
}

