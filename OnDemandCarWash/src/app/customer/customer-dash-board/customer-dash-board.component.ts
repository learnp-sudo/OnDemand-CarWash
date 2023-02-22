import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthenticationService } from 'src/app/service/authentication.service';

@Component({
  selector: 'app-customer-dash-board',
  templateUrl: './customer-dash-board.component.html',
  styleUrls: ['./customer-dash-board.component.css']
})
export class CustomerDashBoardComponent implements OnInit {
  username: string = '';
  constructor(private router: ActivatedRoute, private authService: AuthenticationService) { } 
  ngOnInit() { 
    // this.router.paramMap.subscribe((params) =>
    //  {this.username = (params.get('uname')!);
    //   console.log(this.username); }) 
    }

 
      

}
