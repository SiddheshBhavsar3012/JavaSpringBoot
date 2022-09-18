package com.example.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import com.example.entity.User;

public interface ServiceReader {

	List<User> getUserWithNoRole();

	Page<User> getUserPaged();

	Page<User> getUserCustomePage(int paNumber, int noOfRecord);

	List<User> getUserWithLatestAddedOrder();

	List<User> getUserWithSortedId(Direction direction);

	List<User> getUserWithSortedName(Direction direction);

	Page<User> getUserPagedAndSortedByNameAndWithTheseUsers(String role);

	Page<User> getUserPagedAndSortedByNameAndWithTheseUsersMatchRoleCustomePAgeAndRecord(String role, int p, int noR);

	List<User> getUSerByOrderByNameAndRole(String role);

	List<User> getUserByIds(List<Integer> ids);

}