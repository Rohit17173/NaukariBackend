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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.Company;
import com.example.project.model.Job;
import com.example.project.model.LoginReturn;
import com.example.project.model.Recruter;
import com.example.project.model.User;
import com.example.project.service.CompanyService;
import com.example.project.service.JobService;
import com.example.project.service.RecruiterService;

@RestController
@CrossOrigin
@RequestMapping("company")
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	RecruiterService recruiterService;
	
	@RequestMapping("login")
	public LoginReturn login(@RequestBody String[] str) {
		LoginReturn res = companyService.login(str);
		return res;
	}
	
	@PostMapping("register")
	public int addCompany(@RequestBody Company company) {
		return companyService.saveCompany(company);	
	}
	
	@RequestMapping("addrecruiter")
	public int register(@RequestBody Recruter rec) {
		return recruiterService.saveRecruter(rec);
	}
	
	@RequestMapping("getRecruter/{cid}")
	public List<Recruter> getRecruter(@PathVariable int cid){
		return recruiterService.getRecruter(cid);
	}

	
}
