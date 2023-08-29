package demo.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.boot.model.Movie;
import demo.boot.service.MovieService;
import jakarta.validation.Valid;

@RestController
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public ResponseEntity<?> getAllMovies(){
		List<Movie> movies = movieService.getAllMovies();
		return ResponseEntity.ok(movies);
	}
	
	@GetMapping("/{movieId}")
	public ResponseEntity<?> getMovieById(@PathVariable Long movieId){
		Movie movie = movieService.getById(movieId);
		return ResponseEntity.ok(movie);
	}
	
	@GetMapping("/imdbID/{imdbID}")
	public ResponseEntity<?> getByImdbID(@PathVariable String imdbID){
		Movie movie = movieService.getByImdbID(imdbID);
		return ResponseEntity.ok(movie);
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> searchByTitle(@RequestParam("title") String title){
		List<Movie> movies = movieService.searchMoviesBytitle(title);
		return ResponseEntity.ok(movies);

	}
	
	
	@PostMapping
	public ResponseEntity<?> createMovie(@RequestBody @Valid Movie movie){
		movie = movieService.addMovie(movie);
		return new ResponseEntity<>(movie,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{movieId}")
	public ResponseEntity<?> deleteMovieById(@PathVariable Long movieId){
		movieService.deleteMovieById(movieId);
		return ResponseEntity.noContent().build();
	}
}
