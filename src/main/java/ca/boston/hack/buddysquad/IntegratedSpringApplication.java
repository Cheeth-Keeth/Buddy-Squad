package ca.boston.hack.buddysquad;
//package ca.mcgill.ecse321.ridesharing;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
//import org.springframework.boot.autoconfigure.jms.JndiConnectionFactoryAutoConfiguration;
//import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//test
//@EntityScan("ca.mcgill.ecse321.model")
//(scanBasePackages = {"ca.mcgill.ecse321.ridesharing.controller", "ca.mcgill.ecse321.ridesharing.model","ca.mcgill.ecse321.ridesharing.repository"})
@SpringBootApplication
public class IntegratedSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegratedSpringApplication.class, args);
	}
}

//
//
//@EnableAutoConfiguration(exclude = {JndiConnectionFactoryAutoConfiguration.class,DataSourceAutoConfiguration.class,
//        HibernateJpaAutoConfiguration.class,JpaRepositoriesAutoConfiguration.class,DataSourceTransactionManagerAutoConfiguration.class})
//
//@RestController
//public class IntegratedSpringApplication extends SpringBootServletInitializer{
//	
//
// 
//     @Override
//        protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//            return application.sources(IntegratedSpringApplication.class);
//        }
// 
//     
//    public static void main(String[] args) {
//    	
//        SpringApplication.run(IntegratedSpringApplication.class, args);
//        
//       
//    	}
//     
//    /*
//     * This is the main menu
//     * Here the user will be able to become a passenger, user, admin or rate driver
//     */
//    @RequestMapping("/")
//	public String greeting() {
//		return "<h1>Welcome to the ride sharing app!</h1>"
//				+ "<input type=\"submit\" value=\"I'm a passenger\" \n" + 
//				"    onclick=\"window.location='/PassSignUp'\" /> "
//				+ "<input type=\"submit\" value=\"I'm an admin\" \n" + 
//				"    onclick=\"window.location='/admin'\" /> "
//				+ "<input type=\"submit\" value=\"I'm a driver\" \n" + 
//				"    onclick=\"window.location='/driver/'\" /> "
//				+ "<input type=\"submit\" value=\"Rate user\" \n" + 
//				"    onclick=\"window.location='/rateDriver/'\" /> ";
//				}
//    
//    //if you have admin access, this endpoint will allow you to see a list of usernames, passwords,ratings,email
//    @RequestMapping("/admin")
//    public String showData() {
//    	String ret = showDataAdmin();
//    	return 	ret;
//    }
//    
//    /*
//     * endpoint for creating a passenger along with their sign up information
//     */
//    @RequestMapping("/PassSignUp")
//    public String passSignUp() {
//    	
//    	return 	
//    			
//    			
//    			"<form action=\"http://localhost:8080/PassSignUp/Destination\" method=\"get\">\n" + 
//    			"  <div>\n" + 
//    			"    <label for=\"username\">Username</label>\n" + 
//    			"    <input name=\"username\" id=\"username\" value=\"\">\n" + 
//    			"  </div>\n" + 
//    			"  <div>\n" + 
//    			"    <label for=\"password\">Password</label>\n" + 
//    			"    <input name=\"password\" id=\"password\" value=\"\">\n" + 
//    			"  </div>\n" + 
//    			"  <div>\n" + 
//    			"    <button>Sign in/Sign up</button>\n" + 
//    			"  </div>\n" + 
//    			"</form>";
//    			
//  
//    	
//
//    	
//    }
//    
//    /*
//     * This endpoint will allow you to rate a user on a scale from 1-5
//     */
//    
//    @RequestMapping("/rateDriver")
//    @ResponseBody
//    public String updateRating() {
//        return "<form action=\"http://localhost:8080/rateDriver/success\" method=\"get\">\n"+
//            	"<label for=\"user\">Username </label>\n"+
//          	  "<input name=\"user\" id=\"euser\">\n"+
//          	"<label for=\"rating\">Rating out of 5 </label>\n"+
//          	"<input name=\"rating\" id=\"rating\" list=\"ratings\"></br>\n"+
//          	 "<datalist id=\"ratings\">\n"+
//     	    "<option value=\"1\">\n"+
//     	    "<option value=\"2\">\n"+
//     	    "<option value=\"3\">\n"+
//     	    "<option value=\"4\">\n"+
//     	    "<option value=\"5\">\n"+
//     	    "</datalist>\n"+
//     	    "</br>"+  	
//          	
//        	  "<input type=\"submit\">\n"+
//        	"</form>";
//    }
//    
//    
// // endpoint updates a user's rating 
//    
//    @RequestMapping("/rateDriver/{success}")
//    @ResponseBody
//    public String success(@RequestParam(value="user", required=true) String param1,@RequestParam(value="rating", required=true) int param2) {
//    	
//    	String message = rateDriver(param1,param2);
//        return "<h1>"+message+"</h1>";
//    }
//
//    //endpoint allows a passenger to join a route
//    @RequestMapping("/PassSignUp/{Destination}")
//    public String getDetails(@RequestParam(value="username", required=true) String param1,@RequestParam(value="password", required=false) String param2){
//		String status = insertInDB(5, param1, param2);
//    	return "<h1>Username:"+ param1 + " </h1>\n"+
//				"<h2> Find a Route </h2>" + 
//    
//"<form action=\"http://localhost:8080/PassSignUp/Destination/FindRoute\" method=\"get\">\n"+
//    	"<label for=\"cityfrom\">From City</label>\n"+
//    	  "<input name=\"cityfrom\" id=\"cityfrom\" list=\"cities\">\n"+
//    	  "<label for=\"cityto\">To City</label>\n"+
//      	  "<input name=\"cityto\" id=\"cityto\" list=\"cities\"></br>\n"+
//      	  "Date:\n" + 
//      	  "  <input type=\"date\" name=\"date\">\n" +
//    	  "<datalist id=\"cities\">\n"+
//    	    "<option value=\"Montreal\">\n"+
//    	    "<option value=\"Winnipeg\">\n"+
//    	    "<option value=\"Hamilton\">\n"+
//    	    "<option value=\"Quebec City\">\n"+
//    	    "<option value=\"Ottawa\">\n"+
//    	    "<option value=\"Edmonton\">\n"+
//    	    "<option value=\"Toronto\">\n"+
//    	    "<option value=\"Kingston\">\n"+
//    	    "<option value=\"London\">\n"+
//    	    "<option value=\"Haliburton\">\n"+   
//    	    "</datalist>\n"+
//    	    "</br>"+  	    
//  	  "<input type=\"submit\">\n"+
//  	"</form>";
//    	    
//      	
//    	}
//    
//    //this endpoints displays all the routes that match requested route
//    @RequestMapping("/PassSignUp/Destination/{FindRoute}")
//    public String getRoute(@RequestParam(value="cityfrom", required=true) String param1,@RequestParam(value="cityto", required=true) String param2,@RequestParam(value="date", required=true) String param3){
//		String status = queryForRide(param1, param2,param3);
//    	return "<h1>To:"+ param1 + " </h1>\n"+
//		"<h1>From: "+param2+"</h1>"+
//		"<h1>Date: "+param3+"</h1>"+
//		"<h1>"+status+"</h1>";
//    }
//    
//    
// // this method inserts the rating, username, and password into the user's table in the database
//    public String insertInDB(int _rating, String _user, String _pass)
//    {
//    	String url="jdbc:postgresql://ec2-23-23-216-40.compute-1.amazonaws.com:5432/ddp4sc0fffl2n9";
//    	String username= "xhboobjzljpdus";
//    	String password="03d06a487d48508fd9476509db46d2644a17b36fe32be0d2c5d411f8dd5f3226";
//    	
//    	Connection conn = null;
//    	Statement stmt = null;
//        ResultSet rs = null;
//        
//        String tempq = "INSERT INTO users(rating, username, password) VALUES ('";
//            
//        String tmprate = String.valueOf(_rating);
//        
//        String rating = tmprate + "',";
//        String user = "\'"+_user + "\',";
//        String pass = "\'"+_pass +"\');";
//        
//        
//        
//        String query = tempq+rating+user+pass;
//        System.out.println(query);
//        
//        try {
//			conn = DriverManager.getConnection(url, username, password);
//		} catch (SQLException e1) {
//		
//			e1.printStackTrace();
//		}
//        
//        try {
//			stmt = conn.createStatement();
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//        try {
//			rs = stmt.executeQuery(query);
//		} catch (SQLException e) {
//		
//			e.printStackTrace();
//		}
//    	return "Success";
//    }
//  
//    
////queries the database for matching routes
//    
//  public String queryForRide(String _From, String _To, String _Date)
//    {
//    	String url="jdbc:postgresql://ec2-23-23-216-40.compute-1.amazonaws.com:5432/ddp4sc0fffl2n9";
//    	String username= "xhboobjzljpdus";
//    	String password="03d06a487d48508fd9476509db46d2644a17b36fe32be0d2c5d411f8dd5f3226";
//    	
//    	Connection conn = null;
//    	Statement stmt = null;
//        ResultSet rs = null;
//        int count = 0;
//        
//        String tempq = "select * from destination where date = '"+_Date+"'"
//        		+ " and startcity = '"+_From+"'"
//        				+ " and endcity = '"+_To+"'"
//        						+ " and isavailable = TRUE and isdriver=TRUE;";
//        System.out.println(tempq);
//            
//        String returnMe =""; 
//        String returnMeMe="";
//        try {
//			conn = DriverManager.getConnection(url, username, password);
//		} catch (SQLException e1) {
//			
//			e1.printStackTrace();
//		}
//        
//        try {
//			stmt = conn.createStatement();
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//        try {
//			
//        	rs = stmt.executeQuery(tempq);
//        	
//        	while (rs.next()) {
//        		int userid = rs.getInt("id_users");
//        		int price = rs.getInt("price");
//        		String start = rs.getString("startcity");
//        		String end = rs.getString("endcity");
//        		boolean avail = rs.getBoolean("isavailable");
//        		boolean driver = rs.getBoolean("isdriver");
//        		String date = rs.getString("date");
//        		int seats = rs.getInt("numofseats");
//        		
//        		count++;
//        		
//        			returnMeMe = returnMeMe + "<form action=\"http://localhost:8080//PassSignUp/Destination/FindRoute/Success\" method=\"get\"><h4><label for=\"price\" id=\"price\">Price:</label> "+String.valueOf(price) + "</br>\n"+
//            				"<label for=\"startcity\" id=\"startcity\">From:</label> "+ String.valueOf(start) +"</br>\n"+
//            				"<label for=\"endcity\" id=\"endcity\">To:</label>  "+ String.valueOf(end) +"</br>\n"+
//            				"<label for=\"date\" id=\"date\">Date:</label>"+ String.valueOf(date) +"</br>\n"+
//            				"<label for=\"numofseats\" id=\"numofseats\">Number of Seats:</label>"+ String.valueOf(seats) +"</h4><input type=\"submit\" value=\"Book Me!\" onclick=\"window.location='/PassSignUp/Destination/FindRoute/Success'\" /></form> \n";
//                    
//        		
//        		
//            }
//        	
//        	
//        	
//		} catch (SQLException e) {
//		
//			e.printStackTrace();
//		}
//        
//        
//        System.out.println(returnMe);
//    	return "there were " + count + " rides found\n" + returnMeMe;
//    }
//    @RequestMapping("/driver")
//    
////this signs the driver up for the application
//public String driverSignUp() {
//    	
//    	return 	
//   			
//    			
//    			"<form action=\"http://localhost:8080/driver/Destination\" method=\"get\">\n" + 
//    			"  <div>\n" + 
//    			"    <label for=\"username\">Username</label>\n" + 
//    			"    <input name=\"username\" id=\"username\" value=\"\">\n" + 
//    			"  </div>\n" + 
//    			"  <div>\n" + 
//    			"    <label for=\"password\">Password</label>\n" + 
//    			"    <input name=\"password\" id=\"password\" value=\"\">\n" + 
//    			"  </div>\n" +
//    			"  <div>\n" + 
//    			"    <label for=\"email\">Email</label>\n" + 
//    			"    <input name=\"email\" id=\"email\" value=\"\">\n" + 
//    			"  </div>\n" +
//    			"  <div>\n" + 
//    			"    <button>Sign in/Sign up</button>\n" + 
//    			"  </div>\n" + 
//    			"</form>";
//    	
//    }
//    
//    //Adds driver to the database and sends the user to the destination end point to create a route
//    @RequestMapping("/driver/{param1}/{param2}")
//    public User getDriverDetails(@RequestParam(value="username", required=true) String param1,@RequestParam(value="password", required=false) String param2, @RequestParam(value="email", required=true) String param3){
//    	
//    	User theUser = new User(5, param1, param2);
//    	
//    	String url="jdbc:postgresql://ec2-23-23-216-40.compute-1.amazonaws.com:5432/ddp4sc0fffl2n9";
//    	String username= "xhboobjzljpdus";
//    	String password="03d06a487d48508fd9476509db46d2644a17b36fe32be0d2c5d411f8dd5f3226";
//    	
//    	Connection conn = null;
//    	Statement stmt = null;
//        ResultSet rs = null;
//        
//        String tempq = "INSERT INTO users(rating, username, password, email) VALUES (";
//        
//        String rating =  "5,";
//        String user = "\'"+param1 + "\',";
//        String pass = "\'"+param2 +"\',";
//        String email = "\'"+param3 +"\');";
//        
//        
//        
//        String query = tempq+rating+user+pass+email;
//        System.out.println(query);
//        
//        try {
//			conn = DriverManager.getConnection(url, username, password);
//		} catch (SQLException e1) {
//			
//			e1.printStackTrace();
//		}
//        
//        try {
//			stmt = conn.createStatement();
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//        try {
//			rs = stmt.executeQuery(query);
//		} catch (SQLException e) {
//		
//			e.printStackTrace();
//		}
//    	return theUser;
//    			/*"<form action=\"http://localhost:8080/driver/Destination/MakeANew\" method=\"get\">\n" + 
//				"  <div>\n" + 
//				"    <label for=\"price\">Price</label>\n" + 
//				"    <input name=\"price\" id=\"price\" value=\"\">\n" + 
//				"  </div>\n" + 
//				"  <div>\n" + 
//				"    <label for=\"date\">Date</label>\n" + 
//				"  <input type=\"date\" name=\"date\">\n" +
//				"  </div>\n" +
//				"  <div>\n" + 
//				"    <label for=\"startcity\">Start City</label>\n" + 
//				"	<input name=\"startcity\" id=\"startcity\" list=\"cities\"></br>\n"+
//				"  </div>\n" +
//				"  <div>\n" + 
//				"    <label for=\"endcity\">End City</label>\n" + 
//				"	<input name=\"endcity\" id=\"endcity\" list=\"cities\"></br>\n"+ 
//				 "<datalist id=\"cities\">\n"+
//		    	    "<option value=\"Montreal\">\n"+
//		    	    "<option value=\"Winnipeg\">\n"+
//		    	    "<option value=\"Hamilton\">\n"+
//		    	    "<option value=\"Quebec City\">\n"+
//		    	    "<option value=\"Ottawa\">\n"+
//		    	    "<option value=\"Edmonton\">\n"+
//		    	    "<option value=\"Toronto\">\n"+
//		    	    "<option value=\"Kingston\">\n"+
//		    	    "<option value=\"London\">\n"+
//		    	    "<option value=\"Haliburton\">\n"+   
//		    	    "</datalist>\n"+
//		    	    "</br>"+  	   
//				"  </div>\n" +
//				"  <div>\n" + 
//				"    <label for=\"numofseats\">Number of Seats</label>\n" + 
//				"    <input name=\"numofseats\" id=\"numofseats\" value=\"\">\n" + 
//				"  </div>\n" +
//				"  <div>\n" + 
//				"    <button>Create Route</button>\n" + 
//				"  </div>\n" + 
//				"</form>";
//				*/
//    	}
//    
//    
//    //Adds destination to the database and directs to the thank you endpoint
//    @RequestMapping("/driver/Destination/{MakeANew}")
//    public String getRouteDetails(@RequestParam(value="price", required=true) String param1,@RequestParam(value="date", required=true) String param2, @RequestParam(value="startcity", required=true) String param3, @RequestParam(value="endcity", required=true) String param4, @RequestParam(value="numofseats", required=true) String param5){
//    	String url="jdbc:postgresql://ec2-23-23-216-40.compute-1.amazonaws.com:5432/ddp4sc0fffl2n9";
//    	String username= "xhboobjzljpdus";
//    	String password="03d06a487d48508fd9476509db46d2644a17b36fe32be0d2c5d411f8dd5f3226";
//    	
//    	Connection conn = null;
//    	Statement stmt = null;
//        ResultSet rs = null;
//        
//        String tempq = "INSERT INTO destination(id_users, price, startcity, endcity, isavailable, isdriver, date, numofseats) VALUES (";
//        
//        String price = param1 + ",";
//        String date ="'" +param2 + "',";
//        String startCity = "\'"+param3 +"\',";
//        String endCity = "\'"+param4 +"\',";
//        String numSeats = param5 +");";
//        String isAvailable =  "TRUE,";
//        String isDriver = "TRUE,";
//        String ID_users = "2,";
//        
//        
//        String query = tempq+ID_users+price+startCity+endCity+isAvailable+isDriver+date+numSeats;
//        System.out.println(query);
//        
//        try {
//			conn = DriverManager.getConnection(url, username, password);
//		} catch (SQLException e1) {
//		
//			e1.printStackTrace();
//		}
//        
//        try {
//			stmt = conn.createStatement();
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//        try {
//			rs = stmt.executeQuery(query);
//		} catch (SQLException e) {
//		
//			e.printStackTrace();
//		}
//    	
//      
//        return "<h1>Thank you for using the ride sharing app, your route has been created!</h1>";
//    
//    
//    }
//
//    //Success endpoint reached after user selects a route
//    @RequestMapping("/PassSignUp/Destination/FindRoute/{Success}")
//	public String updateSeats() {
//    	
//		return "<h1>Update Success!</h1>";
//				}
//    
//    //End point for updating a drivers rating after trip
//    public String rateDriver(@RequestParam(value="username", required=true) String param1,@RequestParam(value="rating", required=true) int param2){
//    	String url="jdbc:postgresql://ec2-23-23-216-40.compute-1.amazonaws.com:5432/ddp4sc0fffl2n9";
//    	String username= "xhboobjzljpdus";
//    	String password="03d06a487d48508fd9476509db46d2644a17b36fe32be0d2c5d411f8dd5f3226";
//    	
//    	Connection conn = null;
//    	Statement stmt = null;
//        ResultSet rs = null;
//        
//        String tempq = "UPDATE users SET rating="+param2+" WHERE username like '"+param1+"';";
//            
//        String query = tempq;
//        System.out.println(query);
//        
//        try {
//			conn = DriverManager.getConnection(url, username, password);
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//        
//        try {
//			stmt = conn.createStatement();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        try {
//			rs = stmt.executeQuery(query);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	return 
//		    	"Update Success";
//    	
//    	}
//    
//    //books a passenger to a seat in a route
//    public String bookSeat(@RequestParam(value="username", required=true) String param1,@RequestParam(value="rating", required=true) int param2){
//    	String url="jdbc:postgresql://ec2-23-23-216-40.compute-1.amazonaws.com:5432/ddp4sc0fffl2n9";
//    	String username= "xhboobjzljpdus";
//    	String password="03d06a487d48508fd9476509db46d2644a17b36fe32be0d2c5d411f8dd5f3226";
//    	
//    	Connection conn = null;
//    	Statement stmt = null;
//        ResultSet rs = null;
//        
//        String tempq = "UPDATE users SET rating="+param2+" WHERE username like '"+param1+"';";
//            
//       
//       
//        
//        
//        
//        String query = tempq;
//        System.out.println(query);
//        
//        try {
//			conn = DriverManager.getConnection(url, username, password);
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//        
//        try {
//			stmt = conn.createStatement();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        try {
//			rs = stmt.executeQuery(query);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	return 
//		    	"Update Success";
//    	
//    	}
//    
//    //This endpoitn displays all the suers to the admin
//    public String showDataAdmin()
//    {
//    	String url="jdbc:postgresql://ec2-23-23-216-40.compute-1.amazonaws.com:5432/ddp4sc0fffl2n9";
//    	String username= "xhboobjzljpdus";
//    	String password="03d06a487d48508fd9476509db46d2644a17b36fe32be0d2c5d411f8dd5f3226";
//    	
//    	Connection conn = null;
//    	Statement stmt = null;
//        ResultSet rs = null;
//        
//        String tempq = "select * from users;";
//        System.out.println(tempq);
//            
////        String tmprate = String.valueOf(_rating);
////        
////        String rating = tmprate + "',";
////        String user = "\'"+_user + "\',";
////        String pass = "\'"+_pass +"\');";
////        
////        
////        
////        String query = tempq+rating+user+pass;
//        //System.out.println(query);
//        String returnMe =""; 
//        String returnMeMe="";
//       
//        try {
//			conn = DriverManager.getConnection(url, username, password);
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//        
//        try {
//			stmt = conn.createStatement();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        try {
//			//rs = stmt.executeQuery(query);
//        	rs = stmt.executeQuery(tempq);
//        	while (rs.next()) {
//        		int userid = rs.getInt("id");
//        		int price = rs.getInt("rating");
//        		String start = rs.getString("username");
//        		String end = rs.getString("password");
//        		String avail = rs.getString("email");
//        		
//        		returnMe= String.valueOf(userid) +"		"+ String.valueOf(price) + "	"+
//        				String.valueOf(start) + "	 "+String.valueOf(end) + "	 "+String.valueOf(avail) + "	 ";
//        			
//        		returnMeMe = returnMeMe + "<h4>"+userid+"	"+price+"	"+start+"	"+end+"	"+avail+"</h4></br>";
//        										
//                
//            }
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        
//        
//        //System.out.println(returnMe);
//    	return "ID	Rating	User	Password	Email\n"+returnMeMe;
//    }
//}
