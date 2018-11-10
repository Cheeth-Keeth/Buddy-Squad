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
		user.setRating(5);
		user.setUsername(username);
		user.setPassword(password);
		entityManager.persist(user);
		return user;	
	}
	
	//create route
	@Transactional
	public Route createRoute(int numberOfSeats, String startCity, String endCity, String aDate, String vehicle, String driver, String price) {
		
		Route route = new Route();
		route.setAvailableSeats(numberOfSeats);
		route.setStartCity(startCity);
		route.setEndCity(endCity);
		route.setDate(aDate);
		route.setIsAvailable(true);
	    route.setIsComplete(false);
	    route.setVehicle(vehicle);
	    route.setDriver(driver);
	    route.setPrice(price);
	    entityManager.persist(route);
	    
	    //TypedQuery<Route> query = entityManager.createQuery("SELECT c FROM Route c WHERE c.availableSeats = :numberOfSeats AND c.date = :aDate ", Route.class);
	    
	    return route;
	}
	
	//join route
	@Transactional
	public Route joinRoute(long id, String user) {
		
		TypedQuery<Route> query = entityManager.createQuery("SELECT c FROM Route c WHERE c.id = :id", Route.class);
		
		Route route = query.setParameter("id", id).getSingleResult();
		int seats = route.getAvailableSeats();
		
		if (seats == 6) {
			
			route.setPassenger1(user);
			
		} else if (seats == 5) {
			
			route.setPassenger2(user);
			
		} else if (seats == 4) {
			
			route.setPassenger3(user);
			
		} else if (seats == 3) {
			
			route.setPassenger4(user);
			
		} else if (seats == 2) {
			
			route.setPassenger5(user);
			
		} else  {
			
			route.setPassenger6(user);
			route.setIsAvailable(false);
			
		}
		
		route.setAvailableSeats(route.getAvailableSeats() - 1);
		entityManager.persist(route);
		
		return route;
	}
	
	//find route
	@Transactional
	public List<Route> findRoutes(String aDate, String startCity, String endCity){
	
		TypedQuery<Route> query = entityManager.createQuery("SELECT c FROM Route c WHERE c.date = :aDate"
				+ " AND c.startCity = :startCity AND c.endCity = :endCity AND c.isAvailable = TRUE AND c.isComplete = FALSE", Route.class);
		
		
		query.setParameter("startCity", startCity);
		query.setParameter("endCity", endCity);
		query.setParameter("aDate", aDate);
		
		return query.getResultList();

	}
	
	//end route
	@Transactional
	public Route endRoute(long id) {
			
		TypedQuery<Route> query = entityManager.createQuery("SELECT c FROM Route c WHERE c.id = :id", Route.class);
			
		Route route = query.setParameter("id", id).getSingleResult();
			
		route.setIsComplete(true);
			
		entityManager.persist(route);
			
		return route;
	}
		
	//show drivers routes
	@Transactional
	public List<Route> showDriversRoutes(String driver) {
			
		TypedQuery<Route> query = entityManager.createQuery("SELECT c FROM Route c WHERE c.driver = :driver AND c.isComplete = FALSE", Route.class);
			
		List<Route> routes = query.setParameter("driver", driver).getResultList();
			
		return routes;
	}
	
	//show passengers routes
	@Transactional
	public List<Route> showPassengerRoutes(String passenger) {
		
		TypedQuery<Route> query = entityManager.createQuery("SELECT c FROM Route c WHERE c.passenger1 = :passenger OR c.passenger2 = :passenger OR c.passenger3 = :passenger OR c.passenger4 = :passenger OR c.passenger5 = :passenger OR c.passenger6 = :passenger", Route.class);
		
		query.setParameter("passenger", passenger);
		
		List<Route> allRoutes = query.getResultList();
		List<Route> routes = new ArrayList<Route>();
		
		for (Route route : allRoutes) {
			
			if (!route.isIsComplete()) {
				
				routes.add(route);
				
			}
			
		}
			
		return routes;
		
	}

	//leave route
	@Transactional
	public Route leaveRoute(long id, String passenger) {
		
		boolean found = false;
		
		TypedQuery<Route> query = entityManager.createQuery("SELECT c FROM Route c WHERE c.id = :id", Route.class);
		
		Route route = query.setParameter("id", id).getSingleResult();
		
		if (route.getPassenger1() != null) {
		
			if (route.getPassenger1().equals(passenger)) {
			
				route.setPassenger1(null);
				found = true;
			
			}
			
		} else if (route.getPassenger2() != null) {
			
			if (route.getPassenger2().equals(passenger)) {
				
				route.setPassenger2(null);
				found = true;
			
			}
			
		} else if (route.getPassenger3() != null) {
			
			if (route.getPassenger3().equals(passenger)) {
				
				route.setPassenger3(null);
				found = true;
			
			}
			
		} else if (route.getPassenger4() != null) {
			
			if (route.getPassenger4().equals(passenger)) {
				
				route.setPassenger4(null);
				found = true;
			
			}
			
		} else if (route.getPassenger5() != null) {
			
			if (route.getPassenger5().equals(passenger)) {
				
				route.setPassenger5(null);
				found = true;
			
			}
			
		} else if (route.getPassenger6() != null) {
			
			if (route.getPassenger6().equals(passenger)) {
				
				route.setPassenger6(null);
				found = true;
			
			}
			
		}
		
		if (found) {
			
			route.setAvailableSeats(route.getAvailableSeats() + 1);
			entityManager.persist(route);
			
		}
		
		return route;
		
	}

	//rankUser
	@Transactional
	public User rateUser(String username, int rating) {
		
		TypedQuery<User> query = entityManager.createQuery("SELECT c FROM User c WHERE c.username = :username", User.class);
		
		User user = query.setParameter("username", username).getSingleResult();
			
		user.setRating(rating);
			
		entityManager.persist(user);
		
		return user;
	}
	
	//create route
	@Transactional
	public Route modifyRoute(Integer numberOfSeats, String startCity, String endCity, String aDate, String vehicle, String price, long id) {
			
		TypedQuery<Route> query = entityManager.createQuery("SELECT c FROM Route c WHERE c.id = :id", Route.class);
		
		Route route = query.setParameter("id", id).getSingleResult();
		
		route.setStartCity(startCity);
		route.setEndCity(endCity);
		route.setDate(aDate);
		route.setVehicle(vehicle);
		route.setPrice(price);
		int people = 0;
		
		if (route.getPassenger1() != null) {
			people++;
		} if (route.getPassenger2() != null) {
			people++;
		} if (route.getPassenger3() != null) {
			people++;
		} if (route.getPassenger4() != null) {
			people++;
		} if (route.getPassenger5() != null) {
			people++;
		} if (route.getPassenger6() != null) {
			people++;
		}
		
		if (numberOfSeats > people) {
			
			route.setIsAvailable(true);
			route.setAvailableSeats(numberOfSeats - people); 
			
		} 
		
		entityManager.persist(route);
		return route;
	}
	
}