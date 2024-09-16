package com.example.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Recruter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	String name;
	String password;
	String email;
	int age;
	int companyid;

}
