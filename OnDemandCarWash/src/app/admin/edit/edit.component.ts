import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  
  addWashPack: any={
    pack_id:'',
    name:'',
    cost:0,
    description:''
  };
  

  constructor(private service:AdminService, private route:ActivatedRoute, private router:Router){}
  ngOnInit(): void {
    this.route.paramMap.subscribe((param)=> {let pack_id = (param.get('pack_id'))
    console.log(pack_id);
    this.getById(pack_id);
  });
   
  }
  getById(pack_id:any){
    this.service.getById(pack_id).subscribe((data)=>{
      this.addWashPack=data
    })
  }
  update(){
    console.log(this.addWashPack.name)
    this.service.update(this.addWashPack).subscribe({
      next:(data)=> {
this.router.navigate(["/admin/home"])
      },
      error:(error)=>console.log(error)
    })
  }

}
