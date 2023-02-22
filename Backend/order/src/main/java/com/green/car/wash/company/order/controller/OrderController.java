package com.green.car.wash.company.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.green.car.wash.company.order.exceptionHandlers.API_requestException;

import com.green.car.wash.company.order.model.Cart;

import com.green.car.wash.company.order.model.OrderDetails;

import com.green.car.wash.company.order.repository.OrderRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderRepo or;
	@Autowired
	private RestTemplate restTemplate;

	// To get all orders
	@GetMapping("/findall")
	public List<OrderDetails> findallOrders() {
		return or.findAll();
	}

	@PostMapping("/placeOrder")
	 public OrderDetails addOrder(@RequestBody OrderDetails order) {
        //Every Order at conception will be [Pending] and [Unassigned]
        order.setStatus("Pending");
        order.setWasherName("NA");
        return or.save(order);
    }


	// Find one object by ID
	@GetMapping("/findone/{orderid}")
	public ResponseEntity<OrderDetails> findoneOrder(@PathVariable String orderid) {
		OrderDetails order = or.findById(orderid)
				.orElseThrow(() -> new API_requestException("Order with ID -> " + orderid + " not found"));
		return ResponseEntity.ok(order);
	}

	// To add an order
	@PostMapping("/add/{email}")
	public void addOrder(@RequestBody Cart cart, String email) {
		OrderDetails order = new OrderDetails();
		order.setUseremailid(cart.getUseremailid());
		order.setWasherName("NA");
		order.setWashpacks(cart.getWashpacks());
		order.setPhoneNo(cart.getPhoneNo());
		order.setAreapincode(cart.getAreapincode());
		order.setStatus("Pending");
		order.setCars(cart.getCar());
		or.save(order);
		restTemplate.delete("http://CART/cart/delete/" + cart.getCartId());
	}

	// To delete specific order with id
	@DeleteMapping("/delete/{orderId}")
	public ResponseEntity<Map<String, Boolean>> deleteOrder(@PathVariable String orderId) {
		OrderDetails order = or.findById(orderId).orElseThrow(
				() -> new API_requestException("Order with ID -> " + orderId + " not found,deletion failed"));
		or.delete(order);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Order Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}



	/** Getting consumed by the Washer and Admin model */
	// To filter orders using user emailId
	@GetMapping("/findMyOrders/{useremailid}")
	public List<OrderDetails> getMyOrders(@PathVariable String useremailid) {
		return or.findAll().stream().filter(x -> x.getUseremailid().contains(useremailid)).collect(Collectors.toList());
	}

	// To find all the completed orders
	@GetMapping("/findCompleted")
	public List<OrderDetails> getCompletedOrders() {
		return or.findAll().stream().filter(x -> x.getStatus().contains("Completed")).collect(Collectors.toList());
	}

	// To find all the pending orders
	@GetMapping("/findPending")
	public List<OrderDetails> getPendingOrders() {
		return or.findAll().stream().filter(x -> x.getStatus().contains("Pending")).collect(Collectors.toList());
	}

	// To find all the cancelled orders
	@GetMapping("/findCancelled")
	public List<OrderDetails> getCancelledOrders() {
		return or.findAll().stream().filter(x -> x.getStatus().contains("Cancelled")).collect(Collectors.toList());
	}

	// To find all the unassigned orders
	@GetMapping("/findUnassigned")
	public List<OrderDetails> getUnassignedOrders() {
		return or.findAll().stream().filter(x -> x.getWasherName().contains("NA")).collect(Collectors.toList());
	}

	// To fin all the orders by a specific washer
	@GetMapping("/washerSpecificOrder/{washername}")
	public List<OrderDetails> getWasherSpecificOrders(@PathVariable String washername) {
		return or.findAll().stream().filter(x -> x.getWasherName().contains(washername)).collect(Collectors.toList());
	}
	@GetMapping("/findOneOrder/{username}")
	public List<OrderDetails> getOneOrder(@PathVariable String username) {

		return or.findAll().stream().filter(x -> x.getUsername().contains(username)).collect(Collectors.toList());
	}

	 //To cancel the order
	@PutMapping("/cancelOrder")
	public String cancelOrder(@RequestBody OrderDetails orderDetails) {
		OrderDetails od = or.findById(orderDetails.getOrderId()).get();
		od.setStatus("Cancelled");
		or.save(od);
		return "The order with ID -> " + orderDetails.getOrderId() + " is cancelled successfully";
	}
	@CrossOrigin("http://localhost:4200")
	@PutMapping("/cancelOrder/{orderId}")
	public ResponseEntity<OrderDetails> CancelOrder(@PathVariable String orderId ) {
		OrderDetails existingOrder = or.findById(orderId).orElseThrow(
				() -> new API_requestException("Order with ID -> " + orderId + " not found, status update failed"));
		existingOrder.setStatus("Cancelled");
		OrderDetails order = or.save(existingOrder);
		return ResponseEntity.ok(order);
	}

	/**
	 * Methods that are consumed exclusively by rest templates below this comment
	 */
	// This is called by Admin to update the status of the order(For Completed
	// Order)

	@PutMapping("/updateStatus/completed/{orderId}")
	public ResponseEntity<OrderDetails> updateStatus(@PathVariable String orderId ) {
		OrderDetails existingOrder = or.findById(orderId).orElseThrow(
				() -> new API_requestException("Order with ID -> " + orderId + " not found, status update failed"));
		existingOrder.setStatus("Completed");
		OrderDetails order = or.save(existingOrder);
		return ResponseEntity.ok(order);
	}

	@PutMapping("/assignWasher/{orderId}")
	public OrderDetails assignWasher(@RequestBody OrderDetails od, @PathVariable String orderId) {
		boolean doesOrderExists = or.existsById(od.getOrderId());
		OrderDetails existingOrder = or.findById(od.getOrderId()).orElse(null);
		if (doesOrderExists && existingOrder.getWasherName().contains("NA")) {
			existingOrder.setWasherName(od.getWasherName());
			return or.save(existingOrder);
		} else {
			throw new API_requestException("Order not found in database, washer not assigned");
		}
	}


}
