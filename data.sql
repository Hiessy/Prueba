/*
INSERT STATEMENT 

WS NEW CATEGORY - NEW SUBCATEGORY - NEW PROVIDER - NEW ADDRESS - NEW BRANCHES

*/

INSERT INTO categories(category_name) VALUES ('Health'), ('Cosmetic'), ('Medicine'), ('Mechanic'), ('Computer');

INSERT INTO subcategories(category_id,subcategory_name) VALUES 
(1,'Spa'), (1,'Massage'), (1,'Tanning'), (2,'Haircut'), (2,'Hairstyling'), (2,'Manicure'), (2,'Pedicure'), (2,'Dentist'),
(3,'Proctologist'), (3,'Clinic'), (3,'Cardiologist'),(4,'Car'),(4,'Bicicles'), (4,'Airplanes'),(4,'Motorboats'),
(5,'Laptop'),(5,'Webpage'),(5,'PersonalPC');

INSERT INTO businesses(category_id,business_name,provider_name,email,password,provider_state,creation_date,last_update) VALUES 
(1,'Free Spa','Ramon Gonzalez','free_spa@mail.com','12345678','ACTIVE',NOW(),NOW()), (3,'Hospital Muñiz','Esteban Callone','hospital.muniz@mail.com','12345678','ACTIVE',NOW(),NOW()),
(3,'Sanatorio Tortuga','Romina Castilla','rcastilla@mail.com','12345678','ACTIVE',NOW(),NOW());

INSERT INTO addresses(street,street_nbr,floor,postalCode,district,city,province,country,coordenates) VALUES 
('Av. Rivadavia', '6800',null,'C1406',null, 'Ciudad Autonoma de Buenos Aires', 'Buenos Aires', 'AR','-34.628518:-58.461035'),
('Av. Corrientes', '3506',null,'C1194',null,  'Ciudad Autonoma de Buenos Aires','Buenos Aires', 'AR','-34.60403:-58.41470'),
('Estomba', '3924',null,'C1430',null,  'Ciudad Autonoma de Buenos Aires','Buenos Aires', 'AR','-34.553993:-58.484161'),
('Lavalle', '1514',null,'C1048',null,  'Ciudad Autonoma de Buenos Aires','Buenos Aires', 'AR','-34.60291:-58.38842'),
('Córdoba', '3845',null,'S2002LAG',null,   'Rosario', 'Santa Fe', 'AR','-32.93961:-60.675089'),
('Av. 19', '135',null,'B1902',null, 'La Plata', 'Buenos Aires', 'AR','-34.91416:-57.978332'),
('Rosario', '68',null,'C1424',null, 'Ciudad Autonoma de Buenos Aires', 'Buenos Aires', 'AR','-34.6184392:-58.4295427');

INSERT INTO branches(business_id, address_id, telephone, branch_state) VALUES
(1,5,'(03537) 41 - 5777','ACTIVE'),
(1,6,'(3243) 32 - 5772','ACTIVE'),
(2,1,'(11) 4432 - 5772','ACTIVE'),
(2,4,'(11) 6543 - 5727','ACTIVE'),
(2,3,'(11) 4956 - 5277','INACTIVE'),
(3,2,'(11) 4431 - 5777','ACTIVE');

/***

Validar que la categoria del provedor posea como subcategoria la misma subcategoria que se elegi como subcategoria del servicio

Mirar con el branch_id quien es el provedor_id en branches, 
con el provider_id mirar cual es el category_id 
y verificar que el subcategory que se intenta insertar en 
services pertenezca a uno de los que esta dentro de subcategory

la subcategoria deberia matchear con el id de categoria que tiene el provedor de servicio

***/
INSERT INTO services (branch_id, subcategory_id, service_name, service_duration, service_state) VALUES
(1,1,'One Hour Spa',12,'ACTIVE'),
(1,2,'Swedish Massage',6,'ACTIVE'),
(1,3,'Trump Tanning',2,'ACTIVE'),
(2,1,'Spa from Home',4,'ACTIVE'),
(2,3,'Tanner Tans',3,'ACTIVE'),
(3,9,'Procto Amigo',3,'ACTIVE'),
(3,10,'MediClinic',4,'ACTIVE'),
(3,11,'Un nuevo corazon',6,'ACTIVE'),
(4,9,'Proctologo Clinic',3,'ACTIVE'),
(4,10,'Spiderman Clinic',3,'ACTIVE'),
(4,11,'Implantes cardios',12,'ACTIVE'),
(5,9,'Proctologa Brenda',4,'ACTIVE'),
(5,11,'Cardiologia',6,'ACTIVE'),
(6,11,'Cardiologos Bonairenses',12,'ACTIVE');

