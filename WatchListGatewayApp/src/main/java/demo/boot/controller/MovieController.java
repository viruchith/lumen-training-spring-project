package demo.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import demo.boot.models.Movie;

@RestController
@RequestMapping("movies")
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping
	public ResponseEntity<?> getAllUsers(){
		ResponseEntity<Movie[]> response =  restTemplate.getForEntity("http://MovieService", Movie[].class);
		return response;
	}
}
