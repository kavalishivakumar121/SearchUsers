package com.mini.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.mini.Entity.CitizenPlan;
import com.mini.repo.CitizenPlanRepo;

@Component
public class DataLoader implements ApplicationRunner{
	@Autowired
	private CitizenPlanRepo repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		repo.deleteAll(); 

		CitizenPlan c=new CitizenPlan("Jhon","Jhon@in.com", 12341, 263542, "Cash", "Approved", "male", LocalDate.now(),LocalDate.now().plusMonths(6));
		CitizenPlan c1=new CitizenPlan("ram","ram@in.com", 43434, 362542, "Food", "Terminated", "male",LocalDate.now(),LocalDate.now().plusMonths(6));
		CitizenPlan c2=new CitizenPlan("anil","anil@in.com", 89781, 763542, "Cash", "Approved", "male",LocalDate.now(),LocalDate.now().plusMonths(6));
		CitizenPlan c3=new CitizenPlan("Rani","rani@in.com", 12321, 663542, "medical", "Denied","Female", LocalDate.now(),LocalDate.now().plusMonths(6));
		CitizenPlan c4=new CitizenPlan("kumar","kumar@in.com", 32341, 563542, "Food", "Denied","male", LocalDate.now(),LocalDate.now().plusMonths(6));
		CitizenPlan c5=new CitizenPlan("anji","anji@in.com", 82341, 363542, "medical ", "Denied","male", LocalDate.now(),LocalDate.now().plusMonths(6));
		CitizenPlan c6=new CitizenPlan("shruthi","shruthi@in.com", 72341, 463542, "Food", "Terminated", "Female",LocalDate.now(),LocalDate.now().plusMonths(6));
		List<CitizenPlan> listOfCitizens = Arrays.asList(c,c1,c2,c3,c4,c5,c6);
		repo.saveAll(listOfCitizens);
	}
}
