package demo.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import demo.boot.models.Movie;
import jakarta.validation.Valid;

@RestController
@RequestMapping("movies")
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping
	public ResponseEntity<?> getAllMovies(){
		ResponseEntity<Movie[]> response =  restTemplate.getForEntity("http://MovieService", Movie[].class);
		return response;
	}
	
	@PostMapping
	public ResponseEntity<?> createMovie(@RequestBody @Valid Movie movie){
		ResponseEntity<Movie> responseEntity = restTemplate.postForEntity("http://MovieService", movie, Movie.class);
		return responseEntity;
	}
	
	@GetMapping("/{movieId}")
	public ResponseEntity<?> getMovieByID(@PathVariable Long movieId){
		ResponseEntity<Movie> responseEntity = restTemplate.getForEntity("http://MovieService/"+movieId, Movie.class);
		return responseEntity;
	}
	
	@GetMapping("/imdbID/{imdbID}")
	public ResponseEntity<?> getByImdbID(@PathVariable String imdbID){
		ResponseEntity<Movie> responseEntity = restTemplate.getForEntity("http://MovieService/imdbID/"+imdbID, Movie.class);
		return responseEntity;
	}
	
}
