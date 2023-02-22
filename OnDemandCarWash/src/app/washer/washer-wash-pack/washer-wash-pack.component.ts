import { Component, OnInit } from '@angular/core';
import { WasherService } from 'src/app/service/washer.service';

@Component({
  selector: 'app-washer-wash-pack',
  templateUrl: './washer-wash-pack.component.html',
  styleUrls: ['./washer-wash-pack.component.css']
})
export class WasherWashPackComponent implements OnInit {
  WPList: any;
  constructor(private service:WasherService){}

  ngOnInit(): void {
    this.getWashPacks()
    
  }
getWashPacks()
{
this.service.getWashPacks().subscribe((data)=>{
  this.WPList=data;
})
}
}