package com.example.project.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.project.model.Company;
import com.example.project.model.Job;
import com.example.project.model.Recruter;
import com.example.project.projection.JobDto;
import com.example.project.projection.JobView;
import com.example.project.repository.JobRepository;
import com.example.project.repository.RecruterRepository;
import com.example.project.service.JobService;

@Service
public class JobServiceImpl implements JobService{

	@Autowired
	JobRepository jobRepository;
	
	@Autowired
	RecruterRepository recruterRepository;
	
	@Override
	public List<Job> findAll() {
		return jobRepository.findAll();
	}

	@Override
	public String createJob(Job job) {
		try {
			jobRepository.save(job);
			return "succesfull";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}

	@Override
	public Job getJobById(int id) {
		return jobRepository.findById(id).get();
	}

	@Override
	public boolean deleteJobById(int id) {
		try {
			jobRepository.deleteById(id);
			return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			}
	}

	@Override
	public int addjob(Job job) {
		try {
			Recruter r=recruterRepository.findById(job.getRid()).get();
			
			job.setCompanyid(r.getCompanyid());
			job.setPostedDate(new Date());
			System.out.println(job);
			jobRepository.save(job);
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public JobDto findPagejobs(int pageno) {
		Pageable p=PageRequest.of(pageno, 5);
		 Page<JobView> page = jobRepository.findJobWithCompanyname(p);
		 int size=page.getSize();
			int totalpages=page.getTotalPages();
			long totalElements=page.getTotalElements();
			
			JobDto jd=new JobDto();
			jd.setTotalPages(totalpages);
			jd.setJobview(page.getContent());
			jd.setSize(size);
			jd.setTotalElements(totalElements);
			return jd;
	}

	@Override
	public JobDto findSeacrhjobs(int pageNo, String searchTerm) {
		int pageSize = 5;
		String sortDir = Sort.Direction.ASC.name();
		
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) 
                ? Sort.by("title").ascending()
                : Sort.by("title").descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		
		Page<JobView> page = jobRepository.findByTitleOrDescriptionContaining(searchTerm, pageable);
		int size=page.getSize();
		int totalpages=page.getTotalPages();
		long totalElements=page.getTotalElements();
		
		JobDto jd=new JobDto();
		jd.setTotalPages(totalpages);
		jd.setJobview(page.getContent());
		jd.setSize(size);
		jd.setTotalElements(totalElements);
		return jd;
	}

	@Override
	public JobDto findTodaysPagejobs(int pageno) {
		Pageable p=PageRequest.of(pageno, 5);
		 Page<JobView> page = jobRepository.findJobWithCompanyname(p);
		 int size=page.getSize();
			int totalpages=page.getTotalPages();
			long totalElements=page.getTotalElements();
			
			JobDto jd=new JobDto();
			jd.setTotalPages(totalpages);
			jd.setJobview(page.getContent());
			jd.setSize(size);
			jd.setTotalElements(totalElements);
			return jd;
	}

}
