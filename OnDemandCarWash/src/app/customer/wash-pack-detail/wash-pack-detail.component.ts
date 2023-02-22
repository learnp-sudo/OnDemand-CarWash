import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-wash-pack-detail',
  templateUrl: './wash-pack-detail.component.html',
  styleUrls: ['./wash-pack-detail.component.css']
})
export class WashPackDetailComponent implements OnInit{
  constructor(private service:CustomerService, private route:ActivatedRoute, private location:Location){}
  WPList: any;
  ngOnInit(): void {
    this.route.paramMap.subscribe((param)=> {let pack_id = (param.get('pack_id'))
    console.log(pack_id);
    this.getWPById(pack_id);
  });
  }
  getWPById(pack_id:any){
    this.service.getWashPackById(pack_id).subscribe((data)=>{
      this.WPList=data;
    })
  }
  back(){
    this.location.back()
  }

}
