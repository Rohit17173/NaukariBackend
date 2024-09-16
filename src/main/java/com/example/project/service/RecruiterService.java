package com.example.project.service;

import java.util.List;

import com.example.project.model.Job;
import com.example.project.model.LoginReturn;
import com.example.project.model.Recruter;
import com.example.project.projection.UserApplication;

public interface RecruiterService {
	int saveRecruter(Recruter recruter);
	List<Recruter> getRecruter(int id);
	LoginReturn login(String[] str);
	List<Job> RecruterJobs(int id);
	List<UserApplication> geApllications(int jid);
	int closePosition(int jid);
	List<Job> getActiveJob(int id);
	List<Job> getClosedJob(int id);
}
