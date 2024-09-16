package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.model.Company;
import com.example.project.model.User;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

	int countByEmail(String email);

	Company findByEmail(String email);

}
