package ca.boston.hack.buddysquad;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.*;
import org.springframework.boot.test.context.SpringBootTest;

//sprint1
//Tests for our unit functions are done in here.
//These functions include: Adding passengers, Adding drivers, Creating routes, Finding routes and updating User ratings
@SpringBootTest
public class IntegratedSpringApplicationTest{
	
	//Add elements to the database for testing
	@Before
	public void setup()
	{
		
		String url="jdbc:postgresql://ec2-23-23-216-40.compute-1.amazonaws.com:5432/ddp4sc0fffl2n9";
    	String usernameDB= "xhboobjzljpdus";
    	String passwordDB="03d06a487d48508fd9476509db46d2644a17b36fe32be0d2c5d411f8dd5f3226";
    	
    	Connection conn = null;
    	Statement stmt = null;
        ResultSet rs = null;
        
	//Informationg for test passenger 1	
        String tempq = "INSERT INTO users(rating, username, password) VALUES ('";
        
        String tmprate = String.valueOf(5);
        
        String rating = tmprate + "',";
        String user = "\'"+"test" + "\',";
        String pass = "\'"+"password" +"\');";
        
        String query1 = tempq+rating+user+pass;
  	
	//Information for test driver 2
        String tempq2 = "INSERT INTO users(rating, username, password, email) VALUES (";
        
        String rating2 =  "5,";
        String user2 = "\'"+"Benji" + "\',";
        String pass2 = "\'"+"Szwimer" +"\',";
        String email2 = "\'"+"Hi@mail.com" +"\');";
        
        String query2 = tempq2+rating2+user2+pass2+email2;
        
		
	//Information for test destination 3
        String price = "200" + ",";
        String date ="'" +"2018-01-01" + "',";
        String startCity = "\'"+"Montreal" +"\',";
        String endCity = "\'"+"Mars" +"\',";
        String numSeats = "4"+");";
        String isAvailable =  "TRUE,";
        String isDriver = "TRUE,";
        String ID_users = "2,";
        
        String query3 = tempq+ID_users+price+startCity+endCity+isAvailable+isDriver+date+numSeats;
        
		
	//Information for test driver 4
        String tempq4 = "INSERT INTO users(rating, username, password, email) VALUES (";
        
        String rating4 =  "4,";
        String user4 = "\'"+"Ethan" + "\',";
        String pass4 = "\'"+"Itovitch" +"\',";
        String email4 = "\'"+"Eth@mail.com" +"\');";
        
        String query4 = tempq4+rating4+user4+pass4+email4;
        
        
        try {
			conn = DriverManager.getConnection(url, usernameDB, passwordDB);
		} catch (SQLException e1) {
	
			e1.printStackTrace();
		}
        
        try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
        try {
			//Adding all test cases to the database
			rs = stmt.executeQuery(query1);
			rs = stmt.executeQuery(query2);
			rs = stmt.executeQuery(query3);
			rs = stmt.executeQuery(query4);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	//Test if passenger was properly added to the database
	@Test
	public void testSignUpPassenger(){
		String url="jdbc:postgresql://ec2-23-23-216-40.compute-1.amazonaws.com:5432/ddp4sc0fffl2n9";
    	String usernameDB= "xhboobjzljpdus";
    	String passwordDB="03d06a487d48508fd9476509db46d2644a17b36fe32be0d2c5d411f8dd5f3226";
		int rating; 
		String username; 
		String password; 
	 	Connection conn = null;
    	Statement stmt = null;
        ResultSet rs = null;
		String tempq = "select * from users WHERE username like 'test'; ";
		
		
		 try {
			conn = DriverManager.getConnection(url, usernameDB, passwordDB);
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	        try {
				stmt = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
			//Retrive infomation from the database 
	        	rs = stmt.executeQuery(tempq);
			
		        rating = rs.getInt("rating");
		        
		        username =rs.getString("username");

		        password =rs.getString("password");
		 
		        //Assert that information was properly stored
		        assertEquals(5, rating);
		        assertEquals("test", username);
		        assertEquals("password", password);
		
	        }
	        
	        catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	        }
	        
	        
	       
	}
	
	//Test if driver was properly added to the databse
	@Test
	public void testSignUpDriver(){
		String url="jdbc:postgresql://ec2-23-23-216-40.compute-1.amazonaws.com:5432/ddp4sc0fffl2n9";
    	String usernameDB= "xhboobjzljpdus";
    	String passwordDB="03d06a487d48508fd9476509db46d2644a17b36fe32be0d2c5d411f8dd5f3226";
		int rating; 
		String username; 
		String password;
		String email;
	 	Connection conn = null;
    	Statement stmt = null;
        ResultSet rs = null;
		String tempq = "select * from users WHERE username like 'test'; ";
		
		
		 try {
			conn = DriverManager.getConnection(url, usernameDB, passwordDB);
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	        try {
				stmt = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
	        	
			//Retrive infomation from the database 
	        	rs = stmt.executeQuery(tempq);
		        rating = rs.getInt("rating");
		        username =rs.getString("username");
		        password =rs.getString("password");
		        email =rs.getString("email");
		        
			//Assert that information was properly stored
		        assertEquals(5, rating);
		        assertEquals("Benji", username);
		        assertEquals("Szwimer", password);
		        assertEquals("Hi@mail.com", password);
		
	        }
	        
	        catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	        }
	        
	        
	       
	}
	
	//Test if route was properly added to the databse and verify that call for finding routes retrives the data
	@Test
	public void testCreateRouteFindRoute(){
		String url="jdbc:postgresql://ec2-23-23-216-40.compute-1.amazonaws.com:5432/ddp4sc0fffl2n9";
    	String usernameDB= "xhboobjzljpdus";
    	String passwordDB="03d06a487d48508fd9476509db46d2644a17b36fe32be0d2c5d411f8dd5f3226";
		int price; 
		Date date; 
		String startCity;
		String endCity;
		int numSeats;
		boolean isAvailable;
		boolean isDriver;
	 	Connection conn = null;
    	Statement stmt = null;
        ResultSet rs = null;
		String tempqSE = "select * from users WHERE username like 'test'; ";
		
		
		 try {
			conn = DriverManager.getConnection(url, usernameDB, passwordDB);
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	        try {
				stmt = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
	        	
	        	
	        	
			//Retrive infomation from the database 
	        	rs = stmt.executeQuery(tempqSE);
		        price = rs.getInt("price");
		        date =rs.getDate("date");
		        startCity =rs.getString("startcity");
		        endCity =rs.getString("endcity");
		        numSeats =rs.getInt("numofseats");
		        isAvailable = rs.getBoolean("isdriver");
		        isDriver = rs.getBoolean("isavailable");
		        
			//Assert that information was properly stored
		        assertEquals(200, price);
		        assertEquals("2018-01-01", date);
		        assertEquals("Montreal", startCity);
		        assertEquals("Mars", endCity);
		        assertEquals(4, numSeats);
		        assertEquals(true, isAvailable);
		        assertEquals(true, isDriver);
		
	        }
	        
	        catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	        }
	        
	        
	       
	}
	
	
	//Test if a passengers rating can be updated
	@Test
	public void testRateDriver(){
		String url="jdbc:postgresql://ec2-23-23-216-40.compute-1.amazonaws.com:5432/ddp4sc0fffl2n9";
    	String usernameDB= "xhboobjzljpdus";
    	String passwordDB="03d06a487d48508fd9476509db46d2644a17b36fe32be0d2c5d411f8dd5f3226";
		int rating;
	 	Connection conn = null;
    	Statement stmt = null;
        ResultSet rs = null;
	//call to update infomration in the database
        String tempqUP = "UPDATE users SET rating="+"5"+" WHERE username like '"+"Ethan"+"';";
		String tempqSE = "select * from users WHERE username like 'Ethan'; ";
		
		
		 try {
			conn = DriverManager.getConnection(url, usernameDB, passwordDB);
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	        try {
				stmt = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
			
			//update data and retive information from the databse
	        	rs = stmt.executeQuery(tempqUP);
	        	rs = stmt.executeQuery(tempqSE);
		        rating = rs.getInt("rating");
		        
			//Assert that the rating was properly changed
		        assertEquals(5, rating);
		
	        }
	        
	        catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	        }
	        
	        
	       
	}
	
	//delete the data that was inserted into the database to be tested
	@After
	public void cleanUp() {
		
		String url="jdbc:postgresql://ec2-23-23-216-40.compute-1.amazonaws.com:5432/ddp4sc0fffl2n9";
    	String usernameDB= "xhboobjzljpdus";
    	String passwordDB="03d06a487d48508fd9476509db46d2644a17b36fe32be0d2c5d411f8dd5f3226";
    	Connection conn = null;
    	Statement stmt = null;
        ResultSet rs = null;
        String tempqUP1 = "DELETE FROM users WHERE username = test;";
        String tempqUP2 = "DELETE FROM users WHERE username = Benji;";
        String tempqUP3 = "DELETE FROM users WHERE username = Ethan;";
        String tempqUP4 = "DELETE FROM destination WHERE endcity = Mars;";
        
        
        try {
			conn = DriverManager.getConnection(url, usernameDB, passwordDB);
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	        try {
				stmt = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {

	        	rs = stmt.executeQuery(tempqUP1);
	        	rs = stmt.executeQuery(tempqUP2);
	        	rs = stmt.executeQuery(tempqUP3);
	        	rs = stmt.executeQuery(tempqUP4);
		
	        }
	        
	        catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	        }
		
	}
	

}
