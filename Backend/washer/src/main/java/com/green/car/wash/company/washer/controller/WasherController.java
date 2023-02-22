package com.green.car.wash.company.washer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.green.car.wash.company.washer.model.OrderDetails;
import com.green.car.wash.company.washer.model.WashPacks;
import com.green.car.wash.company.washer.model.WasherProfile;
import com.green.car.wash.company.washer.service.WasherProfileService;
import com.green.car.wash.company.washer.service.WasherService;

import java.util.List;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/washers")
public class WasherController {
    @Autowired
    WasherService wr;
    @Autowired
    WasherProfileService wps;

    /** Only the methods that consume rest template are below this comment **/
    //To see the Unassigned orders
    @GetMapping("/findUnassigned")
    public List<OrderDetails> getUnassignedOrders(){
        return wr.getUnassignedOrders();
    }
    //The status of the order can be either pending or completed
    @PutMapping("/updateStatus/completed")
    public OrderDetails updateStatusoftheOrder(@RequestBody OrderDetails orderDetails){
        return wr.updateStatus(orderDetails);
    }
    //To assign a washer to the order by washer
    @PutMapping("/assign")
    public OrderDetails assignSelf(@RequestBody OrderDetails orderDetails){
        return wr.assignSelf(orderDetails);
    }
    //To see all the wash packs
    @GetMapping("/seeWP")
    public List<WashPacks> getAllWP(){
        return wr.getAllWP();
    }
    @PutMapping("/updateDetails/{email}")
    public ResponseEntity updateDetails(@PathVariable String email ,@RequestBody WasherProfile details)
    {
    	wps.updateDetails(details);
    	return ResponseEntity.ok().build();
    }
    @GetMapping("/admin/getWashers")
    public List<WasherProfile> getAllWashers(){
        return wps.getAllWashers();
    }
    @GetMapping("/admin/Washer/{username}")
    public List<WasherProfile> getAllWashers(@PathVariable String username){
        return wps.getWasher(username);
    }
    @DeleteMapping("/admin/delete/{email}")
    public void deleteproduct(@PathVariable String email)
    {

        wps.deleteById(email);

    }
}

