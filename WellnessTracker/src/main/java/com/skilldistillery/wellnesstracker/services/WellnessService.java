package com.skilldistillery.wellnesstracker.services;

import java.util.List;

import com.skilldistillery.wellnesstracker.entities.Wellness;

public interface WellnessService {

	public List<Wellness> getAllWellness();

//	List<Wellness> searchByActivity(String activity);

	public Wellness save(Wellness wellness);

	public Wellness saveAndFlush(Integer id, Wellness wellness);

	public boolean deleteById(Integer id);

	Wellness findById(Integer id);
}
