package com.green.car.wash.company.customer.controller;

import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.green.car.wash.company.customer.models.Cart;
import com.green.car.wash.company.customer.models.OrderDetails;
import com.green.car.wash.company.customer.models.Ratings;
import com.green.car.wash.company.customer.models.WashPacks;
import com.green.car.wash.company.customer.models.customerDetails;
import com.green.car.wash.company.customer.repository.CustomerRepo;
import com.green.car.wash.company.customer.service.CustomerService;
import com.green.car.wash.company.customer.service.OrderService;
import com.green.car.wash.company.customer.service.RatingsService;
import com.green.car.wash.company.customer.wrapperclass.OrderReceipt;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/customer")
public class CustomerController {
	Logger log = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	private CustomerRepo customerrepo;
	@Autowired
	private RatingsService ratingservice;
	@Autowired
	private CustomerService customerservice;
	@Autowired
	private OrderService orderservice;

	// add ratings
	@PostMapping("/addRating")
	public Ratings addRating(@RequestBody Ratings ratings) {
		log.info("adding Rtings");
		return ratingservice.addRating(ratings);
	}

	// get all ratings
	@GetMapping("/getallRatings")
	public List<Ratings> getallratings() {
		log.info("all the ratings");
		return ratingservice.getallRatings();
	}

	// get the washer specific ratings
	@GetMapping("/washerSpecificRating/{washerName}")
	public List<Ratings> washerSpecificRating(@PathVariable String washerName) {
		log.info("washerDetails");
		return ratingservice.washerSpecific(washerName);
	}

	// update the customer details
	@PutMapping("/update/{Id}")
	public ResponseEntity updateDetails(@PathVariable String Id, @RequestBody customerDetails details) {
		customerservice.updateDetails(details);
		log.info(Id);
		return ResponseEntity.ok().build();
	}

	// delete customer details by id
	@DeleteMapping("/delete/{id}")
	public void deleteproduct(@PathVariable String id) {
		customerrepo.deleteById(id);

	}

	// get all details of customer by username
	@GetMapping("/{username}")
	public List<customerDetails> customerSpecific(@PathVariable String username) {
		return customerservice.CustomerSpecific(username);
	}

	@GetMapping("/allCustomers")
	public List<customerDetails> customers() {
		return customerrepo.findAll();
	}

	// To see all the wash packs
	@GetMapping("/seeWP")
	public List<WashPacks> getAllWP() {
		log.info("wash packs");
		return orderservice.getAllWP();
	}


	@GetMapping("/washpack/{pack_id}")
	public WashPacks getwashPackById(@PathVariable String pack_id) {
		return orderservice.getWPById(pack_id);
	}

	@GetMapping("/washpack/name/{name}")
	public WashPacks getwashPackByName(@PathVariable String name) {
		return orderservice.getWPByName(name);
	}


	/**
	 * Only the methods that call rest-template methods from services are below this
	 * comment
	 **/
	// To add an order from User-end
	@PostMapping("/addOrder/{email}")
	public Cart addOrder(@RequestBody Cart cart, String email) {

		return orderservice.addOrder(cart, email);
	}

	// To cancel the Order from user end
	@PutMapping("/cancelOrder")
	public String cancelOrder(@RequestBody OrderDetails orderDetails) {
		return orderservice.cancelOrder(orderDetails);
	}

	// To get the receipt of the order after order is completed
	@GetMapping("/getReceipt/orderId/{id}")
	public OrderReceipt getReceipt(@PathVariable String id) {
		return orderservice.getReceipt(id);
	}

	@PostMapping("/payment/addMoney/{amount}")
	public String onlinePayment(@PathVariable double amount)throws RazorpayException
	{

		double amt=amount;
		System.out.println(amt);
		RazorpayClient client=new RazorpayClient("rzp_test_JZUBdxVFDFQOZv","6OYHBEHJWvSkp4CccH0Nq1GR");

		JSONObject options=new JSONObject();

		options.put("amount", amt*100);
		options.put("currency", "INR");
		options.put("receipt", "txn_123456");
		Order order=client.Orders.create(options);
		System.out.println(order);
		return order.toString();

	}

}
