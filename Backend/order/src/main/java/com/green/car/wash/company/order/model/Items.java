package com.green.car.wash.company.order.model;

import javax.validation.constraints.Min;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.mongodb.core.mapping.Document;




public class Items
{
	private String washPack;
	@NotEmpty
	@Min(0)
	private int price;
	@Min(1)
	private int quantity;
	private String pack_id;
public Items() {
		super();
	}
public Items(String name, @NotEmpty @Min(0) int price, @Min(1) int quantity, String pack_id) {
		super();
		this.washPack = name;
		this.price = price;
		this.quantity = quantity;
		this.pack_id = pack_id;
	}
public String getPack_id() {
		return pack_id;
	}
	public void setPack_id(String pack_id) {
		this.pack_id = pack_id;
	}
	public String getName() {
		return washPack;
	}
	public void setName(String name) {
		this.washPack = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Items [name=" + washPack + ", price=" + price + ", quantity=" + quantity + ", pack_id=" + pack_id + "]";
	}

}
