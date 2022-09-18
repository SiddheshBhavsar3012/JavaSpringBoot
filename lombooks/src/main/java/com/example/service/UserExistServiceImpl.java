package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserExistServiceImpl implements UserExistService {
	@Autowired 
	UserRepository repository;
	
	@Override
	public boolean checkUserExistById(int id) {
		return repository.existsById(id);
	}
	@Override
	public boolean checkUserExistByRole(String role) {
		User us =new User();
		us.setRole(role);
		
		ExampleMatcher exampleMatcher=ExampleMatcher.matching().withMatcher("role",ExampleMatcher.GenericPropertyMatchers.exact().ignoreCase()).withIgnorePaths("name","id","age");
		Example<User> example=Example.of(us,exampleMatcher);
		return repository.exists(example);
	}

}
