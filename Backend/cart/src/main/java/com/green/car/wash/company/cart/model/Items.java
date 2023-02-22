package com.green.car.wash.company.cart.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data


public class Items {
	private String name;
	@NotEmpty
	@Min(0)
	private int price;
	@Min(1)
	private int quantity;
	private String pack_id;


	public Items(String name, @NotEmpty @Min(0) int price, @Min(1) int quantity, String pack_id) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.pack_id = pack_id;
	}

	public Items() {

	}

	// getters and setters
	public String getPack_id() {
		return pack_id;
	}

	public void setPack_id(String pack_id) {
		this.pack_id = pack_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Items [name=" + name + ", price=" + price + ", quantity=" + quantity + ", pack_id=" + pack_id + "]";
	}


}
