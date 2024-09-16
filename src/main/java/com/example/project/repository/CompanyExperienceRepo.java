package com.example.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.model.CompaniesExperience;

public interface CompanyExperienceRepo extends JpaRepository<CompaniesExperience, Integer>{

//	List<CompaniesExperience> findByProfileid(int profileid);

	List<CompaniesExperience> findByUserid(int pid);
}
