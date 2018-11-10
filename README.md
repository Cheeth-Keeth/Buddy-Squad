# t03
## Sprint 1: Backend ## 

To run the program, you must run it as a spring boot application from IntegratedSpringApplication.java inside the ca.mcgill.ecse321.ridesharing package.

Run off of local tomcat server on https://localhost:8080

When the user opens the application, the user will be brought to a main menu. In the main menu, a user can sign-up/sign-in as a driver, a passenger. An admin can view all the data from the database. You will also be able to rate a user.

If the user clicks on the driver button, the user will be brought to the "create driver" page. The user can sign up as a driver. There are three fields to be filled out: Username, Password, Email. Once these fields are filled, the user should click the "Sign in/ Sign up". This will create a driver in the database, and bring you to a page that can allow the driver to create a route. In this page, the user will fill out the following fields: Price, Date, Start and End City, number of seats. Click the "create route" button to add the route to the database. You will then be brought to a page that says "thank you for using the ridesharing app."

If the user clicks on the passenger button, the user will be brought to the "create passenger" page. The user can sign up/sign in as a driver. There are two fields to be filled out: Username and Password. Once these fields are filled, the user should click the "Sign in/ Sign up" button. This will create a passenger in the database, and bring you to a page that can allow the passenger to sign up for a route. In this page, the user will fill out the following fields: Price, Date, Start and End City. Click the "join route" button to add the route to the database. You will then be brought to a page that says "You have succesfully joined the ride."

If the user clicks on the admin button, the user will be brought to a page that can allow the admin to view all the drivers and passengers in the system. The admin does not need to sign up.

If you click the rate user button, it will bring the user to a page where the user can rate a user by filling in the username field, and give it a rating out of 5.

Sprint 2: Android Frontend 
---------------

There was a complete redesign of the backend for sprint 2. Our team was succesfully able to create objects, that we would be able to use for our frontend.

There are two different applications that were made for this sprint: The Driver App and the Passenger App.

When starting both applications, you will be start at a login page, where a user will put in their username and password. After you put in your username and password, please click on the login button to be added to the database. 

Please ignore the continue button in the driver app
------------------------
When drivers click login, they will be faced with 3 buttons they may choose from: Create Route, Rate Passenger, and Route List. 

When drivers go to the create route page, they can create an ad for a journey that they will be taking. They may include the start city, the end city, the price to join the trip, the available seats, the vehicle, and the date that the journey will take place on. After clicking create route, the route will be added to the database, for passengers to join.
When drivers go to the rate passenger page, they may give a passenger a rating out of 5.
Next, a driver can go see all the routes he has. When you click the "Get routes" button, all of the routes he is taking will display on the screen. A driver may end a route here as well by inserting an ID specific to that route. It does not always refresh right away so you may have to go back a page, then go back to the get routes page. After you click the "Get Routes" button, the deleted route will be gone. 

When passengers login, they will be faced with 3 buttons they may choose from: Find Route, Rate Driver, and My Routes.
When passengers go to the find route page, they will be able to search ads for a journey that they will be taking.They will unput the start and end cities in which they wish to travel to, and the date they wish to take the trip. They will then see the routes that meet their needs, and can join whichever one they wish by inserting the route id, and clicking join route. If there are no seats available, they will not be able to join the route. 
A passenger can go to the rate driver page to give a driver a rating out of 5.
Next, a passenger can go see all the routes he has. When you click the "Get routes" button, all of the routes he is a part of will display on the screen. A passenger may leave a route here as well by inserting an ID specific to that route. It does not always refresh right away so you may have to go back a page, then go back to the get routes page. After you click the "Get Routes" button, the route you left should be gone.





>>>>>>> 6b719a6165f685d201a49ceb1634c5c23f362422



