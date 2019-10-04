package io.java.springsecurityjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.java.springsecurityjpa.dao.UserRepository;
import io.java.springsecurityjpa.dto.User;

@RestController
public class UserResourse {

	@Autowired
	UserRepository uRepo;
	User u = new User();
	@GetMapping("/")
	public String getWelcome()
	{
		/*u.setPassword("pass");
		u.setActive(true);
		u.setRole("user");
		u.setUserName("root");
		uRepo.save(u);*/
		return "welcome";
	}
}
