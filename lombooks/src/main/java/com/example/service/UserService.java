package com.example.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import com.example.entity.User;

public interface UserService {
	public List<User>getAllUser();
	public User addUser(String name,String role,int age);
	public User getById(int id);
	public void deleteByid(int id);
	public User updateUser(User user);
	}
