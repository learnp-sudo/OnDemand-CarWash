import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { faAddressBook } from '@fortawesome/free-solid-svg-icons';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-adminregister',
  templateUrl: './adminregister.component.html',
  styleUrls: ['./adminregister.component.css']
})
export class AdminregisterComponent {
  faReg = faAddressBook;
confrimpassword: any;


  constructor(private authservice:AuthenticationService, private router:Router){}
  errorMessage: string = '';
  admin: any={
    id:'',
    email:'',
    password:'',
    username:''  ,
    confrimpassword:''  
  };
  registerAdmin() {
    this.authservice.registerAdmin(this.admin).subscribe(
      (data: any) => {
        console.log(data);
       
        this.router.navigate(['/adminlogin']);
      },
      (err: { status: number; errorMessage: string; }) => {
        if (err?.status === 400) {
          this.errorMessage = 'User Exists Already';
        } else {
          this.errorMessage =
            'Unexpected error occurred. Error is: ' + err?.errorMessage;
          console.log(err);
        }
      }
    );
  }


}
