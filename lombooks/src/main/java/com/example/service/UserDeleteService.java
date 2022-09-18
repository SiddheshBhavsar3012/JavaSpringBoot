package com.example.service;

import java.util.List;

import com.example.entity.User;

public interface UserDeleteService {

	String deleteOneUser(User us);

	String pruneTable();

	String deleteAllThese(List<User> ll);

	String deleteAllInBatch();

	String deleteById(int id);

	String deleteAllTheseInBatch(List<User> ll);

}