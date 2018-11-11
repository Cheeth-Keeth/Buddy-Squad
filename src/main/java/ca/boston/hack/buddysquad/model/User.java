package ca.boston.hack.buddysquad.model; 

import javax.persistence.*;

@Entity
@Table (name = "Veterans")
public class User {
		
		private String username; 
		private String password;  
		private String fitness; 
		private String learning; 
		private String miscellaneous;
		private boolean fitnessComplete; 
		private boolean learningComplete; 
		private boolean miscellaneousComplete;
		private String messages;
		private long id; 

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
public String getLearning() {
	return this.learning; 
}



public void setMiscellaneous(String miscellaneous) {
	this.miscellaneous= miscellaneous; 
}

@Column(name= "miscellaneous")
public String getMiscellaneous() {
	return this.miscellaneous; 
}

public void messages(String message) {
	this.messages= message; 
}

@Column(name= "messages")
public String getMessages() {
	return this.messages; 
}

public void setFitnessComplete(boolean fitness) {
	this.fitnessComplete = fitness; 
}

@Column(name= "fitnessComplete")
public boolean isFitnessComplete() {
	return this.fitnessComplete; 
}

public void setLearningComplete(boolean learning) {
	this.learningComplete = learning; 
}

@Column(name= "learningComplete")
public boolean isLearningComplete() {
	return this.learningComplete; 
}

public void setMiscellaneousComplete(boolean miscellaneous) {
	this.miscellaneousComplete = miscellaneous; 
}

@Column(name= "miscellaneousComplete")
public boolean isMiscellaneousComplete() {
	return this.miscellaneousComplete; 
}

public void setId(long id) {
	this.id=id; 
}

@Column (name= "groupId")
public long getId(long id) {
	return this.id; 
}
	
}
