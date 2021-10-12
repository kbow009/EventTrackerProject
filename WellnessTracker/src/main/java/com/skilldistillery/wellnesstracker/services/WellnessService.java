package com.skilldistillery.wellnesstracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skilldistillery.wellnesstracker.entities.Wellness;
@Service
public interface WellnessService {

	public List<Wellness> index();

//	List<Wellness> searchByActivity(String activity);

	public Wellness save(Wellness wellness);

	public Wellness saveAndFlush(Integer id, Wellness wellness);

	public boolean deleteById(Integer id);

	Optional<Wellness> findById(int id);
}
