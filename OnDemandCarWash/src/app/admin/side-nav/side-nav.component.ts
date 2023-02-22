import { Component } from '@angular/core';
import { faAddressCard, faBoxOpen, faHome, faInfoCircle, faPhoneSquareAlt, faPlus, faShoppingBag, faSuitcase } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-side-nav',
  templateUrl: './side-nav.component.html',
  styleUrls: ['./side-nav.component.css']
})
export class SideNavComponent {
  home = faHome;
  shoppingbag=faShoppingBag;
  plus=faPlus;
  info =faInfoCircle;
  phone =faPhoneSquareAlt;
  user=faAddressCard;
  washer=faSuitcase;
  wp=faBoxOpen;
  
  
}
