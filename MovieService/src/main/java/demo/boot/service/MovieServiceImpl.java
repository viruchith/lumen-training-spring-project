package demo.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import demo.boot.exception.MovieAlreadyExistsException;
import demo.boot.exception.MovieNotFoundException;
import demo.boot.model.Movie;
import demo.boot.repos.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movies = movieRepository.findAll();
		if (movies.isEmpty()) {
			throw new MovieNotFoundException("No movies weree found !");
		}
		return movies;
	}

	@Override
	public Movie getById(Long id) {
		Movie movie = movieRepository.findById(id).orElseThrow(()->new MovieNotFoundException("Movie with the id : "+id+", was not found !"));
		return movie;
	}

	@Override
	public Movie getByImdbID(String imdbID) {
		Movie movie = movieRepository.findByImdbID(imdbID).orElseThrow(()->new MovieNotFoundException("Movie with the IMDBID : "+imdbID+", was not found !"));
		return movie;
	}

	@Override
	public Movie addMovie(Movie movie) {
		try {
			movie = movieRepository.save(movie);
		} catch (DataIntegrityViolationException e) {
			throw new MovieAlreadyExistsException("Movie with the IMDBID : "+movie.getImdbID()+" already exists !");
		}
		return movie;
	}

	@Override
	public void deleteMovie(Movie movie) {
		movieRepository.delete(movie);
	}

	@Override
	public List<Movie> searchMoviesBytitle(String title) {
		List<Movie> movies = movieRepository.findByTitleContaining(title);
		if(movies.isEmpty()) {
			throw new MovieNotFoundException("No movies were found !");
		}
		return movies;
	}

	@Override
	public void deleteMovieById(Long Id) {
		movieRepository.deleteById(Id);
	}

}
