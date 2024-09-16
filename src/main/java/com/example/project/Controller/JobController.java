package com.example.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.Job;
import com.example.project.projection.JobDto;
import com.example.project.projection.JobView;
import com.example.project.service.JobService;

@RestController
@CrossOrigin
public class JobController {
	
	@Autowired
	JobService jobService;

	//get All jobs
	@GetMapping("jobs")
	public ResponseEntity<List<Job>> showjobs(){
		return ResponseEntity.ok(jobService.findAll());
	}
	
	//post a job
	@PostMapping("add")
	public ResponseEntity<String> addJob(@RequestBody Job job) {
		jobService.createJob(job);
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}
	
	//find by id
	@GetMapping("jobs/{id}")
	public ResponseEntity<Job> getjobNyId(@PathVariable int id){
		Job job=jobService.getJobById(id);
		if(job!=null) {
			return new ResponseEntity<Job>(job,HttpStatus.OK);
		}
		return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("update")
	public ResponseEntity<String> updateJob(@RequestBody Job job) {
		jobService.createJob(job);
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}
	@PostMapping("update/{id}")
	public boolean deleteJob(@PathVariable int id) {
		return jobService.deleteJobById(id);
	}
	
	@GetMapping("search/{PageNo}/{search}")
	public JobDto SearchJob(@PathVariable int PageNo,@PathVariable String search) {
		if (search==null || search.length()<1) {
			return null;
		}
		return jobService.findSeacrhjobs(PageNo, search);
	}
	
	@GetMapping("getjob/{PageNo}")
	public JobDto SearchJobwithc(@PathVariable int PageNo) {
//		System.out.println("controller");
		return jobService.findPagejobs(PageNo);
	}
}
