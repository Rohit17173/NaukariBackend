package com.example.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.model.EducationDetails;

public interface EducationDetailsRepo extends JpaRepository<EducationDetails, Integer>{

//	List<EducationDetails> findByProfileid(int profileid);

	List<EducationDetails> findByUserid(int pid);
}
