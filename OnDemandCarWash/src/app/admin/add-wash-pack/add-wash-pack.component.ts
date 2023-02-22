import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-add-wash-pack',
  templateUrl: './add-wash-pack.component.html',
  styleUrls: ['./add-wash-pack.component.css']
})
export class AddWashPackComponent implements OnInit {
// [x: string]: any;
  addWashPack: any={
    pack_id:'',
    name:'',
    cost:0,
    description:''
  };

  constructor(private service:AdminService, private route:Router){}
  ngOnInit(): void {

   
  }
add(){

this.service.add(this.addWashPack)
.subscribe({
  next:(data)=>{
    this.route.navigate(["/admin/home"])

  },
  error:(error)=>{
    console.log(error);
  }
}
  )
}
}



