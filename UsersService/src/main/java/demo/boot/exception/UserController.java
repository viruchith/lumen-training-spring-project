package demo.boot.exception;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.boot.model.User;
import demo.boot.service.UserService;
import jakarta.validation.Valid;

@RestController
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("hello")
	public String hello() {
		return "hello";
	}
	
	
	@GetMapping
	public ResponseEntity<?> getAllUsers(){
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable Long  userId){
		User user = userService.getUserById(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<?> addUser(@Valid @RequestBody User user){
		logger.info(user.toString());
		user = userService.addUser(user);
		return new ResponseEntity<>(user,HttpStatus.CREATED);
	}
	
}
