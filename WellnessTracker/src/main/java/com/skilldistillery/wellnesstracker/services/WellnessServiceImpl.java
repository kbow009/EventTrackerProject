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
	public List<Wellness> getAllWellness() {
		return wellRepo.findAll();
	}

//	@Override
//	public List<Wellness> searchByActivity(String activity) {
//		return wellRepo.findByActivityLike(activity);
//	}

	@Override
	public Wellness save(Wellness wellness) {

		return wellRepo.save(wellness);
	}

	@Override
	public Wellness saveAndFlush(Integer id, Wellness wellness) {

		return wellRepo.saveAndFlush(wellness);
	}

	@Override
	public boolean deleteById(Integer id) {
		boolean deleted = false;
		Wellness wellness = wellRepo.getById(id);
		if (wellness != null) {
			wellRepo.delete(wellness);
			deleted = true;
		}
		return deleted;

	}

	@Override
	public Wellness findById(Integer id) {
		return wellRepo.getById(id);
	}

}
