package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.extern.slf4j.Slf4j;

//@Controller
@Slf4j
@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/all")
	//@ResponseBody
	
	List<User>getAllUser(){
		log.info("inside Controller GET");
		return service.getAllUser();
		
		
	}
	
	@PostMapping("/add")
	//@ResponseBody
	User addUser(String name,String role,int age) {
		log.info("inside Controller ADD");
		return service.addUser(name, role, age);
		 
	}
	
	@GetMapping("/id/{id}")
	User getUSerById(@PathVariable int id) {
		return service.getById( id);
	}
	
	@DeleteMapping("/delete/{id}")
	void deleteById(@PathVariable int id) {
		service.deleteByid(id);
	}
	@PutMapping("update")
	User updateUser(User user) {
		return service.updateUser(user);
	}

}
