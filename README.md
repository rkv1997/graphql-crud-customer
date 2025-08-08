# GraphQL Spring Boot Demo

This is a simple demo application that demonstrates how to use **GraphQL with Spring Boot**. It uses an in-memory **H2 database** and implements a basic CRUD operation on a `Customer` entity using GraphQL queries and mutations.

---

## 🚀 Features

- GraphQL API using Spring Boot
- CRUD operations on `Customer` entity
- H2 in-memory database for demonstration
- Schema-first development with GraphQL schema definition
- Uses Spring Boot's `@SchemaMapping`, `@QueryMapping`, and `@MutationMapping`

---

## 🧱 Tech Stack

- Java 17+
- Spring Boot 3+
- GraphQL Java (via Spring for GraphQL)
- H2 Database (in-memory)
- Maven

---

## 🏗️ Project Structure

src
├── main
│ ├── java
│ │ └── com.example.graphql
│ │ ├── controller
│ │ │ └── CustomerGraphQLController.java
│ │ ├── model
│ │ │ └── Customer.java
│ │ ├── dto
│ │ │ └── CustomerInput.java
│ │ │ └── UpdateCustomerInput.java
│ │ ├── repository
│ │ │ └── CustomerRepository.java
│ │ └── GraphQLApplication.java
│ ├── resources
│ │ ├── application.properties
│ │ └── graphql
│ │ └── schema.graphqls


Example Queries
Get All Customers

{
  "query": "{ getAllCustomers { id name email city } }"
}



Add a Customer
{
    "query": "mutation AddCustomer($input: CustomerInput!) { addCustomer(input: $input) { id name email city } }",
    "variables": {
        "input": {
            "name": "Sarvagya",
            "email": "Sarvagya@example.com",
            "city": "Mumbai"
        }
    }
}


Update a Customer
{
  "query": "mutation ($input: UpdateCustomerInput!) { updateCustomer(input: $input) { id name email city } }",
  "variables": {
    "input": {
      "id": 1,
      "name": "Rohit Vishwakarma",
      "email": "rohit@example.com",
      "city": "Delhi"
    }
  }
}

Delete a Customer
{
  "query": "mutation ($id: ID!) { deleteCustomer(id: $id) }",
  "variables": {
    "id": "1"
  }
}


