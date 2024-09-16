package com.example.project.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.project.model.Job;
import com.example.project.projection.JobView;

public interface JobRepository extends JpaRepository<Job, Integer>{
	
	@Query(value="SELECT j.id,title,j.description,minexp,maxexp,minsalary,maxsalary,location,name as company FROM naukari.job as j join naukari.company as c on c.id=j.companyid WHERE is_closed_position=0 and j.title LIKE %:searchTerm% OR j.description LIKE %:searchTerm%",nativeQuery = true)
    Page<JobView> findByTitleOrDescriptionContaining(@Param("searchTerm") String searchTerm, Pageable pageable);
	
	@Query(value="SELECT j.id,title,j.description,minexp,maxexp,minsalary,maxsalary,location,companyname as company FROM naukari.job as j join naukari.company as c on c.id=j.companyid  where is_closed_position=0;",nativeQuery = true)
	Page<JobView> findJobWithCompanyname( Pageable pageable);
	
	@Query(value="SELECT j.id,title,j.description,minexp,maxexp,minsalary,maxsalary,location,companyname as company FROM naukari.job as j join naukari.company as c on c.id=j.companyid WHERE is_closed_position=0 and DATE(posted_date) = CURDATE();",nativeQuery = true)
	Page<JobView> findTodaysJobWithCompanyname( Pageable pageable);

	List<Job> findByRid(int rid);

	@Query(value = "SELECT * FROM naukari.job where is_closed_position=0 and rid=:rid",nativeQuery = true)
	List<Job> findByRidActive(@Param("rid") int rid);
	
	@Query(value = "SELECT * FROM naukari.job where is_closed_position=1 and rid=:rid",nativeQuery = true)
	List<Job> findByRidClosed(@Param("rid") int rid);
}
