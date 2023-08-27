package demo.boot.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.boot.model.WatchList;
import java.util.List;

@Repository
public interface WatchListRepository extends JpaRepository<WatchList, Long> {
	List<WatchList> findByUserId(Long userId);
}
