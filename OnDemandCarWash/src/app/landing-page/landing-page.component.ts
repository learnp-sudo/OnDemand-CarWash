import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { faBoxOpen, faChartLine, faClipboardCheck, faClock, faEnvelope, faMapMarkerAlt, faPhone, faRupeeSign, faShippingFast, faTint, faWallet } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent {
  fastShippingIcon = faShippingFast;
  boxopenIcon = faBoxOpen;
  dropIcon = faTint;
  clipboardIcon = faClipboardCheck;
  rupeeIcon = faRupeeSign;
  clockIcon = faClock;
  walletIcon = faWallet;
  growthIcon = faChartLine;
  mobile = faPhone;
  envelope = faEnvelope;
  marker = faMapMarkerAlt;
  constructor(private router: Router) {}

  ngOnInit(): void {}

  regis(){
    this.router.navigateByUrl('/register');
  };
}
