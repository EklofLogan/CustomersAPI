# Customers API
CustomersAPI is a SpringBoot REST api service using an H2 in-memory database to store customer information

## Specifications
Created a table called 'Customer' which contains the following columns
* id(Int auto increment)
* firstName(String)
* lastName(String)
* Email(String)
* Phone number(String)

Exceptions are handled when a duplicate customer is added to the database, or when a customer with an id does not exist.

## Capabilities
Contains functionality for the following features.
* Creating new customers via a post request
* Finding a customer by its id
* Listing all customers in the database
* Deleting a customer by id
