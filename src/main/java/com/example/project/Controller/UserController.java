package com.example.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.CompaniesExperience;
import com.example.project.model.EducationDetails;
import com.example.project.model.Job;
import com.example.project.model.Profile;
import com.example.project.model.User;
import com.example.project.projection.JobView;
import com.example.project.repository.CompanyExperienceRepo;
import com.example.project.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("applyJob/{jid}/{uid}")
	public int applyjob(@PathVariable int jid,@PathVariable int uid) {
		return service.applyJobs(jid, uid);
	}
	
	@GetMapping("appliedJob/{uid}")
	public List<JobView> appleidjob(@PathVariable int uid) {
		return service.findAppliedJobs(uid);
	}
	
	@GetMapping("todaysjobs")
	public List<JobView> Todaysjob(@PathVariable int uid) {
		return service.findAppliedJobs(uid);//incomplete
	}

	
	@PostMapping("updateprofile")
	public int UpdateProfile(@RequestBody Profile profile) {
		return service.updateProfile(profile);
	}
	
	@GetMapping("getUser/{id}")
	public User getUser(@PathVariable int id) {
		return service.getUser(id);
	}
	
	@GetMapping("getprofile/{id}")
	public Profile getprofile(@PathVariable int id) {
		return service.getProfile(id);
	}
	
	@GetMapping("getEducation/{id}")
	public List<EducationDetails> getEducation(@PathVariable int id) {
		return service.getCollegeDetails(id);
	}
	
	@GetMapping("getExperience/{id}")
	public List<CompaniesExperience> getExperience(@PathVariable int id) {
		return service.getCompExperience(id);
	}
	
	@PostMapping("updateCollege")
	public EducationDetails UpdateCollege(@RequestBody EducationDetails details) {
		return service.updateColleges(details);
	}
	
	@PostMapping("updateCompany")
	public CompaniesExperience UpdateCompany(@RequestBody CompaniesExperience details) {
		return service.updatecompany(details);
	}
	@DeleteMapping("deleteExp/{id}")
	public int deleteExp(@PathVariable int id) {
		return service.deleteExp(id);
	}
	@DeleteMapping("deleteClg/{id}")
	public int deleteClg(@PathVariable int id) {
		return service.deleteClg(id);
	}
}
