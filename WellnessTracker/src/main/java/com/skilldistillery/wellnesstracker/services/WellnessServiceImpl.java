package com.skilldistillery.wellnesstracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.wellnesstracker.entities.Wellness;
import com.skilldistillery.wellnesstracker.repositories.WellnessRepository;

@Service
public class WellnessServiceImpl implements WellnessService {

	@Autowired
    WellnessRepository wellnessRepo;

	@Override
	public List<Wellness> index() {
		return wellnessRepo.findAll();
	}

//	@Override
//	public List<Wellness> searchByActivity(String activity) {
//		return wellRepo.findByActivityLike(activity);
//	}

	@Override
	public Wellness save(Wellness wellness) {

		return wellnessRepo.save(wellness);
	}

	@Override
	public Wellness saveAndFlush(Integer id, Wellness wellness) {

		return wellnessRepo.saveAndFlush(wellness);
	}

	@Override
	public boolean deleteById(Integer id) {
		boolean deleted = false;
		Wellness wellness = wellnessRepo.getById(id);
		if (wellness != null) {
			wellnessRepo.delete(wellness);
			deleted = true;
		}
		return deleted;

	}

	@Override
	public Optional<Wellness> findById(int id) {
		return wellnessRepo.findById(id);
	}

}
