package com.example.project.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.model.Applications;
import com.example.project.model.CompaniesExperience;
import com.example.project.model.EducationDetails;
import com.example.project.model.Job;
import com.example.project.model.LoginReturn;
import com.example.project.model.Profile;
import com.example.project.model.User;
import com.example.project.projection.JobView;
import com.example.project.repository.ApplicationRepository;
import com.example.project.repository.CompanyExperienceRepo;
import com.example.project.repository.EducationDetailsRepo;
import com.example.project.repository.ProfileRepo;
import com.example.project.repository.UserRepository;
import com.example.project.service.UserService;

@Service
public class UserServieimpl implements UserService{
	@Autowired
	UserRepository userRepo;
	@Autowired
	ApplicationRepository applicationRepository;
	@Autowired
	ProfileRepo profileRepo;
	@Autowired
	EducationDetailsRepo clgDetailsRepo;
	@Autowired
	CompanyExperienceRepo companyExperienceRepo;

	@Override
	public LoginReturn login(String[] str) {
		// TODO Auto-generated method stub
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
		
		int count = userRepo.countByEmail(email);
		
		if (count==0) {
			return new LoginReturn(-1, false, "username not found");
		}
		
		if (count>1) {
			return new LoginReturn(-1, false, "multiple usernames please contanct admin");
		}
		
		User user=userRepo.findByEmail(email);
		
		if(user.getPassword().equals(password)) {
			return new LoginReturn(user.getId(), true, null);
		}else {
			return new LoginReturn(-1, false, "password wrong");
		}
		
		
	}



	@Override
	public int register(User user) {
		if(user== null) {
			return 0;
		}
		String username=user.getEmail();
		if (username==null || username.length()<1) {
			return 1;
		}
		String password=user.getPassword();
		if (password==null || password.length()<1) {
			return 2;
		}
		
		int count = userRepo.countByEmail(username);
		
		if (count==0) {
			userRepo.save(user);
			return 4;
		}else {
			return  3;
		}
	}



	@Override
	public int applyJobs(int jid, int uid) {
		try {
			int cnt=applicationRepository.countByUidAndJid(uid,jid);
			
			if(cnt==0) {
			
			Applications ap=new Applications();
			ap.setJid(jid);
			ap.setUid(uid);
			ap.setDate(new Date());
			applicationRepository.save(ap);
			return 1;
			}
			if(cnt==1)
			{
				return 2;
			}else {
				return -1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	
	}



	@Override
	public List<JobView> findAppliedJobs(int uid) {
		// TODO Auto-generated method stub
		return applicationRepository.findAppliedJobsByUid(uid);
	}



	@Override
	public int updateProfile(Profile profile) {
//		int cnt=profileRepo.countByUserid(profile.getUserid());
		try {
			profileRepo.save(profile);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		
	}


	
	@Override
	public EducationDetails updateColleges(EducationDetails details) {	
		try {
			
			return clgDetailsRepo.save(details);
		} catch (Exception e) {
			return null;
		}
	}



	@Override
	public CompaniesExperience updatecompany(CompaniesExperience companiesExperience) {
		try {
			return companyExperienceRepo.save(companiesExperience);
		} catch (Exception e) {
			return null;
		}
		
	}



	@Override
	public Profile getProfile(int uid) {
		return profileRepo.findByUserid(uid);
	}



	@Override
	public List<CompaniesExperience> getCompExperience(int pid) {
		// TODO Auto-generated method stub
		return companyExperienceRepo.findByUserid(pid);
	}



	@Override
	public List<EducationDetails> getCollegeDetails(int pid) {
		// TODO Auto-generated method stub
		return clgDetailsRepo.findByUserid(pid);
	}



	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id).get();
	}



	@Override
	public int deleteExp(int id) {
		try {
			companyExperienceRepo.deleteById(id);
			return 1;
			
		} catch (Exception e) {
			return 0;
		}
		
	}



	@Override
	public int deleteClg(int id) {
		try {
			clgDetailsRepo.deleteById(id);
			return 1;
			
		} catch (Exception e) {
			return 0;
		}
	}

}
