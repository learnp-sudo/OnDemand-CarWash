import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from '../auth.guard';
import { CustomersComponent } from '../customer/customers/customers.component';
import { CancelledOrdersComponent } from '../order/cancelled-orders/cancelled-orders.component';
import { CompletedOrdersComponent } from '../order/completed-orders/completed-orders.component';
import { OrdersComponent } from '../order/orders/orders.component';
import { PendingOrdersComponent } from '../order/pending-orders/pending-orders.component';
import { UnassignOrdersComponent } from '../order/unassign-orders/unassign-orders.component';
import { PageNotFoundComponent } from '../page-not-found/page-not-found.component';
import { AssignWasherComponent } from '../washer/assign-washer/assign-washer.component';
import { WasherComponent } from '../washer/washer.component';
import { AddWashPackComponent } from './add-wash-pack/add-wash-pack.component';
import { AdminDashBoardComponent } from './admin-dash-board/admin-dash-board.component';
import { EditComponent } from './edit/edit.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path:'admin', component:AdminDashBoardComponent,
  canActivate:[AuthGuard],
children:[
{path:'home', component:HomeComponent},
{ path:'addWP', component: AddWashPackComponent},
{ path:'updateWp/:pack_id', component:EditComponent},
{ path:'orders', component:OrdersComponent},
{ path:'cancelled',component:CancelledOrdersComponent},
{ path:'pending',component:PendingOrdersComponent},
{ path:'unassigned',component:UnassignOrdersComponent},
{ path:'completed',component:CompletedOrdersComponent},
{path:'washers', component:WasherComponent},
{path:'customers',component:CustomersComponent},
{path:'assignwasher/:orderId',component:AssignWasherComponent}

]
  },
  { path:'**',component:PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
export const routingComponents = [
  AdminDashBoardComponent
]
