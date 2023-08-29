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
import org.springframework.web.bind.annotation.RestController;

import demo.boot.dtos.AddMovieDTO;
import demo.boot.model.WatchList;
import demo.boot.service.WatchListService;
import jakarta.validation.Valid;

@RestController
public class WatchListController {
	@Autowired
	private WatchListService watchListService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		WatchList watchList = watchListService.getById(id);
		return ResponseEntity.ok(watchList);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<?> getByUserId(@PathVariable Long userId){
		List<WatchList> watchLists = watchListService.getByUserId(userId);
		return ResponseEntity.ok(watchLists);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		watchListService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@PostMapping
	public ResponseEntity<?> createWatchList(@RequestBody @Valid WatchList watchList){
		watchList = watchListService.addWatchList(watchList);
		return new ResponseEntity<>(watchList,HttpStatus.CREATED);
	}
	
	@PostMapping("/{watchListId}/movies")
	public ResponseEntity<?> addMovieToWatchList(@PathVariable Long watchListId ,@RequestBody @Valid AddMovieDTO addMovieDTO ){
		WatchList watchList =  watchListService.addMovieId(watchListId, addMovieDTO.getMovieId());
		return ResponseEntity.ok(watchList.getMovieIds());
	}
}
