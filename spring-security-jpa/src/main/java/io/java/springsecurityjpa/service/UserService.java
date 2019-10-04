package io.java.springsecurityjpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.java.springsecurityjpa.dao.UserRepository;
import io.java.springsecurityjpa.dto.User;
import io.java.springsecurityjpa.security.MyUserDetails;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	UserRepository uRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = uRepo.findByUserName(username);
		return user.map(MyUserDetails :: new).get();
		
	}

}
