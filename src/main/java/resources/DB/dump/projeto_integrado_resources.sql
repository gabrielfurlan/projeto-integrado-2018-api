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
-- Table structure for table `resources`
--

DROP TABLE IF EXISTS `resources`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resources` (
  `id` varchar(255) NOT NULL,
  `comment` text,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `task_id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `resources_tasks` (`task_id`),
  KEY `resourves_users` (`user_id`),
  CONSTRAINT `resources_tasks` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`id`),
  CONSTRAINT `resourves_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resources`
--

LOCK TABLES `resources` WRITE;
/*!40000 ALTER TABLE `resources` DISABLE KEYS */;
INSERT INTO `resources` VALUES ('1408fd45-489d-422f-bbd7-593b97c86be8','Teste 2','2018-10-18 23:21:26','f9c7b0f9-085b-450f-b446-a867f6ba0287','2e386116-deb4-4a1d-981f-f0268dbc47ec'),('1adc9abd-bc93-4d44-9d33-e7f008f811dc','Essa task é bem maneira','2018-10-18 22:50:28','4333db08-266a-4e3e-a4fb-5747e1dacbbc','5381efae-5e8b-4e43-9853-cf35fa3a4756'),('5f21a89c-cc45-40d0-8dcc-a861c48e4f2c','Comment too','2018-10-18 22:46:19','70769672-c486-4a2d-86d8-f6d1e8dc8959','2e386116-deb4-4a1d-981f-f0268dbc47ec'),('68c6ef20-0ce0-4d9c-9211-5690530a090b','Teste 3','2018-10-18 23:21:52','f9c7b0f9-085b-450f-b446-a867f6ba0287','5fd26220-6c08-4a01-acf2-96c2d8470d81'),('828a6362-2ba1-41e4-8a90-caed38816d8e','Respondendo esse mussum ipsum maneiro','2018-10-18 17:42:16','46c0f10c-33ce-4655-9721-af652416e56d','5fd26220-6c08-4a01-acf2-96c2d8470d81'),('9a86031c-cf02-4a19-a23c-f80c99a44dd1','Test comment','2018-10-18 22:45:40','70769672-c486-4a2d-86d8-f6d1e8dc8959','5fd26220-6c08-4a01-acf2-96c2d8470d81'),('9c67e7ab-d214-40db-a020-72dfd6bf210d','Outro teste 2','2018-10-18 16:50:15','46c0f10c-33ce-4655-9721-af652416e56d','5381efae-5e8b-4e43-9853-cf35fa3a4756'),('a5ddae6e-26b7-494a-825a-747fa820f3e8','Teste 1','2018-10-18 23:21:18','f9c7b0f9-085b-450f-b446-a867f6ba0287','2e386116-deb4-4a1d-981f-f0268dbc47ec'),('bf52c1e1-e69c-461d-8808-847d4988869e','Mussum Ipsum, cacilds vidis litro abertis. Nullam volutpat risus nec leo commodo, ut interdum diam laoreet. Sed non consequat odio. Quem manda na minha terra sou euzis! Quem num gosta di mé, boa gentis num é. Si u mundo tá muito paradis? Toma um mé que o mundo vai girarzis! ','2018-10-18 17:18:10','46c0f10c-33ce-4655-9721-af652416e56d','5381efae-5e8b-4e43-9853-cf35fa3a4756'),('cf2037ed-fd74-4e28-8f54-8884555ae6cc','Outro teste','2018-10-18 16:41:47','46c0f10c-33ce-4655-9721-af652416e56d','5381efae-5e8b-4e43-9853-cf35fa3a4756'),('dcce71a5-3d1a-43e0-9f8b-5981fcb41d02','Realmente esse mussum é bem maneiro!','2018-10-18 17:43:07','46c0f10c-33ce-4655-9721-af652416e56d','2e386116-deb4-4a1d-981f-f0268dbc47ec'),('fdca1c0a-1f50-47a1-8481-4192d9115a57','Teste ','2018-10-18 17:17:02','46c0f10c-33ce-4655-9721-af652416e56d','5381efae-5e8b-4e43-9853-cf35fa3a4756'),('ff80944f-cf07-4bf7-8c61-6260c64fb165','Teste testinho','2018-10-18 15:45:46','46c0f10c-33ce-4655-9721-af652416e56d','5381efae-5e8b-4e43-9853-cf35fa3a4756');
/*!40000 ALTER TABLE `resources` ENABLE KEYS */;
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
