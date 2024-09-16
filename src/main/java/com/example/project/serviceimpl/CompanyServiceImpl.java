package com.example.project.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.model.Company;
import com.example.project.model.LoginReturn;
import com.example.project.model.User;
import com.example.project.repository.CompanyRepository;
import com.example.project.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	CompanyRepository companyRepository; 
	
	@Override
	public int saveCompany(Company company) {
		if (company.getCity()==null || company.getEmail()==null || company.getEmail()==null ||company.getName()==null) {
			return 3;
		}

		int count = companyRepository.countByEmail(company.getEmail());
		if (count==0) {
			companyRepository.save(company);
			return 1;
		}
		return 2;
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
		
		int count = companyRepository.countByEmail(email);
		
		if (count==0) {
			return new LoginReturn(-1, false, "username not found");
		}
		
		if (count>1) {
			return new LoginReturn(-1, false, "multiple usernames please contanct admin");
		}
		Company company=companyRepository.findByEmail(email);
		
		if(company.getPassword().equals(password)) {
			return new LoginReturn(company.getId(), true, null);
		}else {
			return new LoginReturn(-1, false, "password wrong");
		}
	}

}
