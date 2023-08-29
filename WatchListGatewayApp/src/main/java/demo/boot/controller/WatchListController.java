package demo.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import demo.boot.models.AddMovieDTO;
import demo.boot.models.WatchList;
import jakarta.validation.Valid;

@RestController
@RequestMapping("watchlist")
public class WatchListController {

		@Autowired
		private RestTemplate restTemplate;
		public static final String WATCHLIST_SERVICE_URL = "http://WatchListService/";
		@PostMapping
		public ResponseEntity<?> createWatchList(@RequestBody @Valid WatchList watchList){
			ResponseEntity<WatchList> responseEntity = restTemplate.postForEntity(WATCHLIST_SERVICE_URL, watchList, WatchList.class);
			return responseEntity;
		}
		@PostMapping("/{watchListId}/movies")
		public ResponseEntity<?> addMovieToWatchList(@PathVariable Long watchListId ,@RequestBody @Valid AddMovieDTO addMovieDTO ){
			ResponseEntity<Integer[]>responseEntity=restTemplate.postForEntity(WATCHLIST_SERVICE_URL+watchListId+"/movies", addMovieDTO,Integer[].class);
			return responseEntity;
		}
		@GetMapping("/{id}")
		public ResponseEntity<?> getById(@PathVariable Long id){
			ResponseEntity<WatchList> responseEntity = restTemplate.getForEntity(WATCHLIST_SERVICE_URL+id, WatchList.class);
			return responseEntity;
		}
		
		@GetMapping("/user/{userId}")
		public ResponseEntity<?> getByUserID(@PathVariable Long userId){
			ResponseEntity<WatchList[]> responseEntity = restTemplate.getForEntity(WATCHLIST_SERVICE_URL+"user/"+userId, WatchList[].class);
			return responseEntity;
		}
		@DeleteMapping("/{id}")
		public ResponseEntity<?> deleteById(@PathVariable Long id){
			restTemplate.delete(WATCHLIST_SERVICE_URL+id);
			return ResponseEntity.noContent().build();
		}
		
}
