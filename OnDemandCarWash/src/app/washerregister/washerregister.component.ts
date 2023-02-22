import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { faAddressBook } from '@fortawesome/free-solid-svg-icons';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-washerregister',
  templateUrl: './washerregister.component.html',
  styleUrls: ['./washerregister.component.css']
})
export class WasherregisterComponent {
  constructor(private authService:AuthenticationService, private router:Router){}
  errorMessage: string = '';
  faReg = faAddressBook;
  washer: any={
    
    email:'',
    password:'',
    confrimpassword:'',
    fullName:'',
    phoneNunmber:'',
    username:''    
  };
  registerWasher() {
    this.authService.registerWasher(this.washer).subscribe(
      (data: any) => {
        console.log(data);
      
        this.router.navigate(['/washerlogin']);
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


