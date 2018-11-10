package ca.boston.hack.buddysquad.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "trip")
//@NamedQueries({@NamedQuery(name = "Route.findAll", query = "SELECT e FROM routes e")})
public class Route{

private String driver;
private int availableSeats;
private String startCity;
private String endCity;
private String date;
private boolean isAvailable;
private boolean isComplete;
private String vehicle;
private String price;
private String passenger1;
private String passenger2;
private String passenger3;
private String passenger4;
private String passenger5;
private String passenger6;

//==================================

@Id @GeneratedValue (strategy=GenerationType.AUTO) long id;

public void setId(long id) {
	   this.id = id;
	}

	public long getId() {
	   return this.id;
	}

//==================================

public void setPassenger1(String user) {
	   this.passenger1 = user;
	}

	@Column(name = "passenger1")
	public String getPassenger1() {
	   return this.passenger1;
	}


//==================================

	public void setPassenger2(String user) {
		this.passenger2 = user;
	}

	@Column(name = "passenger2")
	public String getPassenger2() {
		return this.passenger2;
	}


//==================================

	public void setPassenger3(String user) {
		   this.passenger3 = user;
		}

		@Column(name = "passenger3")
		public String getPassenger3() {
		   return this.passenger3;
		}


//==================================

	public void setPassenger5(String user) {
		this.passenger5 = user;
	}

	@Column(name = "passenger5")
	public String getPassenger5() {
		return this.passenger5;
	}

//==================================

	public void setPassenger6(String user) {
		   this.passenger6 = user;
		}

		@Column(name = "passenger6")
		public String getPassenger6() {
		   return this.passenger6;
		}


//==================================
	
	public void setPassenger4(String user) {
		   this.passenger4 = user;
		}

		@Column(name = "passenger4")
		public String getPassenger4() {
		   return this.passenger4;
		}


//==================================	
	
public void setDriver(String driver) {
   this.driver = driver;
}

@Column(name = "driver")
public String getDriver() {
   return this.driver;
}

//==================================

public void setPrice(String price) {
   this.price = price;
}

@Column(name = "price")
public String getPrice() {
   return this.price;
}

//==================================


public void setAvailableSeats(int value) {
   this.availableSeats = value;
}

@Column(name = "seats")
public int getAvailableSeats() {
   return this.availableSeats;
}

//==================================


public void setStartCity(String value) {
   this.startCity = value;
}

@Column(name = "startCity")
public String getStartCity() {
   return this.startCity;
}

//==================================

public void setDate(String value) {
   this.date = value;
}

@Column(name = "date")
public String getDate() {
   return this.date;
}

//==================================

public void setIsAvailable(boolean value) {
   this.isAvailable = value;
}

@Column(name = "isAvailable")
public boolean isIsAvailable() {
   return this.isAvailable;
}

//==================================


public void setIsComplete(boolean value) {
   this.isComplete = value;
}

@Column(name = "isComplete")
public boolean isIsComplete() {
   return this.isComplete;
}

//==================================

public void setVehicle(String value) {
this.vehicle = value;
    }

@Column(name = "vehicle")
public String getVehicle() {
	return this.vehicle;
 }


//==================================

public void setEndCity(String value) {
	this.endCity = value;
}

@Column(name = "endCity")
public String getEndCity() {
	return this.endCity;
}

//==================================

}