import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

declare var window: any;
 
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  constructor(private service:AdminService){}

  deleteModal:any;
  idToDelete: any = "";

  allWashpacks:any;
  ngOnInit(){
    this.deleteModal=new window.bootstrap.Modal(
      document.getElementById("deleteModal")
    )
    this.get();

  }
get(){
  this.service.get().subscribe((data)=>{
    this.allWashpacks=data;
  })
}
openDeleteModal(pack_id: any){
this.idToDelete =pack_id;
this.deleteModal.show();
}
delete(){
  this.service.delete(this.idToDelete).subscribe((data)=>{
    this.allWashpacks=this.allWashpacks.filter((_: { pack_id: any; }) => _.pack_id !== this.idToDelete);
    this.deleteModal.hide();
  })
}
}
