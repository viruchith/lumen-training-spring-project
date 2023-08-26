package demo.boot.model;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class WatchList {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	@Column(unique = true)
	private String title;

	private String description;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;
	
	private Set<Long> movieIds;

	@PrePersist
	private void onCreate() {
		createdAt = LocalDateTime.now();
	}

	@PreUpdate
	private void onUpdate() {
		updatedAt = LocalDateTime.now();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "WatchList [Id=" + Id + ", title=" + title + ", description=" + description + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

	public Set<Long> getMovieIds() {
		return movieIds;
	}

	public void setMovieIds(Set<Long> movieIds) {
		this.movieIds = movieIds;
	}
	
	

}
