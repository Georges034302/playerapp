# playerapp
Spring Boot back-end app

## Run SpringBoot app
```
mvn spring-boot:run
```

## MySql Database configuration
```
create database if not exists mydb;

drop table if exists mydb.players;

CREATE TABLE IF NOT EXISTS mydb.players(
	ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(40) UNIQUE NOT NULL,	
    SCORE INTEGER NOT NULL
)AUTO_INCREMENT=100;
alter table mydb.players
add RATING decimal(4,2)
generated always as (score/20) stored;

INSERT INTO mydb.players (NAME, SCORE)
values
('Alen Jones',66),
('Ron Dex', 45),
('Amy Dentz', 50),
('Lucy Lam', 80),
('Adam Berts', 90),
('David Suiter', 35),
('Jess Jones', 72),
('Alex Carter', 88),
('Rony Dolton', 48),
('Alice Denis', 52),
('Lara Lin', 81),
('Aden Banner', 92),
('Dania Sutler', 39),
('Jessy James', 74),
('Alia Camil', 87),
('Ortega Gomez', 76),
('Lian Lyn', 89),
('Adonis Bas', 93),
('Daneka Semens', 32),
('Jasper James', 73),
('Amos Cahan', 86),
('Oliver Gotez',  77),
('Amir Baber', 93),
('Daisy Suns', 40),
('Jaime Julz', 71),
('Axel Castor', 86),
('Orelia Gomez', 76),
('Lena Lin', 90),
('Apolo Creed', 92),
('Damia Semar', 33),
('Jamal Jones', 72),
('Aria Calian', 85),
('Olena Golez', 77),
('Adolf Baits', 90),
('Dona Stone', 37),
('Julie Jaan', 71),
('Aster Cruz', 86),
('Lama Lyn', 89),
('Avihai Bronn', 90),
('Daspika Sola', 35),
('Jerom Jimms', 71),
('Akela Croft', 84),
('Olivia Priez', 76);
```
