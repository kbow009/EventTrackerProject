package com.skilldistillery.wellnesstracker.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public List<Wellness> index(){
		return wellSvc.index();
	}

	@GetMapping("wellness/{id}")
	public Optional<Wellness> showById(@PathVariable Integer id, HttpServletResponse res) {
		Optional<Wellness> wellness = wellSvc.findById(id);
		if (wellness == null) {
			res.setStatus(404);
		}
		return wellness;
	}

	@PostMapping("wellness")
	public Wellness addNew(@RequestBody Wellness wellness, HttpServletRequest req, HttpServletResponse res) {
		try {
			wellness = wellSvc.save(wellness);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(wellness.getId());
			res.setHeader("Location", url.toString());
		} catch (Exception e) {
			System.err.println(e);
			res.setStatus(400);
			wellness = null;
		}
		return wellness;
	}

	@PutMapping("wellness/{id}")
	public Wellness replaceWellness(@PathVariable Integer id, @RequestBody Wellness wellness, HttpServletResponse res) {
		try {
			wellness = wellSvc.saveAndFlush(id, wellness);
			if (wellness == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			System.err.println(e);
			wellness = null;
			res.setStatus(400);
		}
		return wellness;
	}

	@DeleteMapping("wellness/{id}")
	public void deleteWellness(@PathVariable Integer id, HttpServletResponse res) {
		try {
			if (wellSvc.deleteById(id)) {
				res.setStatus(204);
			} else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			System.err.println(e);
			res.setStatus(400);
		}
	}

//	@GetMapping("wellness/search/{keyword}")
//	public List<Wellness> searchByActivity(@PathVariable String activity) {
//		return wellSvc.searchByActivity(activity);
//	}
}