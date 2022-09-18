package com.example.service;

public interface UserExistService {

	boolean checkUserExistById(int id);

	boolean checkUserExistByRole(String role);

}