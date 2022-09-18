package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserDeleteServiceImpl implements UserDeleteService {
	@Autowired
	UserRepository repository;
	
	@Override
	public String deleteOneUser(User us) {
	 try {
		repository.delete(us);
		return "Delete Sucessfully";
	 }
	 catch(Exception exception) {
		 return "This Obj is not exist";
	 }
	}
	@Override
	public String pruneTable() {
		repository.deleteAll();
		return "Deleted all";
	}
	@Override
	public String deleteAllThese(List<User> ll) {
		repository.deleteAll(ll);
		return "All these "+ll+" Deleted";
		
	}
	@Override
	public String deleteAllInBatch() {
		repository.deleteAllInBatch();
		return "Deleted All in batch ";
		
	}
	@Override
	public String deleteById(int id) {
		repository.deleteById(id);
		return "{id} is deleted";
	}
	
	@Override
	public String deleteAllTheseInBatch(List<User> ll) {
		repository.deleteInBatch(ll);
		return "All Deleted in Batch"+ll;
	}

}
