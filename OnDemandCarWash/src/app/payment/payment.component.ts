import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { CustomerService } from '../customer/customer.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  paymentHandler: any = null;
  WPList: any;
  constructor(private router: Router, private route: ActivatedRoute, private service: CustomerService) { }
  ngOnInit() {
    this.route.paramMap.subscribe((param) => {
      let name = (param.get('name'))
      console.log(name);
      this.getWPByName(name);
    });
    this.invokeStripe();

  }
  getWPByName(name: any) {
    this.service.getWashPackName(name).subscribe((data) => {
      this.WPList = data;
    })

  }

  makePayment(amount: any) {
    const paymentHandler = (<any>window).StripeCheckout.configure({
      key: 'pk_test_51Mc0srSFdGebVWh25jqdThtTJwRSeF7QnqdQBN05XzHg0sM205Sha3ISF2BcAAKuxxhmawmxGm19lKzlSpGTqyOt00si6EBlSc',
      locale: 'auto',
      token: function (stripeToken: any) {
        console.log(stripeToken);

        Swal.fire({
          title: 'Payment Successful and Order Placed ',
          icon: 'success',
        });
      },
    }
    );
    paymentHandler.open({
      name: 'CarWash',
      description: this.WPList.name,
      amount:amount * 100,

    });
    this.router.navigate(['user'])
  }
  invokeStripe() {
    if (!window.document.getElementById('stripe-script')) {
      const script = window.document.createElement('script');
      script.id = 'stripe-script';
      script.type = 'text/javascript';
      script.src = 'https://checkout.stripe.com/checkout.js';
      // script.onload = () => {
      //   this.paymentHandler = (<any>window).StripeCheckout.configure({
      //     key: 'pk_test_51Mc0srSFdGebVWh25jqdThtTJwRSeF7QnqdQBN05XzHg0sM205Sha3ISF2BcAAKuxxhmawmxGm19lKzlSpGTqyOt00si6EBlSc',
      //     locale: 'auto',
      //     token: function (stripeToken: any) {
      //       console.log(stripeToken);
      //       alert('Payment has been successfull!');
      //     },
      //   });
      //};
      window.document.body.appendChild(script);

    }
  }
}
