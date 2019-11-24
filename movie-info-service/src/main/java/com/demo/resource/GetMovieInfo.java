package com.demo.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.models.Movie;

@RestController
@RequestMapping("/movies")
public class GetMovieInfo {
	@RequestMapping("/{movieId}")
	public Movie generateMovie(@PathVariable ("movieId") String movieId) {
		
		return new Movie(movieId,"Transformer");
		
	}

}
