package com.example.project.service;

import com.example.project.model.Company;
import com.example.project.model.LoginReturn;

public interface CompanyService {
	int saveCompany(Company company);

	LoginReturn login(String[] str);

}
