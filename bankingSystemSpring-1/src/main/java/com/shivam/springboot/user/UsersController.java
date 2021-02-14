package com.shivam.springboot.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shivam.springboot.user.UsersService;

@CrossOrigin("http://localhost:4200")
@RestController
public class UsersController {

	@Autowired
	UsersService usersService;
	
	@GetMapping("/findUsersById/{uId}")
	public Optional<UsersEntity> findUsersById(@PathVariable("uId") Long uId) {
		return usersService.findUsersById(uId);
	}

	@GetMapping("/findAllUsers")
	public List<UsersEntity> findAllUsers() {
		return usersService.findAllUsers();
	}
}
