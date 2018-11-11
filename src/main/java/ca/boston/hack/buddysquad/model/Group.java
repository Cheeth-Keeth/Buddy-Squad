package ca.boston.hack.buddysquad.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "group")
//@NamedQueries({@NamedQuery(name = "Route.findAll", query = "SELECT e FROM routes e")})
public class Group{

private int availableSpots;
private String fitness;
private String learning;
private String miscellaneous;
private String name;

//==================================

@Id @GeneratedValue (strategy=GenerationType.AUTO) long id;

public void setId(long id) {
	   this.id = id;
	}

	public long getId() {
	   return this.id;
	}

//==================================


public void setAvailableSpots(int value) {
   this.availableSpots = value;
}

@Column(name = "spots")
public int getAvailableSeats() {
   return this.availableSpots;
}

//==================================
	
	public void setFitness(String fitness) {
		   this.fitness = fitness;
		}

		@Column(name = "fitness")
		public String getFitness() {
		   return this.fitness;
		}
		
//==================================
		
	public void setLearnign(String learning) {
			this.learning = learning;
		}

		@Column(name = "learning")
		public String getLearning() {
			return this.learning;
		}
		
//==================================
		
		public void setMiscellaneous(String miscellaneous) {
			this.miscellaneous = miscellaneous;
		}

		@Column(name = "miscellaneous")
		public String getMiscellaneous() {
			return this.miscellaneous;
		}	

//==================================
		
		public void setName(String name) {
			this.name = name;
		}

		@Column(name = "name")
		public String getName() {
			return this.name;
		}		

}