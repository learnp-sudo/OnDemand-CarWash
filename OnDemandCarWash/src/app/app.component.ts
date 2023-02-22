import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from './service/authentication.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  
  title = 'OnDemandCarWash';
  constructor(private router:Router, public _authService:AuthenticationService){}
  username=this._authService.getUsername()
  aboutus = () => {
    this.router.navigateByUrl('/aboutus');
  };
}
