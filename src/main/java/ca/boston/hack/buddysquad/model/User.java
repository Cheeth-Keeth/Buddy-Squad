package ca.boston.hack.buddysquad.model; 

import javax.persistence.*;

@Entity
@Table (name = "Veterans")
public class User {
		
		private String username; 
		private String password; 
		private String health; 
		private String fitness; 
		private String learning; 
		private String mindfulness; 
		private String miscelaneous;
		private String messages;
		

public void setUsername(String username) {
	this.username = username; 
}

@Id 
@Column (name = "username")
public String getUsername() {
	return this.username; 
}

public void setPassword(String pass) {
	this.password = pass; 
}

@Column(name= "password")
public String getPassword() {
	return this.password; 
}

public void setHealth(String health) {
	this.health = health; 
}

@Column(name= "health")
public String getHealth() {
	return this.health; 
}

public void setFitness(String fitness) {
	this.fitness = fitness; 
}

@Column(name= "fitness")
public String getFitness() {
	return this.fitness; 
}

public void setLearning(String learning) {
	this.learning = learning; 
}

@Column(name= "learning")
public String getLeaning() {
	return this.learning; 
}

public void setMindfulness(String mindfulness) {
	this.mindfulness = mindfulness; 
}

@Column(name= "mindfulness")
public String getMindfulness() {
	return this.mindfulness; 
}


public void setMiscelaneous(String miscelaneous) {
	this.miscelaneous= miscelaneous; 
}

@Column(name= "miscelaneous")
public String getMiscelaneous() {
	return this.miscelaneous; 
}

public void messages(String message) {
	this.messages= message; 
}

@Column(name= "messages")
public String getMessages() {
	return this.messages; 
}

	
}
