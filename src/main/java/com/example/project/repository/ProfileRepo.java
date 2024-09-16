package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.model.Profile;

public interface ProfileRepo extends JpaRepository<Profile, Integer>{

	Profile findByUserid(int uid);


	
}
