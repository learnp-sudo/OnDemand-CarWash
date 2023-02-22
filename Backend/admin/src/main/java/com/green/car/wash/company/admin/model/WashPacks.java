package com.green.car.wash.company.admin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="WashPacks")
public class WashPacks {

    @Id
    String pack_id;
    String name;
    int cost;
    public String getPack_id() {
		return pack_id;
	}

	public void setPack_id(String pack_id) {
		this.pack_id = pack_id;
	}

	String description;

    //Default
    public WashPacks(){

    }

    //Constructor
    public WashPacks(String id, String name, int cost, String description) {
        this.pack_id = id;
        this.name = name;
        this.cost = cost;
        this.description = description;
    }

    //Getters and Setters
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WashPacks{" +
                "id=" + pack_id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                '}';
    }

}