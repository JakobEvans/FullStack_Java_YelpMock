package com.cognixia.jump.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

//@Table(name="REVIEWS")
@Entity

public class Review implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id//Pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="REVIEWID")
	Integer id;
	
	@Column(name="reviewContent")
	String reviewContent;
	
	@Column(name="RATING")
	Double rating;
	// Old relationships that are overdone
	
	
//	//users has the reviews
//    @JsonBackReference
//	@ManyToOne
//	@JoinColumn(name = "user_id", referencedColumnName = "ID")
//	User user;
//    @JsonBackReference
//	@ManyToOne
//	@JoinColumn(name = "restaurant_id", referencedColumnName = "ID" )
//	Restaurant restaurant;
	
	//review has users
//	@JsonManagedReference
//	@ManyToOne
//	@JoinColumn(name = "user_id", referencedColumnName = "ID")
//	User user;
//	@JsonManagedReference
//	@ManyToOne
//	@JoinColumn(name = "restaurant_id", referencedColumnName = "ID" )
//	Restaurant restaurant;
    
    
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "ID")
	User user;
	@ManyToOne
	@JoinColumn(name = "restaurant_id", referencedColumnName = "ID" )
	Restaurant restaurant;
    
	
	public Review() {
		this(-1,"N/A",0.0);
	}

	

	public Review(Integer id, String reviewContent, Double rating) {
	super();
	this.id = id;
	this.reviewContent = reviewContent;
	this.rating = rating;
//	this.user = user;
//	this.restaurant = restaurant;
}

	public String toJson() {
		
		return "{\"id\" : " + id
				+ ", \"reviewContent\" : \"" + reviewContent + "\""
				+ ", \"rating\" : \"" + rating + "\"" 
				+ ", \"user\" : \"" + user + "\"" +
				", \"restaurant\" : \"" + restaurant + "\"" +
		"}";
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getreviewContent() {
		return reviewContent;
	}

	public void setreviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", reviewContent=" + reviewContent + ", rating=" + rating + ", user="
				+ user + ", restaurantId=" + restaurant + "]";
	}

	
}
