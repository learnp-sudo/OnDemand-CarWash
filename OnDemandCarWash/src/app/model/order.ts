import { Car } from "./car";

export class Order {
    orderId!: string ;
    useremailid: string="";
    washerName: string="";
    washpacks: string="";
    phoneNo: number =0;
    areapincode: string="";
    status: string="";
    username:string="";
    cars: Car = new Car();
    
    //Empty Constructor
    Order() {
  
    }
  }

