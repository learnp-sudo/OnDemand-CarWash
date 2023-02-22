import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AdminModule } from './admin/admin.module';
import { AppRoutingModule, routingComponent } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule, HTTP_INTERCEPTORS}  from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AboutUsComponent } from './about-us/about-us.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { MaterialModule } from './material/material.module';
import { OrdersComponent } from './order/orders/orders.component';
import { WasherComponent } from './washer/washer.component';
import { PendingOrdersComponent } from './order/pending-orders/pending-orders.component';
import { CompletedOrdersComponent } from './order/completed-orders/completed-orders.component';
import { UpdateAssignOrdersComponent } from './order/update-assign-orders/update-assign-orders.component';
import { UnassignOrdersComponent } from './order/unassign-orders/unassign-orders.component';
import { CancelledOrdersComponent } from './order/cancelled-orders/cancelled-orders.component';
import { CustomerWashPackViewComponent } from './customer/customer-wash-pack-view/customer-wash-pack-view.component';
import { CustomerDashBoardComponent } from './customer/customer-dash-board/customer-dash-board.component';
import { CustomerSideNavComponent } from './customer/customer-side-nav/customer-side-nav.component';
import { CustomerprofileComponent } from './customer/customerprofile/customerprofile.component';
import { CustomerMyOrdersComponent } from './customer/customer-my-orders/customer-my-orders.component';
import { CustomerAddOrderComponent } from './customer/customer-add-order/customer-add-order.component';
import { WasherDashBoardComponent } from './washer/washer-dash-board/washer-dash-board.component';
import { WashersidenavComponent } from './washer/washersidenav/washersidenav.component';
import { WasherProfileComponent } from './washer/washer-profile/washer-profile.component';
import { UnassignedOrderComponent } from './washer/unassigned-order/unassigned-order.component';
import { WashermyordersComponent } from './washer/washermyorders/washermyorders.component';
import { WasherWashPackComponent } from './washer/washer-wash-pack/washer-wash-pack.component';
import { AssignWasherComponent } from './washer/assign-washer/assign-washer.component';
import { CartComponent } from './cart/cart.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AuthenticationService } from './service/authentication.service';
import { AuthGuard } from './auth.guard';
import { TokenInterceptorService } from './token-interceptor.service';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { AdminregisterComponent } from './adminregister/adminregister.component';
import { WasherregisterComponent } from './washerregister/washerregister.component';
import { WasherloginComponent } from './washerlogin/washerlogin.component';
import { CustomersComponent } from './customer/customers/customers.component';
import { WashPackDetailComponent } from './customer/wash-pack-detail/wash-pack-detail.component'; 
import { ConfrimEqualValidatorsDirective } from './shared/confrim-equal-validators.directive';
import { PaymentComponent } from './payment/payment.component';




@NgModule({
  declarations: [
    AppComponent,
    routingComponent,
    LandingPageComponent,
    AboutUsComponent,
    LoginComponent,
    RegisterComponent,
    OrdersComponent,
    WasherComponent,
    PendingOrdersComponent,
    CompletedOrdersComponent,
    UpdateAssignOrdersComponent,
    UnassignOrdersComponent,
    CancelledOrdersComponent,
    CustomerWashPackViewComponent,
    CustomerDashBoardComponent,
    CustomerSideNavComponent,
    CustomerprofileComponent,
    CustomerMyOrdersComponent,
    CustomerAddOrderComponent,
    WasherDashBoardComponent,
    WashersidenavComponent,
    WasherProfileComponent,
    UnassignedOrderComponent,
    WashermyordersComponent,
    WasherWashPackComponent,
    AssignWasherComponent,
    CartComponent,
    PageNotFoundComponent,
    AdminloginComponent,
    AdminregisterComponent,
    WasherregisterComponent,
    WasherloginComponent,
    CustomersComponent,
    WashPackDetailComponent,
    ConfrimEqualValidatorsDirective,
    PaymentComponent
    
  ],
    
   
   
   
  
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    AdminModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,
    FontAwesomeModule,
    MaterialModule,
    ReactiveFormsModule
    
    
    
  ],
  providers: [ AuthenticationService, AuthGuard, {
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptorService,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
