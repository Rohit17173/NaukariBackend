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
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String title;
	String description;
	int minsalary;
	int	maxsalary;
	int maxexp;
	int	minexp;
	String location;
	int rid;
	int companyid;
	Date postedDate;
	int isClosedPosition;

}