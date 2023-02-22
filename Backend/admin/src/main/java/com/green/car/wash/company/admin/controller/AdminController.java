package com.green.car.wash.company.admin.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.green.car.wash.company.admin.model.*;
import com.green.car.wash.company.admin.service.AdminService;
import com.green.car.wash.company.admin.service.WashPackService;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admins")
public class AdminController {

	@Autowired
	WashPackService wps;
	@Autowired
	AdminService as;

	Logger log = LoggerFactory.getLogger(AdminController.class);

	/** Washer controls through admin using service object */
	// To find all the washpack
	@GetMapping("/all/findWP")
	public List<WashPacks> findallWP() {
		log.info("get All Wp");
		return wps.findallWP();
	}

	// To find one WashPack with ID
	@GetMapping("/all/findWP/{id}")
	public ResponseEntity<WashPacks> findoneWP(@PathVariable String id) {
		log.info(id);
		return wps.findoneWP(id);
	}

	// To add a new WashPack
	@PostMapping("/addWP")
	public WashPacks addWP(@RequestBody WashPacks washPacks) {
		log.info("added");
		return wps.addWP(washPacks);
	}

	// To delete a Washpack
	@DeleteMapping("/deleteWP/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteWP(@PathVariable String id) {
		log.warn("deleted");
		return wps.deleteWP(id);
	}

	// To update a Wash pack
	@PutMapping("/updateWP/{id}")
	public ResponseEntity<WashPacks> updateWP(@PathVariable String id, @RequestBody WashPacks washPacks) {
		log.info("updated " + id);
		return wps.updateWP(id, washPacks);
	}

	// To find wash pack with wash pack name
	@GetMapping("/all/findWP/name/{name}")
	public WashPacks wpbyname(@PathVariable String name) {
		log.info(name);
		return wps.findbyname(name);
	}

	/** Order controls through admin using rest template */
	// To see all the wash orders
	@GetMapping("/orders")
	public List<OrderDetails> getAllOrders() {
		log.info("all orders");
		return as.getAllOrders();
	}
	// To assign a washer to the order by Admin

	@PutMapping("/assignWasher")
	public OrderDetails assignWasher(@RequestBody OrderDetails orderDetails) {
		return as.assignWasher(orderDetails);
	}

	@GetMapping("/AllWashers")
	public List<WasherProfile> getAllWashers() {
		return as.getAllWashers();
	}

	/** Washer controls through admin using rest template */
	// To get one washer

	@GetMapping("/oneWasher/{fullName}")
	public List<WasherProfile> getOneWasher(@PathVariable String fullName) {
		return as.getOneWasher(fullName);
	}

	@GetMapping("/AllCustomers")
	public List<customerDetails> getAllCustomers() {
		return as.getAllCustomers();
	}
	@DeleteMapping("/delete/Washer/{email}")
	public void deleteWasher(@PathVariable String email) {
		log.warn("deleted");
		 as.deleteWasher(email);
	}

}
