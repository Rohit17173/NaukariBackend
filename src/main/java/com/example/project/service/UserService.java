package com.example.project.service;

import java.util.List;

import com.example.project.model.CompaniesExperience;
import com.example.project.model.EducationDetails;
import com.example.project.model.Job;
import com.example.project.model.LoginReturn;
import com.example.project.model.Profile;
import com.example.project.model.User;
import com.example.project.projection.JobDto;
import com.example.project.projection.JobView;

public interface UserService {
	
	LoginReturn login(String[] str);
	int register(User user);
	
	int applyJobs(int jid,int uid);
	
	List<JobView> findAppliedJobs(int uid);
	
	int updateProfile(Profile profile);
	
	EducationDetails updateColleges(EducationDetails details);
	
	CompaniesExperience updatecompany(CompaniesExperience companiesExperience);
	
	Profile getProfile(int uid);
	
	List<CompaniesExperience> getCompExperience(int pid);
	
	List<EducationDetails> getCollegeDetails(int pid);
	
	User getUser(int id);
	
	int deleteExp(int id);
	int deleteClg(int id);
}
