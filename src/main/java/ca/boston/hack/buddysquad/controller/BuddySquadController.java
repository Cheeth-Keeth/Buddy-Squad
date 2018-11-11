package ca.boston.hack.buddysquad.controller;

//import java.sql.Date;
//import java.sql.Time;
//
import ca.boston.hack.buddysquad.model.*;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	@RequestMapping(value = "/createUser/{username}/{password}", method = RequestMethod.POST)
	@ResponseBody
	public User createUser(@PathVariable String username, @PathVariable String password) {
		
		try {
			
			User user = repository.createUser(username, password);
			
			return user;
			
		} catch (Exception e) {
			
			return null;
			
		}
		
	}
	
	//sign in
	@RequestMapping(value = "/findUser/{username}/{password}", method = RequestMethod.GET)
	@ResponseBody
	public User findUser(@PathVariable String username, @PathVariable String password) {
			
		User user = repository.findUser(username, password);
		
		if (user != null) {
			return user;
		} else {
		
			return null;
		}
			
	}

	@RequestMapping(value = "/findGroup/{fitness}/{learning}/{miscellaneous}", method = RequestMethod.GET)
	@ResponseBody
	public List<Group> findGroup(@PathVariable String fitness, @PathVariable String learning,
			@PathVariable String miscellaneous) {
		
			List<Group> groups = repository.findGroups(fitness,learning,miscellaneous);
			
			if (groups.isEmpty() != true) {
				return groups;
			} else {
				return null;
			}
	}
	
	@RequestMapping(value = "/createGroup/{fitness}/{learning}/{miscellaneous}/{username}", method = RequestMethod.GET)
	@ResponseBody
	public Group createGroup(@PathVariable String fitness, @PathVariable String learning,
			@PathVariable String miscellaneous, @PathVariable String username) {
		

			Group group = repository.createGroup(fitness,learning,miscellaneous,username);
			
			if (group != null) {
				return group;
			} else {
			
				return null;
			}
		
	}

		@RequestMapping(value = "/joinGroup/{username}/{name}", method = RequestMethod.GET)
		@ResponseBody
		public Group joinGroup(@PathVariable String username, @PathVariable String name) {
			

			Group group = repository.joinGroup(username, name);
				
			if (group != null) {
				return group;
			} else {
				
				return null;
			}
			
		}

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
	
	@RequestMapping(value = "/findGroupData/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<User> findGroupData(@PathVariable long id) {

		List<User> users = repository.findGroupData(id);
						
		if (users.isEmpty() != true) {
						
			return users;
						
		} else {
						
			return null;
		}
					
	}
	
	@RequestMapping(value = "/clearActivities/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<User> clearActivities(@PathVariable long id) {

		List<User> users = repository.clearActivities(id);
						
		if (users.isEmpty() != true) {
						
			return users;
						
		} else {
						
			return null;
		}
					
	}
	
	@RequestMapping(value = "/sendMessage/{message}/{username}", method = RequestMethod.GET)
	@ResponseBody
	public User sendMessage(@PathVariable String message, @PathVariable String username) {

		User user = repository.sendMessage(message, username);
						
		if (user != null) {
						
			return user;
						
		} else {
						
			return null;
		}
					
	}
	
	@RequestMapping(value = "/clearMessage/{username}", method = RequestMethod.GET)
	@ResponseBody
	public User clearMessage(@PathVariable String username) {

		User user = repository.clearMessage(username);
						
		if (user != null) {
						
			return user;
						
		} else {
						
			return null;
		}
					
	}
	
}