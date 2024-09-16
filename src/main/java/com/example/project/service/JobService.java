package com.example.project.service;

import java.util.List;

import com.example.project.model.Job;
import com.example.project.projection.JobDto;
import com.example.project.projection.JobView;

public interface JobService {
	List<Job> findAll();
	
	JobDto findPagejobs(int pageno);
	
	JobDto findTodaysPagejobs(int pageno);
	
	JobDto findSeacrhjobs(int pageno,String searchTerm);
	
	String createJob(Job job);
	
	Job getJobById(int id);
	
	boolean deleteJobById(int id);
	
	int addjob(Job job);

}
