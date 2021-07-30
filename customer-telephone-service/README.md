### How do I get set up? ###
* Git link 

	 https://github.com/Malika-Arora/belongProj.git


* Swagger file

        customer-telephone-service\customer-api.yaml


* Technical stack 

	 Java8
	 
	 Spring Boot
	 
	 Maven


* Database configuration 

	
	in-memory h2 database


* API Endpoints 


	GET - http://localhost:8080/v1/telephone/getAllNumbers
	
	GET- http://localhost:8080/v1/telephone/getNumbersByCustomer/2
	
	PATCH- curl -X PATCH http://localhost:8080/v1/telephone/updateTelephoneStatus/1/+61469880141/1
	
	
* Approach


	Load static data using in h2 databse using data.sql 
	
	Expose Rest APIs using spring boot Rest Controller


* Improvement


	User Authentication/Authorization
