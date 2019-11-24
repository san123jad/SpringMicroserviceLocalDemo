package com.demo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.models.CatalogItem;
import com.demo.models.Movie;
import com.demo.models.UserRatingObject;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	@Autowired
	RestTemplate restTemplate;
	ObjectMapper om= new ObjectMapper();
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCaltalog(@PathVariable("userId") String userId) {

		UserRatingObject rating=restTemplate.getForObject("http://rating-data-service/ratingsdata/users/4",UserRatingObject.class);
		
		return rating.getUserRating().stream().map(ratings -> {
			Movie movie=restTemplate.getForObject("http://movie-info-service/movies/"+ratings.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName(), "Test", ratings.getRating());
		}).collect(Collectors.toList());

	}

}
