package com.mini.service;

import java.util.List;

import com.mini.Entity.CitizenPlan;
import com.mini.binding.SearchCriteria;

import jakarta.servlet.http.HttpServletResponse;

public interface CitizenPlanService {
	
	public List<String> getPlanNames();
	public List<String> getPlanStatus();
	public List<CitizenPlan> searchCitizens(SearchCriteria searchCriteria);
	public void generateExcel(HttpServletResponse response);
	public void generatePdf(HttpServletResponse response);

}
