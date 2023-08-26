package demo.boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import demo.boot.exception.UserAlreadyExistException;
import demo.boot.exception.UserNotFoundException;
import demo.boot.model.User;

public interface UserService {
	List<User> getAllUsers() throws UserNotFoundException;
	User getUserById(Long id) throws UserNotFoundException;
	User getUserByEmail(String email) throws UserNotFoundException;
	User addUser(User user) throws UserAlreadyExistException;
	
}
