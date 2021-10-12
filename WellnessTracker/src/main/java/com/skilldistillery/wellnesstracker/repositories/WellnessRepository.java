package com.skilldistillery.wellnesstracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skilldistillery.wellnesstracker.entities.Wellness;
@Repository
public interface WellnessRepository extends JpaRepository<Wellness, Integer> {

	
}
