package com.skilldistillery.wellnesstracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.wellnesstracker.entities.Wellness;
import com.skilldistillery.wellnesstracker.repositories.WellnessRepository;


@Service
public class WellnessServiceImpl implements WellnessService {
	
	@Autowired
	private WellnessRepository wellRepo;

	
	@Override
	public List<Wellness> allWellness() {

		return wellRepo.findAll();
	}


	

}
