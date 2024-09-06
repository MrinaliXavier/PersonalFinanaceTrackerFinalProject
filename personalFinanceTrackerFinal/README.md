
# Personal Finance Tracker

This project is for all individuals willing to maintain their transaction records. This Application can keep a record of the user's income and expenses. It keeps track of transaction details like date, amount, description and category; according to that,it can calculate each month's total expenses and income. This record can be edited or deleted by the user if necessary. The categories are editable, too. This means that our Application does not suggest it The user can create their own category to their favour.The total income, expense and the final balance will appear in the dashboard for the user to see easily. Using the categories, the Application can also show which category the user spends more money on.  



## Set Up
Start a new Spring Boot project using Spring Initializr.

dependencies: Spring Web, Spring Data JPA, Thymeleaf, Spring
Validation, and MYSQL. 
## Features

User Profile Management:
Create user profiles.
Store user information like name, email, and password.

Transaction Management:
Add, update, and delete transactions.
Transactions contain details such as amount, description, date, transactions type and category.

Category Management:
Users can create, update, and delete categories  to organize their transactions.

View Transaction History:
List all transactions with their associated categories and amounts.

View dashboard:
According to the transaction data, the system calculates the total income and expenses to display the overall balance on the dashboard.

Filter by Category/Date:
Filter transactions by category or date to view specific spending patterns.

Data Persistence:
Transactions, user profiles, and categories are persisted using a database using MySQL

Exception Handling:
The application handles common errors such as user not found, invalid data input, etc.


## Running the Application
Use mvn spring-boot:run to start the application.

## User guide
Log in to the system using your email address and password.

There is a registration button if you don't have a login near the login. Once you register, you can get into the application straight.

In the application, u can see the dashboard, which shows total incomes and expenses. And the total balance.

 You can get directed to the transaction and category pages using navigation.

The transaction page has the option to add, update, and delete a transaction. You can get a drop-down of categories you created on the category page.

The category page has the same features as the transaction page for updating, deleting, and adding categories.