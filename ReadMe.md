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
