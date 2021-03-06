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
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clients` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `sector_id` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `cnpj` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `clients_sectors_fk` (`sector_id`),
  CONSTRAINT `clients_sectors_fk` FOREIGN KEY (`sector_id`) REFERENCES `sectors` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES ('0f367f9f-ee15-4b66-acee-69bdd784e263','Coca Cola','coca@fake.com','f39478b9-a0cf-4a93-b444-60886a71e714','(22) 22222-22222','33.333.333/3333-333'),('166791c2-8488-4282-a669-3f19efe6ddcd','Carrefour','carrefour@fake.com','5381efae-5e8b-4e43-9853-cf35fa3a4756','(11) 11111-11111','32.333.333/3333-333'),('195785ee-3090-4d4c-85d3-254ca66ed1b8','Nestle','nestle@fake.com.br2','f39478b9-a0cf-4a93-b444-60886a71e714','(22) 22222-22222','44.444.444/4444-444'),('85397b52-8094-42fc-85b3-96e05a4f971e','Sport Club Corinthians Paulista','corinthians@sccp.com.br','5381efae-5e8b-4e43-9853-cf35fa3a4756','(00) 00000-00000','22.222.222/2222-222'),('bd969a75-1e06-480c-800a-f8b401088d70','Nike','nike@fake.com','5381efae-5e8b-4e43-9853-cf35fa3a4756','(11) 11111-11111','12.312.312/3213-122'),('cb8cf981-1428-45fd-bbcf-ae8284f751e4','USJT','usjt@fake.com.br','f39478b9-a0cf-4a93-b444-60886a71e714','(','23.784.623/8764-234');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
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
