package com.demo.models;

import java.util.List;

public class UserRatingObject {
	
	private List<Rating> userRating;
	
	public UserRatingObject() {}
	
	public List<Rating> getUserRating() {
		return userRating;
	}

	public void setUserRating(List<Rating> userRating) {
		this.userRating = userRating;
	}

	@Override
	public String toString() {
		return "UserRatingObject [userRating=" + userRating + "]";
	}
	
	

}
