package demo.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import demo.boot.exception.UserAlreadyExistException;
import demo.boot.exception.UserNotFoundException;
import demo.boot.model.User;
import demo.boot.repos.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	

	@Override
	public User getUserById(Long id) throws UserNotFoundException {
		User user = userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User by the id : "+id+", was not found !"));
		return user;
	}

	@Override
	public User getUserByEmail(String email) throws UserNotFoundException {
		User user = userRepository.findByEmail(email).orElseThrow(()-> new UserNotFoundException("User by the email : "+email+", was not found !"));
		return user;
	}

	@Override
	public User addUser(User user) throws UserAlreadyExistException {
		try {
			user = userRepository.save(user);
		} catch (DataIntegrityViolationException e) {
			throw new UserAlreadyExistException("User with the  email : "+user.getEmail()+", already exists !");
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> userNoPasswordProjections = userRepository.findAll();
		if(userNoPasswordProjections.isEmpty()) {
			throw new UserNotFoundException("No users found !");
		}
		return userNoPasswordProjections;
	}

}
