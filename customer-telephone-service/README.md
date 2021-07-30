### How do I get set up? ###
* GIT link - 
* Run the application - 
	Build application - mvn clean install
	Run the application - In the target folder run 
				java -jar customer-telephone-service-0.0.1-SNAPSHOT.jar
* Swagger file - customer-telephone-service\customer-api.yaml
* Java version -1.8
* Spring version - 2.5.3 
* Database configuration - In memory h2 database
* How to run tests - Build will run the junit tests
* API Endpoints - 
	GET - http://localhost:8080/v1/telephone/getAllNumbers
	GET- http://localhost:8080/v1/telephone/getNumbersByCustomer/2
	PATCH- curl -X PATCH http://localhost:8080/v1/telephone/updateTelephoneStatus/1/+61469880141/1
