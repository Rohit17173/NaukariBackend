package com.example.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.project.model.Applications;
import com.example.project.projection.JobView;
import com.example.project.projection.UserApplication;

public interface ApplicationRepository extends JpaRepository<Applications, Integer>{
	
	@Query(value = "SELECT a.id,name,age,email FROM naukari.applications as a join naukari.user as u on a.uid=u.id where a.jid=:jid",nativeQuery = true)
	List<UserApplication> getUserApplication(@Param("jid") int jid);

	Applications findByUidAndJid(int uid,int jid);
	
	int countByUidAndJid(int uid,int jid);
	
	@Query(value = "SELECT j.id,j.title,j.description,j.minsalary,j.minexp,j.maxexp,j.maxsalary,c.companyname as company FROM naukari.applications as a join naukari.job j on a.jid=j.id join naukari.company as c on j.companyid=c.id where is_closed_position=0 and uid=:uid",nativeQuery = true)
	List<JobView> findAppliedJobsByUid(@Param("uid") int uid);

}
