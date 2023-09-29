package com.mini.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.mini.Entity.CitizenPlan;
import com.mini.binding.SearchCriteria;
import com.mini.repo.CitizenPlanRepo;
import com.mini.service.CitizenPlanService;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletResponse;
@Service
public class CitizenPlanServiceImpl implements CitizenPlanService{
	
	@Autowired
	private CitizenPlanRepo repo;

	@Override
	public List<String> getPlanNames() {

		return repo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {
		// TODO Auto-generated method stub
		return repo.getPlanStatus();
	}

	public List<CitizenPlan> searchCitizens(SearchCriteria searchCriteria) {
		// TODO Auto-generated method stub
		CitizenPlan entity=new CitizenPlan();
		
		if(StringUtils.isNotBlank(searchCriteria.getPlanName())) {
			entity.setPlanName(searchCriteria.getPlanName());
		}
		if(StringUtils.isNotBlank(searchCriteria.getPlanStatus())) {
			entity.setPlanStatus(searchCriteria.getPlanStatus());
		}
		if(StringUtils.isNotBlank(searchCriteria.getGender())) {
			entity.setGender(searchCriteria.getGender());
		}
		//QBE Query By Example---Data filtering is very simple by using Exmple
		Example<CitizenPlan> of=Example.of(entity);
		return repo.findAll(of);
	}

	@Override
	public void generateExcel(HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void generatePdf(HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	
}
