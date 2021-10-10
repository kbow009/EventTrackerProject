package com.skilldistillery.wellnesstracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.wellnesstracker.entities.Wellness;

public interface WellnessRepository extends JpaRepository<Wellness, Integer> {

}
