package demo.boot.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.boot.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	List<Movie> findByTitleContaining(String title);
	Optional<Movie> findByImdbID(String imdbID);
}
