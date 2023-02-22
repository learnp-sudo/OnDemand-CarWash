import { Component, OnInit } from '@angular/core';
import { Washpack} from 'src/app/model/washpack';
import { CustomerService } from '../customer.service';
@Component({
  selector: 'app-customer-wash-pack-view',
  templateUrl: './customer-wash-pack-view.component.html',
  styleUrls: ['./customer-wash-pack-view.component.css']
})
export class CustomerWashPackViewComponent implements OnInit {
  WPList: any;
  constructor(private service:CustomerService){}

  ngOnInit(): void {
    this.WpView()
    
  }
WpView()
{
this.service.WpView().subscribe((data)=>{
  this.WPList=data;
})
}

}

