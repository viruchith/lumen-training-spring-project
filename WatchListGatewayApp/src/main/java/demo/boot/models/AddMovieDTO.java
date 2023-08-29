package demo.boot.models;

import jakarta.validation.constraints.NotNull;

public class AddMovieDTO {
	@NotNull
	private Long movieId;

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	
	
}
