package com.green.car.wash.company.customer.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.green.car.wash.company.customer.exceptionhandlers.API_requestException;
import com.green.car.wash.company.customer.models.Cart;
import com.green.car.wash.company.customer.models.OrderDetails;
import com.green.car.wash.company.customer.models.WashPacks;
import com.green.car.wash.company.customer.wrapperclass.OrderReceipt;
@Service
public class OrderService {
	    @Autowired
	    private RestTemplate restTemplate;

	    //Url to access the methods of Order Service
	    String url="http://ORDER/orders";
	    //Url to access the methods of admin Service
	    String url1="http://ADMIN/admins";

	    //To see all the WashPacks
	    public List<WashPacks> getAllWP(){
	        WashPacks[] wp=restTemplate.getForObject(url1+"/all/findWP",WashPacks[].class);
	        return (Arrays.asList(wp));
	    }

	    /** Only the methods that use rest template are below this comment**/
	    //To add an order from User-end
	    public Cart addOrder(Cart cart, String email){
	        HttpEntity<Cart> addOrderbyUser = new HttpEntity<>(cart);
	        return restTemplate.postForObject(url+"/add/"+email,addOrderbyUser,Cart.class);
	    }

	    //To cancel the Order from user end
	    public String cancelOrder(OrderDetails orderDetails){
	        HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        HttpEntity<OrderDetails> cancelledOrder = new HttpEntity<>(orderDetails,headers);
	        ResponseEntity<String> response=restTemplate.exchange(url+"/cancelOrder",HttpMethod.PUT,cancelledOrder,String.class);
	        return response.getBody();
	    }
	    //To get the receipt of the order after order is completed
	    public OrderReceipt getReceipt(String id){
	        OrderDetails od=restTemplate.getForObject(url+"/findone/"+id,OrderDetails.class);
	        WashPacks wp=restTemplate.getForObject(url1+"/all/findWP/name/"+od.getWashpack(),WashPacks.class);
	        if(od.getStatus().contains("Completed")){
	            return new OrderReceipt(id,od.getUseremailid(),od.getWasherName(),wp.getName(),wp.getDescription(),wp.getCost());
	        }
	        else{
	            throw new API_requestException("Your order with ID -> "+id+" is still pending");
	        }
	    }

		public WashPacks getWPById(String pack_id) {
			WashPacks packs=restTemplate.getForObject(url1+"/all/findWP/"+pack_id,WashPacks.class);
			return packs;
		}

		public WashPacks getWPByName(String name) {
			WashPacks packs=restTemplate.getForObject(url1+"/all/findWP/name/"+name,WashPacks.class);
			return packs;
		}

}


