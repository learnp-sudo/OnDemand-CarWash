package com.green.car.wash.company.customer.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="ratings")
public class Ratings {
	@Id
	
	 String id;
	//This will work as a foreign key to get all the ratings of specific washer
    String washerName;
    String comments;
    //Rating should be out of 10
    int Rating;
	public Ratings() {

	}
	public Ratings(String id, String washerName, String comments, int rating) {
		super();
		this.id = id;
		this.washerName = washerName;
		this.comments = comments;
		Rating = rating;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWasherName() {
		return washerName;
	}
	public void setWasherName(String washerName) {
		this.washerName = washerName;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getRating() {
		return Rating;
	}
	public void setRating(int rating) {
		Rating = rating;
	}
	@Override
	public String toString() {
		return "Ratings [id=" + id + ", washerName=" + washerName + ", comments=" + comments + ", Rating=" + Rating
				+ "]";
	}


}
