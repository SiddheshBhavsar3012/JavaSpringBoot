package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString
@Data
@Builder
@Entity
public class User {
	@Id
	@GeneratedValue
	int id;
	
	int age;
	
	String name;
	
	String role;

}
