package com.example.project.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	String name;
	String companyname;
	String password;
	private String description;
	long contact;
	int noofemp;
	String email;
	String city;

}
