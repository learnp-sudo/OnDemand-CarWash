import { Component, OnInit } from '@angular/core';
import { WasherService } from '../service/washer.service';
declare var window: any;
@Component({
  selector: 'app-washer',
  templateUrl: './washer.component.html',
  styleUrls: ['./washer.component.css']
})
export class WasherComponent implements OnInit {
  deleteModal:any;
  idToDelete: any = "";
  WashersList:any;
 constructor(private service:WasherService){}
  ngOnInit(): void {
    this.getAllWashers();
    this.deleteModal=new window.bootstrap.Modal(
      document.getElementById("deleteModal")
    )
   
  }
  getAllWashers()
  {
  this.service.getAllWashers().subscribe((data)=>{
    this.WashersList=data;
  })
  }
  openDeleteModal(email: any){
    this.idToDelete =email;
    this.deleteModal.show();
    }
  
  deleteWasher(){
    this.service.deleteWasher(this.idToDelete).subscribe((data)=>{
      console.log(this.WashersList);
      this.WashersList=this.WashersList.filter((_: { email:any }) => _.email !== this.idToDelete);
      this.deleteModal.hide();
    })
  }

}
