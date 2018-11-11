package ca.boston.hack.buddysquad.controller;

//import java.sql.Date;
//import java.sql.Time;
//
import ca.boston.hack.buddysquad.model.*;
//import ca.mcgill.ecse321.ridesharing.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import ca.mcgill.ecse321.ridesharing.model.User;
import ca.boston.hack.buddysquad.repository.BuddySquadRepository;


@RestController
public class BuddySquadController {

	@Autowired
	BuddySquadRepository repository;
	
	@RequestMapping("/")
	public String greeting () 
	{
		return "Hello world!";
	}
	
	//sign in
	@RequestMapping(value = "/signIn/{username}/{password}", method = RequestMethod.GET)
	@ResponseBody
	public User createUser(@PathVariable String username, @PathVariable String password) {
		
		try {
			
			User user = repository.createUser(username, password);
			
			return user;
			
		} catch (Exception e) {
			
			return null;
			
		}
		
	}
	
	//create route
	@RequestMapping(value = "/findGroup/{fitness}/{learning}/{miscellaneous}", method = RequestMethod.GET)
	@ResponseBody
	public List<Group> createRoute(@PathVariable String fitness, @PathVariable String learning,
			@PathVariable String miscellaneous) {
		

		List<Group> groups = repository.findGroup(fitness,learning,miscellaneous);
			
		if (groups != null) {
			return groups;
		} else {
			
			Group group = repository.createGroup(fitness,learning,miscellaneous);
			
			return group;
		}
		
	}
	
	//create route
		@RequestMapping(value = "/joinGroup/{username}/{id}", method = RequestMethod.GET)
		@ResponseBody
		public Group joinGroup(@PathVariable String username, @PathVariable Long id) {
			

			Group group = repository.joinGroup(username, id);
				
			if (group != null) {
				return group;
			} else {
				
				return null;
			}
			
		}
	
	//find route
	@RequestMapping(value = "/completeFitness/{username}", method = RequestMethod.POST)
	@ResponseBody
	public User completeFitness(@PathVariable String username) {

		User user = repository.completeFitness(username);
			
		if (user != null) {
			
			return user;
			
		} else {
			
			return null;
		}
		
	}
	
	//find route
	@RequestMapping(value = "/completeLearning/{username}", method = RequestMethod.POST)
	@ResponseBody
	public User completeLearning(@PathVariable String username) {

		User user = repository.completeLearning(username);
				
		if (user != null) {
				
			return user;
				
		} else {
				
			return null;
		}
			
	}
	
	//find route
	@RequestMapping(value = "/completeMiscellaneous/{username}", method = RequestMethod.POST)
	@ResponseBody
	public User completeMiscellaneous(@PathVariable String username) {

		User user = repository.completeMiscellaneous(username);
					
		if (user != null) {
					
			return user;
					
		} else {
					
			return null;
		}
				
	}
	
}