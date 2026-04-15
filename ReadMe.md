microservices

create eureka server
one proj as server
<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
<version>5.0.1</version>
<scope>compile</scope>
</dependency>

on server main application, add this
@EnableEurekaServer

two proj as client
<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
<version>5.0.1</version>
<scope>compile</scope>
</dependency>

---

        (Eureka Server)
              ↑

---

| | |
User Product Order
Service Service Service

What Each Service Does

User Service
Stores user data
Example:
Create user
Get user

Product Service
Stores product data
Example:
Add product
Get product

Order Service (MOST IMPORTANT)
Combines everything
Talks to:
User Service
Product Service
👉 Example flow:
Client sends request → /orders
Order Service:
Calls User Service → get user
Calls Product Service → get product
Combines data
Saves order
Returns response

Eureka Server (Service Registry)
Acts like a phonebook
Services register themselves here
👉 Example:
product-service → http://localhost:8081
user-service → http://localhost:8082
Now instead of hardcoding URLs, services use:
http://product-service/products/1

How Communication Works (Feign)
In Order Service:
@FeignClient(name = "product-service")
public interface ProductClient {
@GetMapping("/products/{id}")
Product getProduct(@PathVariable Long id);
}

What happens:
Feign asks Eureka: “Where is product-service?”
Eureka returns the URL
Feign makes the HTTP call

What Happens When You Run Everything
Step-by-step startup:
Start Eureka Server
Start Product Service
Registers to Eureka
Start User Service
Registers to Eureka
Start Order Service
Registers to Eureka
