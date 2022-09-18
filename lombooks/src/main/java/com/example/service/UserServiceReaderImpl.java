package com.example.service;

import java.util.List;

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


@Service
public class UserServiceReaderImpl implements ServiceReader {
	@Autowired
	UserRepository repository;
	@Override
	public List<User> getUserWithNoRole() {
		// TODO Auto-generated method stub
		
		
		User us=new User();
		us.setRole("");
		//
		ExampleMatcher exampleMatcher=ExampleMatcher.matching().withMatcher("role",ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id","name","age");
		
		
		
		Example<User> example=Example.of(us,exampleMatcher);
		
		
		return repository.findAll(example);
	}

	@Override
	public Page<User> getUserPaged() {
		
		Pageable first3record=PageRequest.of(1,2);//  of(no.of page, No of record on that page)
		return repository.findAll(first3record);
			
	}
	@Override
	public Page<User> getUserCustomePage(int paNumber,int noOfRecord) {
		Pageable first3record=PageRequest.of(paNumber,noOfRecord);//  of(no.of page, No of record on that page)
		return repository.findAll(first3record);
		
	}

	@Override
	public List<User> getUserWithLatestAddedOrder() {
		// TODO Auto-generated method stub
		return repository.findAll(Sort.by(Direction.DESC,"id"));
		
	}

	@Override
	public List<User> getUserWithSortedId(Direction direction) {
		// TODO Auto-generated method stub
		return repository.findAll(Sort.by(direction,"id"));
	}

	@Override
	public List<User> getUserWithSortedName(Direction direction) {
		// TODO Auto-generated method stub
		return repository.findAll(Sort.by(direction,"name"));
	}

	@Override
	public Page<User> getUserPagedAndSortedByNameAndWithTheseUsers(String role) {
		// TODO Auto-generated method stub
		User us=new User();
		us.setRole(role);
		//
		ExampleMatcher exampleMatcher=ExampleMatcher.matching().withMatcher("role",ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id","name","age");
		
		
		
		Example<User> example=Example.of(us,exampleMatcher);
		Pageable first3record=PageRequest.of(1,3,Sort.by("name"));
		
		return repository.findAll(example,first3record);
	}
	@Override
	public Page<User> getUserPagedAndSortedByNameAndWithTheseUsersMatchRoleCustomePAgeAndRecord(String role,int p,int noR) {
		// TODO Auto-generated method stub
		User us=new User();
		us.setRole(role);
		//
		ExampleMatcher exampleMatcher=ExampleMatcher.matching().withMatcher("role",ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id","name","age");
		
		
		
		Example<User> example=Example.of(us,exampleMatcher);
		Pageable first3record=PageRequest.of(p,noR,Sort.by("name"));
		
		return repository.findAll(example,first3record);
	}

	@Override
	public List<User> getUSerByOrderByNameAndRole(String role) {
		// TODO Auto-generated method stub
		User us=new User();
		us.setRole(role);
		//
		ExampleMatcher exampleMatcher=ExampleMatcher.matching().withMatcher("role",ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id","name","age");
		
		
		
		Example<User> example=Example.of(us,exampleMatcher);
		
		return repository.findAll(example,Sort.by("name"));
	}

	@Override
	public List<User> getUserByIds(List<Integer> ids) {
		// TODO Auto-generated method stub
		return repository.findAllById(ids);
	}
	

}
