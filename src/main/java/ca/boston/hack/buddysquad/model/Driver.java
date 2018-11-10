//package ca.mcgill.ecse321.ridesharing.model;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//
//import java.util.List;
//import javax.persistence.CascadeType;
//import javax.persistence.OneToMany;
//
//@Entity
//public class Driver extends User{
//	
//private List<Route> route;
//@Id
//@OneToMany(mappedBy = "driver")
//public List<Route> getRoute ()
//{
//return this.route;
//   }
//private Integer rating;
//
//public void setRating(Integer value) {
//   this.rating = value;
//}
//
//public int getRating() {
//   return this.rating;
//}
//
//private List<Route> routes;
//
//@OneToMany(mappedBy="driver1", cascade={CascadeType.ALL})
//public List<Route> getRoutes() {
//   return this.routes;
//}
//
//public void setRoutes(List<Route> routess) {
//   this.routes = routess;
//}
//
//private String email;
//
//public void setEmail(String value) {
//   this.email = value;
//}
//
//public String getEmail() {
//   return this.email;
//}
//
//}
