package com.mini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mini.Entity.CitizenPlan;
import com.mini.binding.SearchCriteria;
import com.mini.service.CitizenPlanService;

@Controller
public class CitizenPlanController {

	@Autowired
	private CitizenPlanService citizenService;
	
	@GetMapping("/")
	public String index(Model model) {
		
		formInit(model);
		model.addAttribute("search",new CitizenPlan());
		return "index";
	}
	
	private void formInit(Model model) {
		List<String> planNames = citizenService.getPlanNames();
		List<String> planStatus = citizenService.getPlanStatus();
		model.addAttribute("PlanNames",planNames);
		model.addAttribute("PlanStatus",planStatus);
	}
	@PostMapping("/filter-data")
	public String handleSearchButton(@ModelAttribute("search") SearchCriteria searchCriteria,Model model) {
		
		List<CitizenPlan> searchCitizens = citizenService.searchCitizens(searchCriteria);
		model.addAttribute("searchCitizens",searchCitizens);
		
		formInit(model);
		return "index";
	}
}
