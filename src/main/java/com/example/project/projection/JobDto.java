package com.example.project.projection;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class JobDto {
	
	private List<JobView> jobview;
	private int totalPages;
	private long totalElements;
	private int size ;
}
