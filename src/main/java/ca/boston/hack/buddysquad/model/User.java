package ca.mcgill.ecse321.ridesharing.model;

import javax.persistence.*;

@Entity
@Table(name = "participants")
/*
@NamedQueries({
	@NamedQuery(name = "User.findAll", query = "SELECT e FROM participants e")
})
*/
public class User{
private String username;
private String password;
private int rating;


public void setUsername(String value) {
this.username = value;
}

@Id
@Column(name = "username")
public String getUsername() {
return this.username;
}


public void setPassword(String value) {
this.password = value;
    }

@Column(name = "password")
public String getPassword() {
return this.password;
       }


@Column(name = "rating")
public int getRating() {
	return rating;
}


public void setRating(int rating) {
	this.rating = rating;
}
}
