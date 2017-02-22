/*

Login to db as root and create TABLE
CREATE USER 'thors'@'localhost' IDENTIFIED BY 'pmdj2424';
GRANT ALL ON ram.* TO 'thors'@'localhost';
FLUSH PRIVILEGES;

*/
CREATE DATABASE RAM;

USE RAM;

CREATE TABLE categories (
category_id INT(6) NOT NULL AUTO_INCREMENT,
category_name varchar(255) NOT NULL UNIQUE,
PRIMARY KEY (category_id));

CREATE TABLE subcategories (
subcategory_id INT(8) NOT NULL AUTO_INCREMENT,
category_id INT(6) NOT NULL,
subcategory_name varchar(255) NOT NULL UNIQUE,
PRIMARY KEY (subcategory_id),
FOREIGN KEY (category_id) REFERENCES categories(category_id));

CREATE TABLE businesses (
business_id INT(8) NOT NULL AUTO_INCREMENT,
category_id INT(8) NOT NULL,
business_name varchar(255) NOT NULL,
provider_name varchar(255) NOT NULL,
email varchar(255) NOT NULL UNIQUE,
password varchar(255),
provider_state varchar(255),
creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
last_update DATETIME DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY (business_id),
FOREIGN KEY (category_id) REFERENCES categories(category_id));

CREATE TABLE addresses(
address_id INT(10) NOT NULL AUTO_INCREMENT,
street varchar(255),
street_nbr varchar(10),
floor varchar(6),
postalCode varchar(10),
district varchar(30),
city varchar(50),
province varchar(50),
country varchar(2),
coordenates varchar(36),
PRIMARY KEY (address_id));

CREATE TABLE branches (
branch_id INT(10) NOT NULL AUTO_INCREMENT,
business_id INT(8) NOT NULL,
address_id INT(10) NOT NULL,
telephone varchar(25) NOT NULL,
branch_state varchar(20),
PRIMARY KEY (branch_id),
FOREIGN KEY (business_id) REFERENCES businesses(business_id),
FOREIGN KEY (address_id) REFERENCES addresses(address_id));

CREATE TABLE services (
service_id INT NOT NULL AUTO_INCREMENT,
branch_id INT(10) NOT NULL,
subcategory_id INT(8) NOT NULL,
service_name varchar(25),
service_duration INT(2) NOT NULL,
service_state varchar(25),
PRIMARY KEY (service_id),
FOREIGN KEY (branch_id) REFERENCES branches(branch_id),
FOREIGN KEY (subcategory_id) REFERENCES subcategories(subcategory_id));

CREATE TABLE providers (
provider_id INT NOT NULL AUTO_INCREMENT,
service_id INT(10) NOT NULL,
sunday varchar(9),
monday varchar(9),
tuesday varchar(9),
wednesday varchar(9),
thursday varchar(9),
friday varchar(9),
saturday varchar(9),
personal_state varchar(25),
PRIMARY KEY (provider_id),
FOREIGN KEY (service_id) REFERENCES services(service_id));

/**/
CREATE TABLE customers (
customer_id INT NOT NULL AUTO_INCREMENT,
address_id INT(10) NOT NULL,
email varchar(255) NOT NULL UNIQUE,
password varchar(255),
PRIMARY KEY (customer_id),
FOREIGN KEY (address_id) REFERENCES addresses(address_id));

CREATE TABLE personal (
personal_id INT NOT NULL AUTO_INCREMENT,
provider_id INT(10) NOT NULL,
email varchar(255) NOT NULL UNIQUE,
password varchar(255),
PRIMARY KEY (personal_id),
FOREIGN KEY (provider_id) REFERENCES providers(provider_id));

CREATE TABLE appointment (
appointment_id INT NOT NULL AUTO_INCREMENT,
provider_id INT NOT NULL,
customer_id INT NOT NULL,
appointment_date varchar(6) NOT NULL,
appointment_hour varchar(9) NOT NULL,
appointment_state varchar(25),
PRIMARY KEY (appointment_id),
FOREIGN KEY (provider_id) REFERENCES providers(provider_id),
FOREIGN KEY (customer_id) REFERENCES customers(customer_id));