-- MySQL dump 10.13  Distrib 8.0.35, for Win64 (x86_64)
--
-- Host: localhost    Database: fitness_db
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrators`
--

DROP TABLE IF EXISTS `administrators`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrators` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrators`
--

LOCK TABLES `administrators` WRITE;
/*!40000 ALTER TABLE `administrators` DISABLE KEYS */;
INSERT INTO `administrators` VALUES (1,'Darijo','Prerad','dp','dp'),(2,'Zoran','Prezime','zp','zp');
/*!40000 ALTER TABLE `administrators` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'strength','../assets/images/strength.jpg'),(2,'cardio','../assets/images/cardio.jpg'),(3,'durability','../assets/images/durability.jpg'),(4,'explosiveness','../assets/images/explosiveness.jpg'),(5,'flexibility','../assets/images/flexibility-cura.jpg'),(6,'hiit','../assets/images/HIIT.jpg'),(12,'','');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `programs_id` int DEFAULT NULL,
  `users_id` int DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK6lpd6q98yxahm3rr1xlopni1y` (`programs_id`),
  KEY `FKt55y2infwbbw3o942o2mhm0v4` (`users_id`),
  CONSTRAINT `FK6lpd6q98yxahm3rr1xlopni1y` FOREIGN KEY (`programs_id`) REFERENCES `programs` (`id`),
  CONSTRAINT `FKt55y2infwbbw3o942o2mhm0v4` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,'Comment1',1,1,'2024-04-21 11:43:45'),(2,'Comment2',1,1,'2024-04-21 22:00:00'),(3,'Comment3',1,2,'2024-04-22 22:00:00'),(4,'Comment4',1,2,'2024-04-22 22:00:00'),(5,'Comment5',2,3,'2024-04-24 22:00:00'),(6,'LOOOOONGER COMMENT ',2,1,'2024-04-24 22:00:00'),(7,'More comments',2,1,'2024-04-26 22:00:00'),(8,'Training plan, very very good',3,1,'2024-04-21 11:43:45'),(10,'Jako',1,1,NULL),(12,'asd',5,1,NULL),(13,'dsa',5,1,NULL);
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logs`
--

DROP TABLE IF EXISTS `logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user` varchar(255) DEFAULT NULL,
  `action` varchar(255) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logs`
--

