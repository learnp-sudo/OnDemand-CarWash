package com.green.car.wash.company.order.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="cart")
public class Cart
{

@Id
private int cartId;
private String orderId;
private String useremailid;
private List<Items> items;
private Car car;
private String washpacks;
private int totalPrice;
@NotEmpty(message = "phoneNo can't be empty")
private long phoneNo;
@NotEmpty(message = "Pincode can't be empty")
private String areapincode;




public Cart(int cartId, String orderId, String useremailid, List<Items> items, Car car, String washpacks,
		int totalPrice, @NotEmpty(message = "phoneNo can't be empty") long phoneNo,
		@NotEmpty(message = "Pincode can't be empty") String areapincode) {
	super();
	this.cartId = cartId;
	this.orderId = orderId;
	this.useremailid = useremailid;
	this.items = items;
	this.car = car;
	this.washpacks = washpacks;
	this.totalPrice = totalPrice;
	this.phoneNo = phoneNo;
	this.areapincode = areapincode;
}



public String getWashpacks() {
	return washpacks;
}

public void setWashpacks(String washpacks) {
	this.washpacks = washpacks;
}

public Cart() {
	super();
}

public int getCartId() {
	return cartId;
}
public void setCartId(int cartId) {
	this.cartId = cartId;
}
public String getCustomerId() {
	return orderId;
}
public void setCustomerId(String orderId) {
	this.orderId = orderId;
}

public String getOrderId() {
	return orderId;
}



public void setOrderId(String orderId) {
	this.orderId = orderId;
}



public String getUseremailid() {
	return useremailid;
}



public void setUseremailid(String useremailid) {
	this.useremailid = useremailid;
}



public List<Items> getItems() {
	return items;
}
public void setItems(List<Items> items) {
	this.items = items;
}
public Car getCar() {
	return car;
}
public void setCar(Car car) {
	this.car = car;
}
public int getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(int totalPrice) {
	this.totalPrice = totalPrice;
}
public long getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(long phoneNo) {
	this.phoneNo = phoneNo;
}
public String getAreapincode() {
	return areapincode;
}
public void setAreapincode(String areapincode) {
	this.areapincode = areapincode;
}

@Override
public String toString() {
	return "Cart [cartId=" + cartId + ", OrderId=" + orderId + ", email=" + useremailid + ", items=" + items + ", car=" + car
			+ ", washpacks=" + washpacks + ", totalPrice=" + totalPrice + ", phoneNo=" + phoneNo + ", areapincode="
			+ areapincode + "]";
}




}