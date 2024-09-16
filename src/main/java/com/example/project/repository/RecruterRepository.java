package com.example.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.model.Recruter;

public interface RecruterRepository extends JpaRepository<Recruter, Integer> {

	int countByEmail(String username);
	List<Recruter> findByCompanyid(int id);
	Recruter findByEmail(String email);

}
