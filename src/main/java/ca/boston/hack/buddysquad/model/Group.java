package ca.boston.hack.buddysquad.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "group")
//@NamedQueries({@NamedQuery(name = "Route.findAll", query = "SELECT e FROM routes e")})
public class Group{

private int availableSpots;
private String user1;
private String user2;
private String user3;
private ArrayList<User> activity1users;
private ArrayList<User> activity2users;
private ArrayList<User> activity3users;
private String activity1;
private String activity2;
private String activity3;

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


public void setUser1(String user1) {
   this.user1 = user1;
}

@Column(name = "user1")
public String getUser1() {
   return this.user1;
}

//==================================

public void setUser2(String user2) {
	   this.user2 = user2;
	}

	@Column(name = "user2")
	public String getUser2() {
	   return this.user2;
	}

//==================================

	public void setUser3(String user3) {
		   this.user3 = user3;
		}

		@Column(name = "user3")
		public String getUser3() {
		   return this.user3;
		}

//==================================


public void setActivity1user(User user) {
   this.activity1users.add(user);
}

public void addActivity1user(User user) {
	
	this.activity1users.add(user);
	
}

@Column(name = "activity1users")
public ArrayList<User> getActivity1users() {
   return this.activity1users;
}

//==================================

public void setActivity2user(User user) {
	   this.activity2users.add(user);
	}

	public void addActivity2user(User user) {
		
		this.activity2users.add(user);
		
	}

	@Column(name = "activity2users")
	public ArrayList<User> getActivity2users() {
	   return this.activity2users;
	}


//==================================

public void setActivity3user(User user) {
		this.activity3users.add(user);
	}

	public void addActivity3user(User user) {
			
		this.activity3users.add(user);
			
	}

	@Column(name = "activity3users")
	public ArrayList<User> getActivity3users() {
		return this.activity3users;
	}

//==================================
	
	public void setActivity1(String activity1) {
		   this.activity1 = activity1;
		}

		@Column(name = "activity1")
		public String getActivity1() {
		   return this.activity1;
		}
		
//==================================
		
	public void setActivity22(String activity2) {
			this.activity2 = activity2;
		}

		@Column(name = "activity2")
		public String getActivity2() {
			return this.activity2;
		}
		
//==================================
		
		public void setActivity3(String activity3) {
			this.activity3 = activity3;
		}

		@Column(name = "activity3")
		public String getActivity3() {
			return this.activity3;
		}		

}