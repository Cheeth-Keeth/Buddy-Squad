package ca.boston.hack.buddysquad.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.boston.hack.buddysquad.model.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;
import java.util.stream.Collectors;


import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class BuddySquadRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	//create user
	@Transactional
	public User createUser(String username, String password) {
			
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setFitness(null);
			user.setLearning(null); 
			user.setMiscellaneous(null); 
			user.setLearningComplete(false); 
			user.setMiscellaneousComplete(false); 
			user.setFitnessComplete(false);
			entityManager.persist(user);
			return user;
	
	}
	
	@Transactional
	public int findUser(String username, String password) {
		
		try {
			TypedQuery <User> query = entityManager.createQuery("SELECT c FROM User c WHERE c.username = :username", User.class);
			User ourUser = query.setParameter("username", username).getSingleResult();
			
			if (ourUser.username.equals(username) && ourUser.password.equals(password)) {
				
				return 2;
				
			} else {
				
				return 1;
			
			}
			
		} catch (Exception e) {
			
			return 0;
			
		}
	
	} 
	
	@Transactional
	public Group joinGroup(String username, long id) {
		
		TypedQuery <Group> query = entityManager.createQuery("SELECT c FROM Group c WHERE c.id = :id", Group.class); 
		Group group = query.setParameter("id", id).getSingleResult(); 
		int space = group.getAvailableSeats(); 
		
		TypedQuery <User> queryTwo = entityManager.createQuery ("SELECT c FROM User c WHERE c.username = :username", User.class);
		User user = queryTwo.setParameter("username", username).getSingleResult();
		
		if (space > 0) {
			user.setId(group.getId()); 
			group.setAvailableSpots(group.getAvailableSeats()-1);
			entityManager.persist(user);
			entityManager.persist(group);
		}
	  
	    return group;
	}
	
	@Transactional
	public List<Group> findGroups(String fitness, String learning, String miscellaneous) {
		
		TypedQuery<Group> query = entityManager.createQuery("SELECT c FROM Group c WHERE c.fitness = :fitness"
				+ " AND c.learning = :learning AND c.miscellaneous = :miscellaneous AND c.availableSpots > 0", Group.class);
		
		
		query.setParameter("fitness", fitness);
		query.setParameter("learning", learning);
		query.setParameter("miscellaneous", miscellaneous);
		
		return query.getResultList();
		
	}
	
	@Transactional
	public Group createGroup(String Fitness, String Learning, String Miscellaneous, String username) {
		
		Group group = new Group(); 
		group.setAvailableSpots(4); 
		group.setLearning(Learning);
		group.setFitness(Fitness); 
		group.setMiscellaneous(Miscellaneous); 
		entityManager.persist(group); 
		
		TypedQuery <Group> query = entityManager.createQuery("SELECT c FROM Group c WHERE c.availableSpots = 4" , Group.class);
		group = query.getSingleResult();
		
		long id = group.getId(); 
		group.setName("Squad" + id);
		group.setAvailableSpots(2);
		
		entityManager.persist(group);
		
		TypedQuery <User> query1 = entityManager.createQuery("SELECT c FROM User c WHERE c.username = :username" , User.class);
		User user = query1.setParameter("username", username).getSingleResult();
		
		user.setId(id); 
		entityManager.persist(user); 
		
		return group;

	}
	
	@Transactional
	public User completeFitness(String username) {
			
		TypedQuery <User> query = entityManager.createQuery("SELECT c FROM User c WHERE c.username = :username", User.class); 
		User user = query.setParameter("username", username).getSingleResult(); 
			
		user.setFitnessComplete(true);
		  
		return user;
	}

		@Transactional
		public User completeLearning(String username) {
				
			TypedQuery <User> query = entityManager.createQuery("SELECT c FROM User c WHERE c.username = :username", User.class); 
			User user = query.setParameter("username", username).getSingleResult(); 
				
			user.setLearningComplete(true);
			  
			return user;
		}
		
		@Transactional
		public User completeMiscellaneous(String username) {
				
			TypedQuery <User> query = entityManager.createQuery("SELECT c FROM User c WHERE c.username = :username", User.class); 
			User user = query.setParameter("username", username).getSingleResult(); 
				
			user.setMiscellaneousComplete(true);
			  
			return user;
		}	
	
		@Transactional
		public List<User> findGroupData(long id) {
			
			TypedQuery <User> query = entityManager.createQuery("SELECT c FROM User c WHERE c.id = :id", User.class); 
			List<User> users = query.setParameter("id", id).getResultList();
			  
			return users;
			
			
		}
	
}