LOCK TABLES `logs` WRITE;
/*!40000 ALTER TABLE `logs` DISABLE KEYS */;
INSERT INTO `logs` VALUES (5,'dp','Category Successfully Created','2024-05-09 14:06:50'),(6,'dp','Category Successfully Updated','2024-05-09 14:07:38'),(7,'dp','Category Successfully Deleted','2024-05-09 14:08:41'),(8,'zp','User Successfully Created','2024-05-09 14:13:35'),(9,'zp','Trainer Successfully Created','2024-05-09 14:15:15'),(10,'darijonanetu@gmail.com','Sent a response to id:13','2024-05-09 14:34:49'),(11,'darijonanetu@gmail.com','Sent a response to id:13','2024-05-09 14:37:02'),(12,'darijonanetu@gmail.com','Sent a response to id:2','2024-05-09 14:38:18'),(13,'dp','Category Successfully Created','2024-05-09 14:44:08'),(14,'dp','Could Not Create A Category','2024-05-09 15:06:13'),(15,'dp','Could Not Update A User','2024-05-09 15:08:19'),(16,'dp','Could Not Delete Trainer','2024-05-09 15:12:54'),(17,'darijonanetu@gmail.com','Sent a response to id:0','2024-05-09 15:41:20');
/*!40000 ALTER TABLE `logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mailing_list`
--

DROP TABLE IF EXISTS `mailing_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mailing_list` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mailing_list`
--

LOCK TABLES `mailing_list` WRITE;
/*!40000 ALTER TABLE `mailing_list` DISABLE KEYS */;
INSERT INTO `mailing_list` VALUES (1,'strength','dp'),(2,'strength','dp'),(3,'cardio','dp'),(4,'flexibility','dp');
/*!40000 ALTER TABLE `mailing_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `messages` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` text,
  `programs_id` int DEFAULT NULL,
  `recipients_id` int DEFAULT NULL,
  `senders_id` int DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `seen` bit(1) DEFAULT b'0',
  `trainers_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd02d8yd058p2biksnl1oo2w48` (`recipients_id`),
  KEY `FKqhsex429mbw5k071thmcgjb7w` (`senders_id`),
  KEY `trainers_id` (`trainers_id`),
  CONSTRAINT `FKd02d8yd058p2biksnl1oo2w48` FOREIGN KEY (`recipients_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKqhsex429mbw5k071thmcgjb7w` FOREIGN KEY (`senders_id`) REFERENCES `users` (`id`),
  CONSTRAINT `messages_ibfk_1` FOREIGN KEY (`trainers_id`) REFERENCES `trainers` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES (1,'A message for Darijo',NULL,NULL,2,'2024-05-02 13:22:14',_binary '\0',3),(2,'Another message for Darijo',NULL,NULL,3,'2024-05-02 13:22:14',_binary '\0',3),(3,'Long message that is very very long and very very nice. Also for Darijo and so on. U smislu ovog zakona, blablabla',NULL,NULL,2,'2024-05-03 10:52:44',_binary '\0',3),(4,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla vel massa ultrices tortor sagittis tincidunt et nec neque. Quisque sit amet egestas elit, eu interdum orci. Duis ultricies mi at elementum mollis. Integer lacinia nisl purus, vitae pellentesque diam efficitur viverra. Cras facilisis eu est auctor ullamcorper. Phasellus vestibulum euismod elementum. Sed nisi est, ultrices non ultricies sed, ornare nec dui. In euismod finibus neque at euismod. Donec pellentesque mauris porttitor, dictum nulla et, condimentum magna. Aliquam erat volutpat. Maecenas finibus urna vel orci varius, et blandit leo scelerisque. Ut magna massa, bibendum et massa eu, consequat condimentum orci. Nulla hendrerit ultrices elit eu aliquam. Proin augue nunc, volutpat sed nisl eu, iaculis efficitur arcu. Phasellus ut tellus sed urna mollis maximus eget vel purus. Nulla imperdiet porttitor leo, at mollis est pulvinar non.  ',NULL,NULL,3,'2024-05-04 09:59:57',_binary '\0',3);
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `programs`
--

DROP TABLE IF EXISTS `programs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `programs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `activity_type` varchar(255) DEFAULT NULL,
  `difficulty` varchar(255) DEFAULT NULL,
  `duration` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `bodyweight` bit(1) DEFAULT NULL,
  `equipment` varchar(255) DEFAULT NULL,
  `categories_id` int DEFAULT NULL,
  `trainers_id` int DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FKto7e3937e77lyxj25etqviufq` (`categories_id`),
  KEY `FKckt7s16oqwr0bxqvq8thr4lev` (`trainers_id`),
  CONSTRAINT `FKckt7s16oqwr0bxqvq8thr4lev` FOREIGN KEY (`trainers_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKto7e3937e77lyxj25etqviufq` FOREIGN KEY (`categories_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programs`
--

LOCK TABLES `programs` WRITE;
/*!40000 ALTER TABLE `programs` DISABLE KEYS */;
INSERT INTO `programs` VALUES (1,'Best workout plan you will ever see!','Intermediate plan designed for max efficiency and max gains.','weight lifting','4','40m','Banjaluka',50,'../assets/images/plan1.jpg',_binary '\0','dumbells',1,1,'2024-04-21 11:34:31'),(2,'Get to work with this premium plan for begginers','Begginer friendly workout plan for intermediate gains.','jumping','2','30m','Prijedor',22,'../assets/images/plan2.jpg',_binary '\0','jump rope',4,1,'2024-04-21 11:35:46'),(3,'Work your legs.','Grow your butt and become the hottest.','squats','4','90m','Banjaluka',30,'../assets/images/plan3.jpg',_binary '\0','barbell and weights',1,2,'2024-04-21 22:00:00'),(4,'Wanna become strong AF?','Become unbeatable with this chest workout.','bench press/pushups','5','120m','Laktasi',5,'../assets/images/plan4.jpg',_binary '\0','bench with a barbell and weights',1,1,'2024-04-22 22:00:00'),(5,'Some other program','A thorough description of the above mentioned program. Here you will see what we can offer you and how to use the provided information to become a beast.','running','1','30m','Banjaluka',120,'../assets/images/plan1.jpg',_binary '','no equipment needed',3,2,'2024-04-23 22:00:00'),(6,'Another program','A thorough description of the above mentioned program. Here you will see what we can offer you and how to use the provided information to become a beast.','sprints','5','120m','Banjaluka',70,'../assets/images/plan2.jpg',_binary '','no equipment needed',6,3,'2024-04-21 11:34:31'),(7,'Another program','A thorough description of the above mentioned program. Here you will see what we can offer you and how to use the provided information to become a beast.','splits','4','45m','Banjaluka',40,'../assets/images/plan3.jpg',_binary '','no equipment needed',5,2,'2024-04-21 11:34:31'),(8,'Another program','A thorough description of the above mentioned program. Here you will see what we can offer you and how to use the provided information to become a beast.','swimming','3','60m','Banjaluka',65,'../assets/images/plan4.jpg',_binary '','no equipment needed',2,3,'2024-04-21 11:34:31');
/*!40000 ALTER TABLE `programs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `programs_has_users`
--

DROP TABLE IF EXISTS `programs_has_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `programs_has_users` (
  `users_id` int NOT NULL,
  `programs_id` int NOT NULL,
  KEY `FKjbtwpkr4qpj12csdsllxfo977` (`programs_id`),
  KEY `FKom080r7u414p1k1y4vp3y13vv` (`users_id`),
  CONSTRAINT `FKjbtwpkr4qpj12csdsllxfo977` FOREIGN KEY (`programs_id`) REFERENCES `programs` (`id`),
  CONSTRAINT `FKom080r7u414p1k1y4vp3y13vv` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programs_has_users`
--

LOCK TABLES `programs_has_users` WRITE;
/*!40000 ALTER TABLE `programs_has_users` DISABLE KEYS */;
INSERT INTO `programs_has_users` VALUES (1,1),(1,3),(15,1),(15,1);
/*!40000 ALTER TABLE `programs_has_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainers`
--

DROP TABLE IF EXISTS `trainers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trainers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainers`
--

LOCK TABLES `trainers` WRITE;
/*!40000 ALTER TABLE `trainers` DISABLE KEYS */;
INSERT INTO `trainers` VALUES (1,'Trener Zoran','Prezime2','zoranovmejl@mejl.com','dp'),(2,'Trener Goran','Prezime3','goranovmejl@gmail.com','dp'),(3,'Trener Darijo','Prerad','darijonanetu@gmail.com','dp'),(6,'Trener Blagoje','Jovovic','spc@gmail.com','dp'),(9,'Trener Dummy First Name','Trener Dummy Last Name','trdm@mfasd','dp');
/*!40000 ALTER TABLE `trainers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `uname` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `role` enum('LOGGED_USER') DEFAULT NULL,
  `is_trainer` bit(1) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_iqm8x8lkitrfo4idy96trfm9p` (`uname`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Darijo','Prerad','dp','darijonanetu@gmail.com','$2a$10$Utsoa.09bl9cJi7HGPr8JeGLaMm7VVcMWxGlFuty2IXatx5uczHgq','065-204/724','LOGGED_USER',_binary '','https://www.rd.com/wp-content/uploads/2019/09/GettyImages-621924830-scaled.jpg?w=2560','Banjaluka','2024-04-21 11:00:32'),(2,'Korisnik2','Prezime2','k2','k2@gmail.com','$2a$10$Utsoa.09bl9cJi7HGPr8JeGLaMm7VVcMWxGlFuty2IXatx5uczHgq','kontakt2','LOGGED_USER',_binary '','https://wallsdesk.com/wp-content/uploads/2016/05/AK-47-Computer-Wallpaper.jpg','Banjaluka','2024-04-21 11:00:32'),(3,'Korisnik3','Prezime3','k3','k3@gmail.com','$2a$10$Utsoa.09bl9cJi7HGPr8JeGLaMm7VVcMWxGlFuty2IXatx5uczHgq','kontakt3','LOGGED_USER',_binary '','https://www.hdwallpaper.nu/wp-content/uploads/2015/02/Funny-Cat-Hidden.jpg','Prijedor','2024-04-21 11:00:32'),(13,'Darijo','Prerad','njg','darijo@majl','$2a$10$Utsoa.09bl9cJi7HGPr8JeGLaMm7VVcMWxGlFuty2IXatx5uczHgq','123','LOGGED_USER',_binary '\0','','Banjaluka',NULL),(15,'Korisnik4','Prezime4','k4','k4@gmail.com','$2a$10$ptMbtMVqbcXTj6rUC4mDdue1aUj7ejoYvbhvlZ8KFYBU5f93YdV3S','123','LOGGED_USER',_binary '\0','','Banja Luka',NULL),(18,'Dummy User First Name','Dummy User LastName','Dummy User Username','dummymail@mail','pass','123','LOGGED_USER',_binary '\0','','Banjaluka Dummy','2024-05-09 14:13:35');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-15 14:37:32
