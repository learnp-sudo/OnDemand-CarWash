package com.green.car.wash.company.cart.controller;

import java.util.ArrayList;


import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.green.car.wash.company.cart.model.Cart;

import com.green.car.wash.company.cart.model.Items;

import com.green.car.wash.company.cart.model.WashPacks;

import com.green.car.wash.company.cart.repository.CartRepository;
import com.green.car.wash.company.cart.service.CartService;
import com.green.car.wash.company.cart.service.CartServiceImpl;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	CartService cartService;
	@Autowired
	CartRepository cartRepository;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	CartServiceImpl cartServiceImpl;
	Logger logger = LoggerFactory.getLogger(CartController.class);


    //seeing all washPacks which was added by admin
	@GetMapping("/seeWP")
	public List<WashPacks> getAllWP() {
		WashPacks[] wp = restTemplate.getForObject("http://admin/admins/all/findWP", WashPacks[].class);
		return (Arrays.asList(wp));
	}
    //Getting all the carts
	@GetMapping("/getallcarts")
	public ResponseEntity<List<Cart>> getAllCarts() {
		return ResponseEntity.ok(cartServiceImpl.getallcarts());
	}
     //adding washpacks to cart
	@PostMapping("/addingproducttocart/{cartId}/{pack_id}")
	public ResponseEntity<Cart> addProductToCart(@PathVariable int cartId, @PathVariable String pack_id) {
		WashPacks product = restTemplate.getForObject("http://admin/admins/all/findWP/" +pack_id, WashPacks.class);
		logger.info("" + product);
		if (cartRepository.existsById(cartId)) {
			Cart oldCart = cartRepository.findById(cartId);
			List<String> idList = new ArrayList<>();
			List<Items> oldItem3 = oldCart.getItems();

			for (Items i : oldItem3) {
				idList.add(i.getPack_id());
			}

			if (idList.contains(product.getPack_id())) {
				logger.info("in if method");
				List<Items> oldItem2 = oldCart.getItems();
				for (Items i : oldItem2) {
					if (i.getPack_id() == pack_id) {
						i.setQuantity(i.getQuantity()+1);
					}
				}
				int price = 0;
				for (Items i : oldItem2) {
					price = price + i.getPrice() * i.getQuantity();
				}
				oldCart.setTotalPrice(price);
				return new ResponseEntity<>(cartServiceImpl.addCart(oldCart), HttpStatus.CREATED);
			} else {
				Items items = new Items();
				items.setPack_id(pack_id);
				items.setPrice(product.getCost());
				items.setName(product.getName());
				items.setQuantity(1);
				List<Items> oldItems = oldCart.getItems();
				oldItems.add(items);
				oldCart.setItems(oldItems);
				int price = 0;
				for (Items i : oldItems) {
					price = price + i.getPrice() * i.getQuantity();
				}
				oldCart.setTotalPrice(price);
				return new ResponseEntity<>(cartServiceImpl.addCart(oldCart), HttpStatus.CREATED);
			}
		} else {
			Cart cart = new Cart();
			cart.setCartId(cartId);
			Items items = new Items();
			// customerDetails1 cd2=new customerDetails1();
			// cd2.setFullname(cd.getFullname());
			items.setPack_id(pack_id);
			items.setPrice(product.getCost());
			items.setName(product.getName());
			items.setQuantity(1);
			List<Items> list = new ArrayList<>();
			list.add(items);
			cart.setItems(list);
			int price = 0;
			for (Items i : list) {
				price = price + i.getPrice() * i.getQuantity();
			}
			cart.setTotalPrice(price);
			return new ResponseEntity<>(cartRepository.save(cart), HttpStatus.CREATED);

		}
	}
    //Getting Cart bY id
	@GetMapping("/{cartId}")
	public ResponseEntity<Cart> getCartById(@PathVariable int cartId) {
		return new ResponseEntity<>(cartServiceImpl.getCartById(cartId), HttpStatus.CREATED);
	}

    //Deleting Item from cart
    @PutMapping("/delete/item/{pack_id}/{cartId}")
	public Cart deleteCartItem(@PathVariable int cartId, @PathVariable String pack_id) {
		//WashPacks product = restTemplate.getForObject("http://admin/admins/all/findWP/" + pack_id, WashPacks.class);
		Cart cart2 = cartServiceImpl.getCartById(cartId);
		List<Items> list = new ArrayList<>();
		list = cart2.getItems();
		System.out.println(list);
		list.removeIf(i -> (i.getPack_id().equals(pack_id)));
		cart2.setItems(list);
		int price = 0;
		for (Items i : list) {
			price = price + i.getPrice() * i.getQuantity();

		}
		cart2.setTotalPrice(price);
		return cartServiceImpl.updateCart(cart2.getCartId(), cart2);
	}
    //increasing Quantity in cart
	@PutMapping("/increaseQuant/{pack_id}/{cartId}")
	public Cart increaseItem(@PathVariable String pack_id, @PathVariable int cartId) {
		Cart cart = cartServiceImpl.getCartById(cartId);

		List<Items> oldItem3 = cart.getItems();

		for (Items i : oldItem3) {

			if ((i.getPack_id()).equals(pack_id))
			{
				System.out.println("3");
				int q=(i.getQuantity())+1;
				i.setQuantity(q);
				System.out.println(q);

			}
		}
		int price = 0;
		for (Items i : oldItem3) {
			price = price + i.getPrice() * i.getQuantity();

		}
		cart.setTotalPrice(price);
		return cartServiceImpl.updateCart(cartId, cart);
	}
    //decreasing Quantity By Item_id and Cart_Id
	@PutMapping("/decreaseQuant/{pack_id}/{cartId}")
	public Cart decreaseItem(@PathVariable String pack_id, @PathVariable int cartId) {
		Cart cart = cartServiceImpl.getCartById(cartId);
		List<Items> oldItem3 = cart.getItems();
		for (Items i : oldItem3) {
			if (i.getPack_id().equals(pack_id))
			{
				i.setQuantity(i.getQuantity() - 1);
			}
		}
		int price = 0;
		for (Items i : oldItem3) {
			price = price + i.getPrice() * i.getQuantity();
		}
		cart.setTotalPrice(price);
		return cartServiceImpl.updateCart(cartId, cart);

	}

    //deleting Cart By Id
	@DeleteMapping("/delete/{cartId}")
	public void deleteCart(@PathVariable int cartId) {
		cartServiceImpl.deleteCartById(cartId);
	}
}
