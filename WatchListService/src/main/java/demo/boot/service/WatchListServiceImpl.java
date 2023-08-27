package demo.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import demo.boot.exception.WatchListAlreadyExistsException;
import demo.boot.exception.WatchListNotFoundException;
import demo.boot.model.WatchList;
import demo.boot.repos.WatchListRepository;

@Service
public class WatchListServiceImpl implements WatchListService {

	@Autowired
	private WatchListRepository watchListRepository;
	
	@Override
	public WatchList addWatchList(WatchList watchList) throws WatchListAlreadyExistsException {
		try {
			watchList = watchListRepository.save(watchList);
		} catch (DataIntegrityViolationException e) {
			throw new WatchListAlreadyExistsException("WatchList withh the title : "+watchList.getTitle()+", already exists !");
		}
		return watchList;
	}

	@Override
	public WatchList getById(Long id) throws WatchListNotFoundException {
		WatchList watchList = watchListRepository.findById(id).orElseThrow(()->new WatchListNotFoundException("WatchList with the id : "+id+", was not found !"));
		return watchList;
	}

	@Override
	public void deleteById(Long id) {
		watchListRepository.deleteById(id);
	}

	@Override
	public List<WatchList> getByUserId(Long userId) throws WatchListNotFoundException {
		List<WatchList> watchLists = watchListRepository.findByUserId(userId);
		if(watchLists.isEmpty()) {
			throw new WatchListNotFoundException("No watclists exist for user with id : "+userId);
		}
		return watchLists;
	}

	@Override
	public WatchList addMovieId(Long watchListId,Long movieId) {
		WatchList watchList = watchListRepository.findById(watchListId).orElseThrow(()->new WatchListNotFoundException("WatchList with thhe id : "+watchListId+", was not found !") );
		watchList.getMovieIds().add(movieId);
		watchList =  watchListRepository.save(watchList);
		return watchList;
	}

}
