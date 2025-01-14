package com.chatapp.web.login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		Optional <User> user = repo.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("User 404");
		}
		System.out.println("Attempting to login user: '" + username + "'");
		
		User up = new User();
		
		System.out.println("retrieved from db: '" + up.getUsername() + "'");
		System.out.println("retrieved from db: '" + up.getPassword() + "'");
		
		if (user.isPresent()) {
	        User ooptionaluser = user.get();
	        System.out.println("User found in database: " + user.getUsername());
	    } else {
	        System.out.println("User not found in database for username: " + username);
	    }
		
		return new UserDetailsImplementation(user);
	}

}
