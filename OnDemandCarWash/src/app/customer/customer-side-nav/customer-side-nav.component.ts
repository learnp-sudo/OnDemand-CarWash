import { Component } from '@angular/core';
import { faAddressCard,  faBoxOpen, faHome, faInfoCircle, faPhoneSquareAlt, faPlus, faShoppingBag, faSuitcase } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-customer-side-nav',
  templateUrl: './customer-side-nav.component.html',
  styleUrls: ['./customer-side-nav.component.css']
})
export class CustomerSideNavComponent {
  home = faHome;
  shoppingbag=faShoppingBag;
  plus=faPlus;
  info =faInfoCircle;
  phone =faPhoneSquareAlt;
  user=faAddressCard;
  washer=faSuitcase;
  wp=faBoxOpen;
}
