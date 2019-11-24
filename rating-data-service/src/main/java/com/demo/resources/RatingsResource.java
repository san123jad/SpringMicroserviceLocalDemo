package com.demo.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Rating;
import com.demo.model.UserRatingObject;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

	@RequestMapping("/{movieId}")
	public Rating getRatings(@PathVariable ("movieId") String movieId) {
		
		return new Rating(movieId, 4);
		
	}
	@RequestMapping("/users/{userId}")
	public UserRatingObject getUserRatings(@PathVariable ("userId") String userId) {
		List<Rating> rating = Arrays.asList(
				new Rating("1234", 4),new Rating("5678", 3)
		);
		UserRatingObject userRatingObject = new UserRatingObject();
		userRatingObject.setUserRating(rating);
		return userRatingObject;
		
	}
}
