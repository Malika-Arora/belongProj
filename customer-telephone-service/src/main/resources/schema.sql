DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS customerPhoneDetails;

Create table customer(customer_id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL);
  
  Create table customer_phone_details(id INT AUTO_INCREMENT  PRIMARY KEY ,customer_id INT,
  phone_number VARCHAR (45)  NOT NULL,
  active TINYINT (1) );
 
 ALTER TABLE customer_phone_details ADD CONSTRAINT FK_customer FOREIGN KEY (customer_id) REFERENCES customer(customer_id) ON DELETE CASCADE;