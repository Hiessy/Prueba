/*

Script for creating data base. This is commented out since we are using H2 in memory for testing

CREATE DATABASE RAM;

USE RAM;

--Login to db as root and create TABLE

CREATE USER 'thors'@'localhost' IDENTIFIED BY 'pmdj2424';
GRANT ALL ON ram.* TO 'thors'@'localhost';
FLUSH PRIVILEGES;

*/


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
owner_name varchar(255) NOT NULL,
email varchar(255) NOT NULL UNIQUE,
password varchar(255),
business_state varchar(255),
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
coordenates varchar(50),
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

CREATE TABLE personal_schedules (
personal_schedule_id INT NOT NULL AUTO_INCREMENT,
personal_id INT(10) NOT NULL,
sunday varchar(9),
monday varchar(9),
tuesday varchar(9),
wednesday varchar(9),
thursday varchar(9),
friday varchar(9),
saturday varchar(9),
personal_state varchar(25),
PRIMARY KEY (personal_schedule_id),
FOREIGN KEY (personal_id) REFERENCES personal(personal_id));

CREATE TABLE contacts (
contact_id INT NOT NULL AUTO_INCREMENT,
address_id INT(10) NOT NULL,
telephone varchar(255),
cellphone varchar(255),
personal_id_number varchar(255),
business_id_number varchar(255),
PRIMARY KEY (contact_id),
FOREIGN KEY (address_id) REFERENCES addresses(address_id));

/**/
CREATE TABLE customers (
customer_id INT NOT NULL AUTO_INCREMENT,
contact_id INT(10) NOT NULL,
customer_name varchar(255) NOT NULL,
email varchar(255) NOT NULL UNIQUE,
password varchar(255),
customer_dob varchar(255),
customer_state varchar(255)NOT NULL,
PRIMARY KEY (customer_id),
FOREIGN KEY (contact_id) REFERENCES contacts(contact_id));

CREATE TABLE personal (
personal_id INT NOT NULL AUTO_INCREMENT,
service_id INT(10) NOT NULL,
contact_id INT(10) NOT NULL,
personal_name varchar(255) NOT NULL,
email varchar(255) NOT NULL UNIQUE,
password varchar(255),
PRIMARY KEY (personal_id),
FOREIGN KEY (service_id) REFERENCES services(service_id));

CREATE TABLE profiles (
profile_id INT NOT NULL AUTO_INCREMENT,
personal_id INT(10) NOT NULL,
business_id INT(8) NOT NULL,
profile_type varchar(255) NOT NULL,
PRIMARY KEY (profile_id),
FOREIGN KEY (personal_id) REFERENCES personal(personal_id),
FOREIGN KEY (business_id) REFERENCES businesses(business_id));

CREATE TABLE appointments (
appointment_id INT NOT NULL AUTO_INCREMENT,
personal_schedule_id INT NOT NULL,
customer_id INT NOT NULL,
appointment_time TEXT(10) NOT NULL,
appointment_state varchar(25),
PRIMARY KEY (appointment_id),
FOREIGN KEY (personal_schedule_id) REFERENCES personal_schedules(personal_schedule_id),
FOREIGN KEY (customer_id) REFERENCES customers(customer_id));