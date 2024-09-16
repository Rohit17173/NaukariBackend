package com.example.project.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.model.Job;
import com.example.project.model.LoginReturn;
import com.example.project.model.Recruter;
import com.example.project.model.User;
import com.example.project.projection.UserApplication;
import com.example.project.repository.ApplicationRepository;
import com.example.project.repository.JobRepository;
import com.example.project.repository.RecruterRepository;
import com.example.project.service.RecruiterService;

@Service
public class RecruiterServiceimpl implements RecruiterService{
	
	@Autowired
	RecruterRepository recruterRepository;
	
	@Autowired
	JobRepository jobRepository;
	
	@Autowired
	ApplicationRepository applicationRepository;

	@Override
	public int saveRecruter(Recruter recruter) {
		if(recruter== null) {
			return 0;
		}
		String username=recruter.getEmail();
		if (username==null || username.length()<1) {
			return 1;
		}
		String password=recruter.getPassword();
		if (password==null || password.length()<1) {
			return 2;
		}
		
		int count = recruterRepository.countByEmail(username);
		
		if (count==0) {
			recruterRepository.save(recruter);
			return 4;
		}else {
			return  3;
		}
	}

	@Override
	public List<Recruter> getRecruter(int id) {
		return recruterRepository.findByCompanyid(id);
		 
	}

	@Override
	public LoginReturn login(String[] str) {
		if(str==null) {
			return new LoginReturn();
		}
		String email=str[0];
		if (email==null || email.length()<1) {
			return new LoginReturn(-1, false, "Enter username");
		}
		String password=str[1];
		if (password==null || password.length()<1) {
			return new LoginReturn(-1, false, "Enter password");
		}
		
		int count = recruterRepository.countByEmail(email);
		
		if (count==0) {
			return new LoginReturn(-1, false, "username not found");
		}
		
		if (count>1) {
			return new LoginReturn(-1, false, "multiple usernames please contanct admin");
		}
		
		Recruter recruter=recruterRepository.findByEmail(email);
		
		if(recruter.getPassword().equals(password)) {
			return new LoginReturn(recruter.getId(), true, null);
		}else {
			return new LoginReturn(-1, false, "password wrong");
		}
		
	}

	@Override
	public List<Job> RecruterJobs(int id) {
		// TODO Auto-generated method stub
		 List<Job> myJobs= jobRepository.findByRid(id);
		return myJobs;
	}

	@Override
	public List<UserApplication> geApllications(int jid) {
		// TODO Auto-generated method stub
		return applicationRepository.getUserApplication(jid);
	}

	@Override
	public int closePosition(int jid) {
		try {
			Job j=jobRepository.findById(jid).get();
			j.setIsClosedPosition(1);
			jobRepository.save(j);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		
	}

	@Override
	public List<Job> getActiveJob(int id) {
		// TODO Auto-generated method stub
		return jobRepository.findByRidActive(id);
	}

	@Override
	public List<Job> getClosedJob(int id) {
		return jobRepository.findByRidClosed(id);
		 
	}

	

}
