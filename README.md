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

## DB Password Encryption

### 1- Add the following dependency to pom.xml
```
<dependency>
	<groupId>com.github.ulisesbocchio</groupId>
	<artifactId>jasypt-spring-boot-starter</artifactId>
	<version>3.0.4</version>
</dependency>
```

### 2- Add the following plugin to pom.xml
```
<plugin>
	<groupId>com.github.ulisesbocchio</groupId>
	<artifactId>jasypt-maven-plugin</artifactId>
	<version>3.0.4</version>
</plugin>
```

### 3- Label your password as DEC in the application.properties
```
spring.datasource.password=DEC("<your password>")
```

### 4 - Add the Jasypt properties in the application.properties
```
jasypt.encryptor.algorithm=PBEWithMD5AndDES
jasypt.encryptor.password=techjava
jasypt.encryptor.keyObtentionIterations=1000
jasypt.encryptor.poolSize=1
jasypt.encryptor.providerName=SunJCE
jasypt.encryptor.saltGeneratorClassname=org.jasypt.salt.RandomSaltGenerator
jasypt.encryptor.stringOutputType=base64
```

### 5- Execute the Jasypt encryption command in Maven CLI

```
mvn jasypt:encrypt -Djasypt.encryptor.password=techjava
```

