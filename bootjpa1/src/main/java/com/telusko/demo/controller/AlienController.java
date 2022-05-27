 package com.telusko.demo.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.demo.dao.AlienRepo;
import com.telusko.demo.model.Alien;

@RestController
public class AlienController 
{
	@Autowired
	AlienRepo repo;
	@RequestMapping("/")
   public String home()
   {
	   return "home.jsp";
   }
	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable int aid)
	{
		Alien a=repo.getOne(aid);
		repo.delete(a);
		return "Deleted";
	}
	@PostMapping("/alien")
	public Alien addAlien(@RequestBody Alien alien)
	{
		
		Alien a=repo.save(alien);
		return a;
	}

	@GetMapping(path="/aliens")
	
	public List<Alien> getAliens()
	{
		
		return repo.findAll();
		
	}
	@PutMapping("/alien")
	public Alien saveOrUpdateAlien(@RequestBody Alien alien)
	{
		Alien a=repo.save(alien);
		return a;
	}
	@RequestMapping("/alien/{aid}")
	
	public Optional<Alien> getAlien(@PathVariable("aid") int aid)
	{
		
		return repo.findById(aid);
		
	}

}
