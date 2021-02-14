package com.shivam.springboot.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivam.springboot.user.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	public Optional<UsersEntity> findUsersById(Long uId) {
		return usersRepository.findById(uId);
	}

	public List<UsersEntity> findAllUsers() {
		return usersRepository.findAll();
	}
}
