-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: microstarcablevision
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `account_ID` int NOT NULL AUTO_INCREMENT,
  `account_Status` varchar(15) NOT NULL,
  `amount_Due` float NOT NULL,
  `payment_ID` int NOT NULL,
  `compalint_ID` int NOT NULL,
  `service_ID` int NOT NULL,
  UNIQUE KEY `account_ID_UNIQUE` (`account_ID`),
  KEY `fk_account_complaint_48865_idx` (`compalint_ID`),
  KEY `fk_account_payment_85469_idx` (`payment_ID`),
  KEY `fk_account_service_17469_idx` (`service_ID`),
  CONSTRAINT `fk_account_complaint_48865` FOREIGN KEY (`compalint_ID`) REFERENCES `complaint` (`compalint_ID`),
  CONSTRAINT `fk_account_customer_25469` FOREIGN KEY (`account_ID`) REFERENCES `customer` (`customer_ID`),
  CONSTRAINT `fk_account_payment_85469` FOREIGN KEY (`payment_ID`) REFERENCES `payment` (`payment_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_account_service_17469` FOREIGN KEY (`service_ID`) REFERENCES `service` (`service_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `address_ID` int NOT NULL AUTO_INCREMENT,
  `town` varchar(45) NOT NULL,
  `parish` varchar(45) NOT NULL,
  `street` varchar(45) NOT NULL,
  PRIMARY KEY (`address_ID`),
  UNIQUE KEY `address_ID_UNIQUE` (`address_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `bill_ID` int NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `amount` float NOT NULL,
  `due` datetime NOT NULL,
  `service_ID` int DEFAULT NULL,
  PRIMARY KEY (`bill_ID`),
  UNIQUE KEY `bill_ID_UNIQUE` (`bill_ID`),
  KEY `fk_bill_service_65388_idx` (`service_ID`),
  CONSTRAINT `fk_bill_service_65388` FOREIGN KEY (`service_ID`) REFERENCES `service` (`service_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `complaint`
--

DROP TABLE IF EXISTS `complaint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `complaint` (
  `compalint_ID` int NOT NULL AUTO_INCREMENT,
  `status` varchar(15) NOT NULL,
  `type_Of_Issue` varchar(50) NOT NULL,
  `date_Of_Issue` datetime NOT NULL,
  `account_ID` int NOT NULL,
  PRIMARY KEY (`compalint_ID`),
  UNIQUE KEY `compalint_ID_UNIQUE` (`compalint_ID`),
  KEY `fk_compaint_account_idx` (`account_ID`),
  CONSTRAINT `fk_compaint_account_65563` FOREIGN KEY (`account_ID`) REFERENCES `account` (`account_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complaint`
--

LOCK TABLES `complaint` WRITE;
/*!40000 ALTER TABLE `complaint` DISABLE KEYS */;
/*!40000 ALTER TABLE `complaint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `complaintvisit`
--

DROP TABLE IF EXISTS `complaintvisit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `complaintvisit` (
  `compaint_Visit_ID` int NOT NULL AUTO_INCREMENT,
  `complaint_ID` int NOT NULL,
  `visit_ID` int NOT NULL,
  PRIMARY KEY (`complaint_ID`),
  UNIQUE KEY `compaint_Visit_ID_UNIQUE` (`compaint_Visit_ID`),
  KEY `fk_complaintvisit_visit_75689_idx` (`visit_ID`),
  CONSTRAINT `fk_complaintvisit_complaint_75365` FOREIGN KEY (`complaint_ID`) REFERENCES `complaint` (`compalint_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_complaintvisit_visit_75689` FOREIGN KEY (`visit_ID`) REFERENCES `visit` (`visit_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complaintvisit`
--

LOCK TABLES `complaintvisit` WRITE;
/*!40000 ALTER TABLE `complaintvisit` DISABLE KEYS */;
/*!40000 ALTER TABLE `complaintvisit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contactnum`
--

DROP TABLE IF EXISTS `contactnum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contactnum` (
  `contact_Num` int NOT NULL AUTO_INCREMENT,
  `user_ID` int NOT NULL,
  PRIMARY KEY (`user_ID`),
  UNIQUE KEY `contact_Num_UNIQUE` (`contact_Num`),
  CONSTRAINT `fk_contactnum_user_12564` FOREIGN KEY (`user_ID`) REFERENCES `user` (`user_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contactnum`
--

LOCK TABLES `contactnum` WRITE;
/*!40000 ALTER TABLE `contactnum` DISABLE KEYS */;
/*!40000 ALTER TABLE `contactnum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_ID` int NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `account_ID` int NOT NULL,
  PRIMARY KEY (`customer_ID`),
  UNIQUE KEY `customer_ID_UNIQUE` (`customer_ID`),
  CONSTRAINT `fk_customer_account_15648` FOREIGN KEY (`customer_ID`) REFERENCES `account` (`account_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `emp_ID` int NOT NULL AUTO_INCREMENT,
  `role` varchar(50) NOT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`emp_ID`),
  UNIQUE KEY `idemployee_UNIQUE` (`emp_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employeecomplaint`
--

DROP TABLE IF EXISTS `employeecomplaint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employeecomplaint` (
  `emp_Complaint_ID` int NOT NULL AUTO_INCREMENT,
  `emp_ID` int NOT NULL,
  `complaint_ID` int NOT NULL,
  UNIQUE KEY `emp_Complaint_ID_UNIQUE` (`emp_Complaint_ID`),
  KEY `fk_employeecomplaint_complaint_85469_idx` (`emp_ID`),
  KEY `fk_employeecomplaint_employee_85469_idx` (`complaint_ID`),
  CONSTRAINT `fk_employeecomplaint_employee_25154` FOREIGN KEY (`complaint_ID`) REFERENCES `complaint` (`compalint_ID`),
  CONSTRAINT `fk_employeecomplaint_employee_85469` FOREIGN KEY (`emp_ID`) REFERENCES `employee` (`emp_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employeecomplaint`
--

LOCK TABLES `employeecomplaint` WRITE;
/*!40000 ALTER TABLE `employeecomplaint` DISABLE KEYS */;
/*!40000 ALTER TABLE `employeecomplaint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employeevisit`
--

DROP TABLE IF EXISTS `employeevisit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employeevisit` (
  `employee_Visit_ID` int NOT NULL AUTO_INCREMENT,
  `visit_ID` int NOT NULL,
  `emp_ID` int NOT NULL,
  PRIMARY KEY (`visit_ID`),
  UNIQUE KEY `empoayee_Visit_ID_UNIQUE` (`employee_Visit_ID`),
  KEY `fk_employeevisit_employee_85214_idx` (`emp_ID`),
  CONSTRAINT `fk_employeevisit_employee_85214` FOREIGN KEY (`emp_ID`) REFERENCES `employee` (`emp_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_employeevisit_vist_15469` FOREIGN KEY (`visit_ID`) REFERENCES `visit` (`visit_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employeevisit`
--

LOCK TABLES `employeevisit` WRITE;
/*!40000 ALTER TABLE `employeevisit` DISABLE KEYS */;
/*!40000 ALTER TABLE `employeevisit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
  `message_ID` int NOT NULL AUTO_INCREMENT,
  `read` bit(1) NOT NULL,
  `text` varchar(500) NOT NULL,
  `date` datetime NOT NULL,
  `user_ID` int NOT NULL,
  PRIMARY KEY (`message_ID`),
  UNIQUE KEY `message_ID_UNIQUE` (`message_ID`),
  CONSTRAINT `fk_message_user_45698` FOREIGN KEY (`message_ID`) REFERENCES `user` (`user_ID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `payment_ID` int NOT NULL AUTO_INCREMENT,
  `payment_Status` varchar(15) NOT NULL,
  `payment_Due_Date` datetime NOT NULL,
  PRIMARY KEY (`payment_ID`),
  UNIQUE KEY `payment_ID_UNIQUE` (`payment_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `response`
--

DROP TABLE IF EXISTS `response`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `response` (
  `response_ID` int NOT NULL AUTO_INCREMENT,
  `response_Date` datetime NOT NULL,
  PRIMARY KEY (`response_ID`),
  UNIQUE KEY `response_ID_UNIQUE` (`response_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `response`
--

LOCK TABLES `response` WRITE;
/*!40000 ALTER TABLE `response` DISABLE KEYS */;
/*!40000 ALTER TABLE `response` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service` (
  `service_ID` int NOT NULL AUTO_INCREMENT,
  `type_Of_Service` varchar(50) NOT NULL,
  `bill_ID` int NOT NULL,
  PRIMARY KEY (`service_ID`),
  UNIQUE KEY `service_ID_UNIQUE` (`service_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `technician`
--

DROP TABLE IF EXISTS `technician`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `technician` (
  `tech_ID` int NOT NULL AUTO_INCREMENT,
  `session` varchar(20) NOT NULL,
  `available_Session` bit(1) NOT NULL,
  PRIMARY KEY (`tech_ID`),
  UNIQUE KEY `tech_ID_UNIQUE` (`tech_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `technician`
--

LOCK TABLES `technician` WRITE;
/*!40000 ALTER TABLE `technician` DISABLE KEYS */;
/*!40000 ALTER TABLE `technician` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_ID` int NOT NULL AUTO_INCREMENT,
  `contact_Num` int NOT NULL,
  `password` varchar(500) NOT NULL,
  `first_Name` varchar(15) NOT NULL,
  `last_Name` varchar(15) NOT NULL,
  `middle_Name` varchar(15) NOT NULL,
  `age` int NOT NULL,
  `gender` varchar(5) NOT NULL,
  PRIMARY KEY (`user_ID`),
  UNIQUE KEY `user_ID_UNIQUE` (`user_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visit`
--

DROP TABLE IF EXISTS `visit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visit` (
  `visit_ID` int NOT NULL AUTO_INCREMENT,
  `date_Of_Visit` datetime NOT NULL,
  `schedule_Date` datetime NOT NULL,
  `complete` bit(1) NOT NULL,
  PRIMARY KEY (`visit_ID`),
  UNIQUE KEY `visit_ID_UNIQUE` (`visit_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visit`
--

LOCK TABLES `visit` WRITE;
/*!40000 ALTER TABLE `visit` DISABLE KEYS */;
/*!40000 ALTER TABLE `visit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-06 18:59:47
