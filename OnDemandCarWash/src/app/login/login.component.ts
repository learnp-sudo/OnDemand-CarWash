import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { faAddressBook } from '@fortawesome/free-solid-svg-icons';
import Swal from 'sweetalert2';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  constructor(private service:AuthenticationService, private route:Router, private router: ActivatedRoute,private location:Location){

  }
  faReg = faAddressBook;
user:any={
username:'',
password:''
}
username: string = '';
errorMessage: string = '';

ngOnInit(): void {
  
}
login(){
  this.service.login(this.user).subscribe((data:any)=>{
    localStorage.setItem('token', data.jwt)
    localStorage.setItem('username',this.user.username) //new line 

    console.log(data);
    this.route.navigate(['user'])
    Swal.fire({ title: 'Welcome to CarWash', 
      text: this.user.username, imageUrl: "../../../../assets/images/car-wash.jpg", 
      imageWidth: 400, 
      imageHeight: 200, 
      imageAlt: 'Custom image', 
      showConfirmButton: false, 
      timer: 6500 
    })
    
    
  },
  (err: { status: number; errorMessage: string; }) => {
    if (err?.status === 403) {
      this.errorMessage = 'Invalid Credentials';
    } else {
      this.errorMessage =
        'Unexpected error occurred. Error is: ' + err?.errorMessage;
      console.log(err);
    }
  }
 
  )
}
back(){
  this.location.back();
}

}
