package demo.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import demo.boot.models.User;
import jakarta.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	private RestTemplate restTemplate;
	
	public static final String USER_SERVICE_URL = "http://UserService/";
	
	@GetMapping
	public ResponseEntity<?> getAllUsers(){
		ResponseEntity<User[]> response =  restTemplate.getForEntity(USER_SERVICE_URL, User[].class);
		return response;
	}
	
	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody @Valid User user){
		ResponseEntity<User> responseEntity = restTemplate.postForEntity(USER_SERVICE_URL, user, User.class);
		return responseEntity;
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getMovieByID(@PathVariable Long userId){
		ResponseEntity<User> responseEntity = restTemplate.getForEntity(USER_SERVICE_URL+userId, User.class);
		return responseEntity;
	}
}
