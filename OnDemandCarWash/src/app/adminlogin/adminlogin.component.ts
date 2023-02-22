import { Location } from '@angular/common';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { faAddressBook } from '@fortawesome/free-solid-svg-icons';
import Swal from 'sweetalert2';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent {

  constructor(private service: AuthenticationService, private route: Router, private location: Location) { }

  faReg = faAddressBook;
  admin: any = {
    username: '',
    password: ''
  }
  errorMessage: string = '';

  loginAdmin() {
    this.service.loginAdmin(this.admin).subscribe((data: any) => {
      localStorage.setItem('token', data.jwt)
      localStorage.setItem('username', this.admin.username) //new line 

      console.log(data);
      this.route.navigate(['admin'])
      Swal.fire({ title: 'Welcome to CarWash', 
      text: this.admin.username, imageUrl: "../../../../assets/images/welcome.jpg", 
      imageWidth: 400, 
      imageHeight: 200, 
      imageAlt: 'Custom image', 
      showConfirmButton: false, 
      timer: 6500 
    })
    },
      (err: { status: number; errorMessage: string; }) => {
        if (err?.status === 403) {
          this.errorMessage = 'In Valid Credentials';
        } else {
          this.errorMessage =
            'Unexpected error occurred. Error is: ' + err?.errorMessage;
          console.log(err);
        }
      }


    )
  }
  back() {
    this.location.back();
  }
}
