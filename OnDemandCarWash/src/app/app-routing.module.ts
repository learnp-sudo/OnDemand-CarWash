import { NgModule } from '@angular/core';
import { Router, RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { AdminregisterComponent } from './adminregister/adminregister.component';
import { AuthGuard } from './auth.guard';
import { CartComponent } from './cart/cart.component';
import { CustomerAddOrderComponent } from './customer/customer-add-order/customer-add-order.component';
import { CustomerDashBoardComponent } from './customer/customer-dash-board/customer-dash-board.component';
import { CustomerMyOrdersComponent } from './customer/customer-my-orders/customer-my-orders.component';
import { CustomerWashPackViewComponent } from './customer/customer-wash-pack-view/customer-wash-pack-view.component';
import { CustomerprofileComponent } from './customer/customerprofile/customerprofile.component';
import { WashPackDetailComponent } from './customer/wash-pack-detail/wash-pack-detail.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { LoginComponent } from './login/login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { PaymentComponent } from './payment/payment.component';
import { RegisterComponent } from './register/register.component';
import { AssignWasherComponent } from './washer/assign-washer/assign-washer.component';
import { UnassignedOrderComponent } from './washer/unassigned-order/unassigned-order.component';
import { WasherDashBoardComponent } from './washer/washer-dash-board/washer-dash-board.component';
import { WasherProfileComponent } from './washer/washer-profile/washer-profile.component';
import { WasherWashPackComponent } from './washer/washer-wash-pack/washer-wash-pack.component';
import { WashermyordersComponent } from './washer/washermyorders/washermyorders.component';
import { WasherloginComponent } from './washerlogin/washerlogin.component';
import { WasherregisterComponent } from './washerregister/washerregister.component';

const routes: Routes = [
  
  { path:'landing-page', component:LandingPageComponent},
  {path:'', redirectTo: 'landing-page' ,pathMatch:'full' },
  {path:'aboutus', component:AboutUsComponent},
  {path:'register', component:RegisterComponent},
  {path:'login', component:LoginComponent},
  { path:'adminlogin' , component:AdminloginComponent},
  { path:'washerlogin',component: WasherloginComponent},
  { path:'adminregister',component:AdminregisterComponent},
  {path: 'washerregister',component:WasherregisterComponent},
 
  
  
  
  {
    path: 'user',
    component: CustomerDashBoardComponent,
    canActivate:[AuthGuard],
   
    children: [  

    {path:'home', component: CustomerWashPackViewComponent,
    canActivate:[AuthGuard],
    
  },
    {path:'viewPack/:pack_id',component:WashPackDetailComponent},
    {path:'profile', component:CustomerprofileComponent},
    {path:'myorders',component:CustomerMyOrdersComponent},
    {path:'addorder',component:CustomerAddOrderComponent,
    canActivate:[AuthGuard]
  },
  
    { path:'cart',component:CartComponent},
    { path:'payment/:name',component:PaymentComponent},
      
   ]
} ,
{
  path: 'washer',
  component: WasherDashBoardComponent,
 
  children: [
{ path:'washpacks', component:WasherWashPackComponent},
 { path:'profile', component:WasherProfileComponent,
 canActivate:[AuthGuard]
},
 {path:'unassigned',component:UnassignedOrderComponent},
 {path:'myorders',component:WashermyordersComponent},
 {path:'assignwasher/:orderId',component:AssignWasherComponent}
  ] 
},
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
  
 }
export const routingComponent = [
  CustomerDashBoardComponent,
  WasherDashBoardComponent,
  CustomerWashPackViewComponent

]
