package demo.boot.service;

import java.util.List;

import demo.boot.exception.MovieAlreadyExistsException;
import demo.boot.exception.MovieNotFoundException;
import demo.boot.model.Movie;

public interface MovieService {
	List<Movie> getAllMovies() throws MovieNotFoundException;
	Movie getById(Long id) throws MovieNotFoundException;
	Movie getByImdbID(String imdbID) throws MovieNotFoundException;
	Movie addMovie(Movie movie) throws MovieAlreadyExistsException;
	List<Movie> searchMoviesBytitle(String title);
	void deleteMovie(Movie movie);
	void deleteMovieById(Long Id);
}
