package com.example.project.model;

import java.util.Date;

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
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	int userid;
	long mobile;
	String position;
	String resume;
	String headline;
	String skills;
	String location;
	int expectedCtc;
	int currntCtc;
	double toalexp;
	boolean isexperienced;
	
}
