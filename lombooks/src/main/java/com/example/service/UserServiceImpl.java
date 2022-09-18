package com.example.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository repository;
	
	static int i=1;
	List<User>ll=new ArrayList<User>();
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		log.info("Inside service get");
//		User user=new User();
//		user.setName("Sidd");
//		user.setAge(i++);
//		user.setRole("customer");
//		ll.add(user);
		System.out.println(repository.findAll());
		
		return  repository.findAll();
		
	}

	@Override
	public User addUser(String name, String role, int age) {
		// TODO Auto-generated method stub
		log.info("Inside service Add");
		User us=new User();
		us.setAge(age);
		us.setName(name);
		us.setRole(role);
//		ll.add(us);
		//return us;
		 repository.saveAndFlush(us);
		 return us;
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		
		Optional<User> op= repository.findById(id);
		return op.get();
	}

	@Override
	public void deleteByid(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	@Override
	public User updateUser(User user) {
		User us=repository.getOne(user.getId());
		us.setAge(user.getAge());
		us.setName(user.getName());
		us.setRole(user.getRole());
		return repository.saveAndFlush(us);
		 
	}

	
}
