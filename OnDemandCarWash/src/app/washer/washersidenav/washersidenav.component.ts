import { Component } from '@angular/core';
import { faAddressCard, faBoxOpen, faHome, faInfoCircle, faPhoneSquareAlt, faPlus, faQuestionCircle, faShoppingBag, faSuitcase } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-washersidenav',
  templateUrl: './washersidenav.component.html',
  styleUrls: ['./washersidenav.component.css']
})
export class WashersidenavComponent {
  home = faHome;
  shoppingbag=faShoppingBag;
  plus=faPlus;
  info =faInfoCircle;
  phone =faPhoneSquareAlt;
  user=faAddressCard;
  washer=faSuitcase;
  wp=faBoxOpen;
  un=faQuestionCircle;
}
