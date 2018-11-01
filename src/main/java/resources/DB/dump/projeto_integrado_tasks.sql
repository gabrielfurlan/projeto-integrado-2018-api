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
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tasks` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` text,
  `assign_to` varchar(255) DEFAULT NULL,
  `estimated_time` int(2) DEFAULT '1',
  `priority` varchar(255) DEFAULT 'low',
  `project_id` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` varchar(255) DEFAULT 'to-do',
  PRIMARY KEY (`id`),
  KEY `tasks_projects_fk` (`project_id`),
  KEY `tasks_analysts_fk` (`assign_to`),
  CONSTRAINT `tasks_analysts_fk` FOREIGN KEY (`assign_to`) REFERENCES `analysts` (`id`),
  CONSTRAINT `tasks_projects_fk` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` VALUES ('1ba21fa7-8289-40b4-8f84-b269d9ccf3d1','Teste','',NULL,0,'low','421904a5-e5ea-4e27-b330-446a081fe613','2018-10-11 22:22:47',NULL),('3b980ceb-d12f-4c2a-b18f-02286db980dc','Teste','',NULL,0,'low','421904a5-e5ea-4e27-b330-446a081fe613','2018-10-11 22:23:28',NULL),('4333db08-266a-4e3e-a4fb-5747e1dacbbc','Login','Fazer um login com validação de email ou username junto com password.\n\nTratar as errors caso esteja vazio o nome email/username, esteja vazio o password ou validação não válida. ',NULL,0,'low','6b95432e-df04-4868-94e0-3ae99ae4eceb','2018-10-18 22:50:09','in-progress'),('46c0f10c-33ce-4655-9721-af652416e56d','Teste I','Teste do teste do testes.',NULL,0,'high','421904a5-e5ea-4e27-b330-446a081fe613','2018-10-11 23:09:51','qa'),('47a4acd5-0d65-41b4-a6f6-c5f386a09c22','Teste','Te',NULL,0,'low','421904a5-e5ea-4e27-b330-446a081fe613','2018-10-11 22:18:56',NULL),('4896d862-e401-4ae9-b501-0bba7f08921d','Teste III','',NULL,0,'low','421904a5-e5ea-4e27-b330-446a081fe613','2018-10-11 22:30:03',NULL),('70769672-c486-4a2d-86d8-f6d1e8dc8959','Teste X','',NULL,0,'low','421904a5-e5ea-4e27-b330-446a081fe613','2018-10-11 22:45:57','to-do'),('952f330f-a8a2-4b43-bb59-e1533a0d741e','Teste','asdsa',NULL,0,'low','421904a5-e5ea-4e27-b330-446a081fe613','2018-10-11 22:14:35',NULL),('99203ffa-e823-4609-b2f1-764c5ebbaefb','Teste IV','Teste',NULL,0,'low','421904a5-e5ea-4e27-b330-446a081fe613','2018-10-11 22:30:18',NULL),('9acb4faf-0b4b-4571-9831-3e304211123f','Teste','',NULL,0,'low','421904a5-e5ea-4e27-b330-446a081fe613','2018-10-11 22:26:21',NULL),('aed6961f-31ba-48e2-806e-7fda9a4a7668','Teste II','Teste',NULL,0,'low','421904a5-e5ea-4e27-b330-446a081fe613','2018-10-11 22:29:38',NULL),('bacd0660-3de9-4338-b11e-94c030b26e13','Teste','asdsad\n',NULL,0,'low','421904a5-e5ea-4e27-b330-446a081fe613','2018-10-11 22:20:57',NULL),('e546b63b-ef72-4b41-ac92-7771775f89c4','Teste !','',NULL,0,'low','e86acea3-a2b2-40ce-b88d-ec3d787f9e2b','2018-10-15 03:16:35','to-do'),('f9c7b0f9-085b-450f-b446-a867f6ba0287','Tarefa I','teste',NULL,0,'high','c6fa60e3-8977-4a8a-94b7-f695d4241679','2018-10-18 23:20:50','qa');
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
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
