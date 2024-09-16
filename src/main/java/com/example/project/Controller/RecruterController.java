package com.example.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.Job;
import com.example.project.model.LoginReturn;
import com.example.project.projection.UserApplication;
import com.example.project.service.JobService;
import com.example.project.service.RecruiterService;

@RestController
@CrossOrigin
@RequestMapping("recruter")
public class RecruterController {
	
	@Autowired
	RecruiterService recruiterService;
	
	@Autowired
	JobService jobService;
	
	@RequestMapping("login")
	public LoginReturn login(@RequestBody String[] str) {
		System.out.println(str);
		LoginReturn res = recruiterService.login(str);
		return res;
	}
	
	@GetMapping("viewjob/{id}")
	public List<Job> Viewjob(@PathVariable int id) {
		
		return recruiterService.RecruterJobs(id);
	}
	
	@PostMapping("addjob")
	public int addJob(@RequestBody Job job) {
		System.out.println(job);
		return jobService.addjob(job);
	}

	@GetMapping("getJobApplications/{jid}")
	public List<UserApplication> getAllJobApplications(@PathVariable int jid) {
		return recruiterService.geApllications(jid);
	}
	
	@GetMapping("closePosition/{id}")
	public int closePosition(@PathVariable int id) {
		return recruiterService.closePosition(id);
	}
	
	@GetMapping("getActiveJob/{id}")
	public List<Job> getActiveJobApplications(@PathVariable int id) {
		return  recruiterService.getActiveJob(id);
		
	}
	
	@GetMapping("getClosedJob/{id}")
	public List<Job> getClosedJobApplications(@PathVariable int id) {
		
		return recruiterService.getClosedJob(id);
	}
	
	
}