INSERT INTO providers (service_id, sunday, monday, tuesday, wednesday, thursday, friday, saturday, personal_state) VALUES
(1,"0000:0000","0900:1800","0900:1800","0900:1800","0900:1800","0900:1800","0000:0000","ACTIVE"),
(1,"0000:0000","0900:1800","0900:1800","0900:1800","0900:1800","0900:1800","0000:0000","ACTIVE"),
(2,"0800:1800","0800:1800","0000:0000","0800:1800","0800:1800","0000:0000","0800:1800","ACTIVE"),
(2,"0800:1800","0000:0000","0945:1915","0900:1400","0900:1800","0900:1800","0000:0000","ACTIVE"),
(2,"0800:1800","0930:1800","1000:1700","1100:1800","0900:1800","0900:1800","0800:1200","ACTIVE"),
(2,"0000:0000","0900:1800","0000:0800","0900:1800","0900:1800","0000:0000","0000:0000","ACTIVE"),
(3,"0000:0000","0900:1800","0000:0800","0900:1800","0900:1800","0000:0000","0000:0000","ACTIVE"),
(4,"0200:2300","0000:0000","0200:2300","0000:0000","0200:2300","0000:0000","0200:2300","ACTIVE"),
(4,"1400:0000","0900:1200","0900:1800","0900:1800","0900:1800","0900:1800","0000:0000","ACTIVE"),
(4,"1000:2000","0900:1800","0000:0000","0900:1800","0900:1800","0900:1100","0000:0000","ACTIVE"),
(5,"0000:0000","0900:1800","0900:1800","0900:1800","0900:1800","0900:1800","0000:0000","ACTIVE"),
(5,"0000:0000","0900:1800","0900:1800","0900:1800","0900:1800","0900:1800","0000:0000","ACTIVE"),
(5,"0000:0000","0900:1800","0900:1800","0900:1800","0900:1800","0900:1800","0000:0000","ACTIVE"),
(6,"0000:0000","0900:1700","0900:1700","0900:1700","0900:1700","0900:1700","0000:0000","ACTIVE"),
(6,"0000:0000","0800:1600","0800:1600","0800:1600","0800:1600","0800:1600","0000:0000","ACTIVE"),
(7,"0000:0000","0900:1800","0900:1800","0900:1800","0900:1800","0000:0000","0000:0000","ACTIVE"),
(7,"0000:0000","0900:1800","0900:1800","0900:1800","0900:1800","0000:0000","0000:0000","ACTIVE"),
(8,"0000:0000","0000:0000","0000:0000","0900:1800","0900:1800","0900:1800","0900:1800","ACTIVE"),
(8,"0000:0000","0000:0000","0000:0000","0900:1800","0900:1800","0900:1800","0900:1800","ACTIVE"),
(8,"0000:0000","0000:0000","0900:1800","0900:1800","0900:1800","0900:1800","0000:0000","ACTIVE"),
(8,"0000:0000","0000:0000","0900:1800","0900:1800","0900:1800","0900:1800","0000:0000","ACTIVE"),
(9,"0000:0000","0700:1600","0900:1800","0900:1800","0900:1800","0900:1800","0000:0000","ACTIVE"),
(10,"0000:0000","0900:1800","0900:1800","0900:1800","0900:1800","0900:1800","0000:0000","ACTIVE"),
(10,"0000:0000","0900:1800","0900:1800","0900:1800","0900:1800","0900:1800","0000:0000","ACTIVE"),
(10,"0000:0000","0900:1800","0900:1800","0900:1800","0900:1800","0900:1800","0000:0000","ACTIVE"),
(11,"0000:0000","0900:1800","0900:1800","0900:1800","0900:1800","0900:1800","0000:0000","ACTIVE"),
(11,"0000:0000","0900:1800","0900:1800","0900:1800","0900:1800","0900:1800","0000:0000","ACTIVE"),
(11,"0000:0000","0900:1800","0900:1800","0900:1800","0900:1800","0900:1800","0000:0000","ACTIVE"),
(12,"0000:0000","0900:1800","0900:1800","0900:1800","0900:1800","0900:1800","0000:0000","ACTIVE"),
(12,"0000:0000","0900:1800","0900:1800","0900:1800","0900:1800","0900:1800","0000:0000","ACTIVE"),
(12,"0000:0000","0900:1800","0900:1800","0900:1800","0900:1800","0900:1800","0000:0000","ACTIVE"),
(13,"0000:0000","0900:1800","0900:1800","0900:1800","0900:1800","0900:1800","0000:0000","ACTIVE"),
(13,"0000:0000","0900:1800","0900:1800","0900:1800","0900:1800","0900:1800","0000:0000","ACTIVE"),
(13,"0000:0000","0900:1800","0900:1800","0900:1800","0900:1800","0900:1800","0000:0000","ACTIVE"),
(14,"0000:0000","0900:1800","0900:1800","0900:1800","0900:1800","0900:1800","0000:0000","ACTIVE"),
(14,"0000:0000","0900:1800","0900:1800","0900:1800","0900:1800","0900:1800","0000:0000","ACTIVE"),
(14,"0000:0000","0900:1800","0900:1800","0900:1800","0900:1800","0900:1800","0000:0000","ACTIVE");

INSERT INTO customers (address_id, customer_name, email, password) VALUES
(7,"Agustin Larrarte","alarrarte@mail.com","1234abcd");
/*

agrregar address
*/