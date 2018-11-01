-- MySQL dump 10.13  Distrib 5.7.23, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: projeto_integrado
-- ------------------------------------------------------
-- Server version	5.7.23-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `about` text,
  `birthday` date DEFAULT NULL,
  `role` enum('manager','analyst') DEFAULT 'analyst',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `manager_id` varchar(255) DEFAULT NULL,
  `analyst_id` varchar(255) DEFAULT NULL,
  `gender` enum('female','male') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `users_managers_fk` (`manager_id`),
  KEY `users_analysts_fk` (`analyst_id`),
  CONSTRAINT `users_analysts_fk` FOREIGN KEY (`analyst_id`) REFERENCES `analysts` (`id`),
  CONSTRAINT `users_managers_fk` FOREIGN KEY (`manager_id`) REFERENCES `managers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('145b4d89-fda5-4811-b4e2-dfffe6bca470','Mais','Teste','$2a$10$ubAgJ1S0mlnlfmg9Of3xqOxXnEmsV8a7l59D65I58/ZU8nYQ1ucS6','um@teste.um',NULL,'2018-01-01','analyst','2018-10-18 17:40:01',NULL,'8f674da9-822a-41af-afe9-14086382f87c','female'),('23edb6d6-6b17-4cc8-bc75-d1fc7e58968e','Teste','Testinho','$2a$10$fjakzohOC1zm.N.5iXgx6OiIThBnBF.yJfw5LvR.E6f0kzSZDDcKi','teste@teste.teste',NULL,'1988-02-07','analyst','2018-10-11 03:52:33',NULL,NULL,'female'),('2e386116-deb4-4a1d-981f-f0268dbc47ec','Arthur','Veríssimo','$2a$10$9EIJKn1BxOKOIuSWs2Cx.e9ShGdLwClWxIwngTC3faN/OFz/MzaIm','arthur@loop.com.br',NULL,'1999-03-27','manager','2018-10-11 12:59:25',NULL,NULL,'female'),('4ede2903-84d4-4f6c-bb0c-55dafe2de918','Teste','Testinho','$2a$10$8PK6vDJkH8GMUfSsAHgNjO7s9lP6GYGVEjOHqpS/5ez9rBG6KptSu','teste@teste3.teste',NULL,'2000-02-28','manager','2018-10-11 13:21:27',NULL,NULL,'female'),('5381efae-5e8b-4e43-9853-cf35fa3a4756','Rafael','Silva','$2a$11$48vS5/o9PhB.f4jIJnEr6er8udNVAp.fVTM31MOSDaYO6xa3JKfYy','rafael@loop.com.br',NULL,NULL,'manager','2018-09-19 21:50:39','f39478b9-a0cf-4a93-b444-60886a71e714',NULL,'female'),('5fd26220-6c08-4a01-acf2-96c2d8470d81','Gabriel','Furlan','$2a$11$48vS5/o9PhB.f4jIJnEr6er8udNVAp.fVTM31MOSDaYO6xa3JKfYy','gabriel@loop.com.br',NULL,NULL,'analyst','2018-09-19 21:50:39',NULL,'19cf8a55-3a34-4f25-82f9-166f17757a40','female'),('8865fabd-0fac-4d4a-8324-6722ecf58b44','Teste','Teste','$2a$10$VNFSQOltkmpozsz9x.dp6OpzCVuKnw6VMg3bt.Y/oJUCtGX9uBtEa','teste6@teste.teste',NULL,'2016-01-02','analyst','2018-10-11 13:27:47',NULL,'69fabb76-6088-4673-841e-a57cf39736b6','female'),('9054aea1-eec4-48bb-b46e-de33b87100d9','Teste 4','Teste','$2a$10$L1XyRAYK4FiT5EbMkA.rs.IhekuP0OyBO7J1UklYS/QRjYzj9XlhG','teste4@teste.teste',NULL,'2000-02-27','analyst','2018-10-11 13:23:55',NULL,NULL,'female'),('a2f21212-dcbe-48c5-bed5-cacb3518af96','Teste','Teste','$2a$10$ZyDmrx.sOaDUrFoGkHw6AOK0MJWENpaiMZ2pMcTzfct4eq0AeCz12','teste5@teste.teste',NULL,'2017-02-02','manager','2018-10-11 13:26:01',NULL,NULL,'female'),('f01fc06c-6fe7-4c5e-ba6e-36aafe03fd6d','Arthur','Veríssimo','$2a$10$vmw6L5M0xcjfDBknKAUnB.z1Kq6NThXZdTN7M7e/sbmnDtra02h9S','arthur2@loop.com.br',NULL,'2000-02-28','analyst','2018-10-11 13:13:32',NULL,NULL,'female'),('f217853f-2772-4b34-8343-f8de6d0e06dd','Teste','Testinho','$2a$10$DQ/eXwXpb94IDiTfI3aOXOs1Ah6uDacOhjL.41pncZcRC9Ybnij0O','teste2@teste.teste',NULL,'2001-03-28','analyst','2018-10-11 04:14:59',NULL,NULL,'female');
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

-- Dump completed on 2018-10-31 21:54:35
