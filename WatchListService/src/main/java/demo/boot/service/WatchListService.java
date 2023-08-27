package demo.boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import demo.boot.exception.WatchListAlreadyExistsException;
import demo.boot.exception.WatchListNotFoundException;
import demo.boot.model.WatchList;

@Service
public interface WatchListService {
	WatchList addWatchList(WatchList watchList) throws WatchListAlreadyExistsException;
	WatchList getById(Long id) throws WatchListNotFoundException;
	void deleteById(Long id);
	List<WatchList> getByUserId(Long userId) throws WatchListNotFoundException;
	WatchList addMovieId(Long watchListId, Long movieId);
}
