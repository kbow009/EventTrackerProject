package com.skilldistillery.wellnesstracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.wellnesstracker.entities.Wellness;
import com.skilldistillery.wellnesstracker.services.WellnessService;

@RestController
@RequestMapping("api")
public class WellnessController {
	@Autowired
	private WellnessService wellSvc;
	
	@GetMapping("wellness")
	public List<Wellness> wellnessIndex (){
		return wellSvc.allWellness();
		}
}