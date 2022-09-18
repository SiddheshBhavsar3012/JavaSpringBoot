package com.example;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dom4j.util.UserDataAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort.Direction;

import com.example.entity.User;
import com.example.service.UserDeleteService;
import com.example.service.UserExistService;
import com.example.service.UserService;
import com.example.service.UserServiceReaderImpl;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class LombooksApplication  implements CommandLineRunner {
	@Autowired
	UserService service;
	@Autowired
	UserServiceReaderImpl impl;
	@Autowired
	UserExistService existServiceImpl;
	@Autowired
	UserDeleteService deleteServiceImpl;
	
	public static void main(String[] args) {
		log.info("inside main method");
		SpringApplication.run(LombooksApplication.class, args);
		User user=new User();
		user.setName("Sidd");
		System.out.println(user.getName());
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		log.info("Delete User");
		
		//log.info("Exist id or not  " +deleteServiceImpl.deleteOneUser(new User().builder().age(26).id(3).name("Mayuresh").role("User").build()));
		//log.info("ALl Data Deleted"+deleteServiceImpl.pruneTable());
		List<User> ll=new ArrayList<User>();
		ll.add(new User().builder().age(26).id(3).name("Mayuresh").role("User").build());
		ll.add(new User().builder().age(25).id(1).name("Siddhesh").role("User").build());
		//log.info("Delete in large "+deleteServiceImpl.deleteAllThese(ll));
		//log.info("Bacth delete all "+deleteServiceImpl.deleteAllInBatch());
		log.info("Delete by id "+deleteServiceImpl.deleteById(1));
		log.info("Deleted with help of bacth multiple "+deleteServiceImpl.deleteAllTheseInBatch(ll));
		//serviceReader();
		//existMethods();
	}

	private void existMethods() {
		log.info("Exist id or not 0 " +existServiceImpl.checkUserExistById(0));
		log.info("Exist id or not 1 " +existServiceImpl.checkUserExistById(1));
		log.info("check whether the role is exist of any user "+existServiceImpl.checkUserExistByRole("user"));
	}

	private void serviceReader() {
		log.info("No Role  "+impl.getUserWithNoRole());
		log.info("Page  "+impl.getUserPaged().get().collect(Collectors.toList())) ;
		log.info("Page  Custome "+impl.getUserCustomePage(1, 4).get().collect(Collectors.toList())) ;
		log.info("Latest update Added ☻♥♦♣♠  "+impl.getUserWithLatestAddedOrder());
		log.info("Latest Sorted by id ☻♥♦♣♠  "+impl.getUserWithSortedId(Direction.ASC));
		log.info("Latest Sorted by name ☻♥♦♣♠  "+impl.getUserWithSortedName(Direction.DESC));
		log.info("Page  getUserPageAndSortedByName "+impl.getUserPagedAndSortedByNameAndWithTheseUsers("User")
			.get().collect(Collectors.toList())) ;
		log.info("Page  getUserPageAndSortedByNameCustomePage ANd No.Record "+impl.getUserPagedAndSortedByNameAndWithTheseUsersMatchRoleCustomePAgeAndRecord("User",0,3).get().collect(Collectors.toList())) ;
		log.info("Order by name and matching role"+impl.getUSerByOrderByNameAndRole("User"));
		List<Integer> ids=new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		log.info("Find by ids "+impl.getUserByIds(ids));
	}

}
