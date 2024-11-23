# Individual task
- Using ```java servlet```, ```jsp``` technologies, implement a web application on the chosen topic
- The application should contain a registration page, an authorisation page and information pages on the selected topic. 
- On the information pages, it is necessary to use dynamic content using ```JSP``` and/or ```EL``` components
- ```Java Bean``` and ```custom tag``` are required
- Connect a ```databas```e to your own web project
- Implement basic data manipulation operations (```create```, ```update```, ```insert```, ```delete```)
- Add ```Java Filters``` to the web project, implement ```authorisation checking```, ```session validation```, checking the need for a ```database connection```

# Topic of web application
Shop for swimming products. 

# The work is done:
- ```AuthoFilter``` - authorisation filter and session validation
- ```DeleteProductServlet``` - a servlet for deleting a product
- ```EditProductServlet``` - servlet for editing a product
- ```FilterDB``` - database connection filter
- ```LoginServlet``` - servlet for user login
- ```LogoutServlet``` - servlet for logging the user out of the system
- ```Product``` - Java Bean for products
- ```ProductDB``` - connection of products with databases (their operations)
- ```ProductListTag``` - custom tag for displaying a list of products
- ```ProductServlet``` - a servlet for processing requests related to products
- ```RegisterServlet``` - a servlet for registering a user in the system
- ```User``` - Java Bean for users
- ```UserDB``` - connection of users with databases (their operations)
- ```productsTags.tld``` - describes custom tags for use in JSP pages
- ```web.xml``` & ```pom.xml``` - configuration files
- ```JSP pages``` - main page for editing & deleting products, login and registration, for displaying all products
