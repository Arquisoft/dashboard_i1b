[![Codacy Badge](https://api.codacy.com/project/badge/Grade/2f5e9b234d9b4cbd8669629c299990ad)](https://www.codacy.com/app/jelabra/dashboard_i1b?utm_source=github.com&utm_medium=referral&utm_content=Arquisoft/dashboard_i1b&utm_campaign=badger)
[![Build Status](https://travis-ci.org/Arquisoft/dashboard_i1b.svg?branch=master)](https://travis-ci.org/Arquisoft/dashboard_i1b)
[![codecov](https://codecov.io/gh/Arquisoft/dashboard_i1b/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/dashboard_i1b)


# dashboard_i1b

[![Join the chat at https://gitter.im/Arquisoft/participants0](https://badges.gitter.im/Arquisoft/participants0.svg)](https://gitter.im/Arquisoft/participants0?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Skeleton of participants module

#Database script
delete from vote;
delete from proposal;
delete from votable;
delete from citizen;
#-------------------------------------------------------------------------------------------------------------------- 
INSERT  INTO citizen (id,address, birthday, email, first_name, last_name, nationality, nif, password, polling_station_code) values (1,'addres1', current_date, '1@email.com', '1', '1', '1', '1', '1',1);
INSERT  INTO citizen (id,address, birthday, email, first_name, last_name, nationality, nif, password, polling_station_code) values (2,'addres2', current_date, '2@email.com', '2', '2', '2', '2', '2',2);
INSERT  INTO citizen (id,address, birthday, email, first_name, last_name, nationality, nif, password, polling_station_code) values (3,'addres3', current_date, '3@email.com', '3', '3', '3', '3', '3',3);
INSERT  INTO citizen (id,address, birthday, email, first_name, last_name, nationality, nif, password, polling_station_code) values (4,'addres4', current_date, '4@email.com', '4', '4', '4', '4', '4',4);
INSERT  INTO citizen (id,address, birthday, email, first_name, last_name, nationality, nif, password, polling_station_code) values (5,'addres5', current_date, '5@email.com', '5', '5', '5', '5', '5',5);
INSERT  INTO citizen (id,address, birthday, email, first_name, last_name, nationality, nif, password, polling_station_code) values (6,'addres6', current_date, '6@email.com', '6', '6', '6', '6', '6',6);
INSERT  INTO citizen (id,address, birthday, email, first_name, last_name, nationality, nif, password, polling_station_code) values (7,'addres7', current_date, '7@email.com', '7', '7', '7', '7', '7',7);
INSERT  INTO citizen (id,address, birthday, email, first_name, last_name, nationality, nif, password, polling_station_code) values (8,'addres8', current_date, '8@email.com', '8', '8', '8', '8', '8',8);
INSERT  INTO citizen (id,address, birthday, email, first_name, last_name, nationality, nif, password, polling_station_code) values (9,'addres9', current_date, '9@email.com', '9', '9', '9', '9', '9',9);
INSERT  INTO citizen (id,address, birthday, email, first_name, last_name, nationality, nif, password, polling_station_code) values (10,'addres10', current_date, '10@email.com', '10', '10', '10', '10', '10',10);
#-------------------------------------------------------------------------------------------------------------------- 
INSERT into votable values (1); 
INSERT INTO proposal (description, id, citizen_id) VALUES ('descripcion1',1,1); 
INSERT into votable values (2); 
INSERT INTO proposal (description, id, citizen_id) VALUES ('descripcion2',2,2);
#-------------------------------------------------------------------------------------------------------------------- 
insert into vote (value,citizen_id, votable_id) VALUES (true,1,2);
insert into vote (value,citizen_id, votable_id) VALUES (true,2,1);
insert into vote (value,citizen_id, votable_id) VALUES (true,3,2);
insert into vote (value,citizen_id, votable_id) VALUES (true,4,2);
insert into vote (value,citizen_id, votable_id) VALUES (true,5,1);
insert into vote (value,citizen_id, votable_id) VALUES (true,6,2);
insert into vote (value,citizen_id, votable_id) VALUES (false,7,2);
insert into vote (value,citizen_id, votable_id) VALUES (false,8,2);
insert into vote (value,citizen_id, votable_id) VALUES (false,9,2);
insert into vote (value,citizen_id, votable_id) VALUES (false,10,2);

# Authors

- Herminio García González (@herminiogg)
- Jose Emilio Labra Gayo (@labra)
- Pablo Roncero Fernández (@ronce96)
- Alvaro Suarez del Cueto (@varosuarez)
- David Villamil Fernández (@davillafer)
