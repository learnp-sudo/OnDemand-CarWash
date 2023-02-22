package com.green.car.wash.company.admin.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.green.car.wash.company.admin.model.OrderDetails;
import com.green.car.wash.company.admin.model.WasherProfile;
import com.green.car.wash.company.admin.model.customerDetails;

@Service
public class AdminService {
	Logger log = LoggerFactory.getLogger(AdminService.class);
	@Autowired
	private RestTemplate restTemplate;

	// Url to access the methods of Order Service
	String url = "http://order/orders";
	// Url to access the methods of washer Service
	String url1 = "http://washer/washers/admin/";

	// To see all the Orders
	public List<OrderDetails> getAllOrders() {
		OrderDetails[] orders = restTemplate.getForObject(url + "/findall", OrderDetails[].class);
		log.info("getting all the orders");
		return (Arrays.asList(orders));
	}

	/** Order controls through admin using rest template */
	// To assign a washer to the order by Admin
	public OrderDetails assignWasher(OrderDetails orderDetails) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<OrderDetails> assignedWasher = new HttpEntity<>(orderDetails, headers);
		return restTemplate.exchange(url + "/assignWasher", HttpMethod.PUT, assignedWasher, OrderDetails.class)
				.getBody();
	}

	// To see all washers
	public List<WasherProfile> getAllWashers() {
		WasherProfile[] washers = restTemplate.getForObject(url1 + "/getWashers", WasherProfile[].class);
		return (Arrays.asList(washers));
	}

	public List<WasherProfile> getOneWasher(String fullName) {
		WasherProfile[] wp = restTemplate.getForObject(url1 + "/Washer/" + fullName, WasherProfile[].class);
		return (Arrays.asList(wp));
	}

	public List<customerDetails> getAllCustomers() {
		customerDetails[] customers =restTemplate.getForObject("http://customer/customer/allCustomers", customerDetails[].class);
		return (Arrays.asList(customers));
	}

	public void deleteWasher(String email) {
		restTemplate.delete(url1+"/delete/" +email);

	}

}