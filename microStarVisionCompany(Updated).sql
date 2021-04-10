-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 10, 2021 at 05:56 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Database: `microstarcablevision`
--
CREATE DATABASE IF NOT EXISTS `microstarcablevision` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `microstarcablevision`;

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `account_id` int(11) NOT NULL,
  `account_Status` varchar(15) NOT NULL,
  `amount_due` float NOT NULL,
  `customer_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`account_id`, `account_Status`, `amount_due`, `customer_id`) VALUES
(1, 'Active', 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `address_id` int(11) NOT NULL,
  `town` varchar(45) NOT NULL,
  `parish` varchar(45) NOT NULL,
  `street` varchar(45) NOT NULL,
  `customer_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`address_id`, `town`, `parish`, `street`, `customer_id`) VALUES
(1, 'city', 'Street', 'Country', 6),
(8, 'town', 'parish', 'street', 30);

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `bill_id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `amount` float NOT NULL,
  `due_date` datetime NOT NULL,
  `period_start` datetime NOT NULL,
  `period_end` datetime NOT NULL,
  `service_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `complaint`
--

DROP TABLE IF EXISTS `complaint`;
CREATE TABLE `complaint` (
  `complaint_id` int(11) NOT NULL,
  `type_of_issue` varchar(50) NOT NULL,
  `details_of_issue` varchar(500) DEFAULT NULL,
  `date_raised` datetime NOT NULL,
  `status` varchar(15) NOT NULL,
  `account_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `complaint`
--

INSERT INTO `complaint` (`complaint_id`, `type_of_issue`, `details_of_issue`, `date_raised`, `status`, `account_id`) VALUES
(1, 'No connection', 'red light on router', '2021-04-05 21:52:56', 'unresolved', 1);

-- --------------------------------------------------------

--
-- Table structure for table `complaintvisit`
--

DROP TABLE IF EXISTS `complaintvisit`;
CREATE TABLE `complaintvisit` (
  `complaint_id` int(11) NOT NULL,
  `visit_id` int(11) NOT NULL,
  `complaintvisit_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `contactnum`
--

DROP TABLE IF EXISTS `contactnum`;
CREATE TABLE `contactnum` (
  `contact_num` varchar(15) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `contactnum`
--

INSERT INTO `contactnum` (`contact_num`, `user_id`) VALUES
('1876564736', 1),
('876-256-2384', 30);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_id`, `email`, `address`) VALUES
(1, 'customer@mail.com', ''),
(6, 'email@server.com', NULL),
(8, 'email@server.com', NULL),
(9, 'email@server.com', NULL),
(30, 'email2@server.com', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `emp_id` int(11) NOT NULL,
  `role` varchar(50) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`emp_id`, `role`, `status`) VALUES
(31, 'Admin', 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `employeecomplaint`
--

DROP TABLE IF EXISTS `employeecomplaint`;
CREATE TABLE `employeecomplaint` (
  `emp_complaint_id` int(11) NOT NULL,
  `emp_id` int(11) NOT NULL,
  `complaint_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `employeevisit`
--

DROP TABLE IF EXISTS `employeevisit`;
CREATE TABLE `employeevisit` (
  `visit_id` int(11) NOT NULL,
  `emp_id` int(11) NOT NULL,
  `employeevisit_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `message_id` int(11) NOT NULL,
  `is_read` bit(1) NOT NULL,
  `text` varchar(500) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `sender_id` int(11) NOT NULL,
  `recipient_id` int(11) NOT NULL,
  `complaint_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`message_id`, `is_read`, `text`, `date`, `sender_id`, `recipient_id`, `complaint_id`) VALUES
(1, b'1', 'text', '2021-04-05 19:56:30', 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL,
  `payment_status` varchar(15) NOT NULL,
  `payment_due_date` datetime NOT NULL,
  `account_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `response`
--

DROP TABLE IF EXISTS `response`;
CREATE TABLE `response` (
  `response_id` int(11) NOT NULL,
  `response_date` datetime NOT NULL,
  `response_detail` varchar(1000) NOT NULL,
  `complaint_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
CREATE TABLE `service` (
  `service_id` int(11) NOT NULL,
  `type_of_service` varchar(50) NOT NULL,
  `date_initiated` datetime NOT NULL,
  `status` varchar(15) DEFAULT NULL,
  `account_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `password` varchar(500) NOT NULL,
  `username` varchar(60) DEFAULT NULL,
  `first_name` varchar(15) NOT NULL,
  `last_name` varchar(15) NOT NULL,
  `middle_name` varchar(15) NOT NULL,
  `age` int(11) NOT NULL,
  `gender` varchar(5) NOT NULL,
  `online_status` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `password`, `username`, `first_name`, `last_name`, `middle_name`, `age`, `gender`, `online_status`) VALUES
(1, 'P@ssword1', 'abi', 'Abi', 'Matthews', 'Na', 20, 'F', b'0'),
(6, 'P@ssword123', 'abi1', 'abi', 'gordon', 'middleName', 10, 'F', b'0'),
(8, 'P@ssword123', 'abi2', 'abi', 'gordon', 'middleName', 10, 'F', b'0'),
(9, 'P@ssword123', 'abi3', 'abi', 'gordon', 'middleName', 10, 'F', b'0'),
(30, 'P@ssword123', 'abi5', 'abi', 'gordon', 'middleName', 10, 'F', b'0'),
(31, 'P@ssword123', 'Admin', 'abi', 'gordon', 'middleName', 10, 'F', b'0');

-- --------------------------------------------------------

--
-- Table structure for table `visit`
--

DROP TABLE IF EXISTS `visit`;
CREATE TABLE `visit` (
  `visit_id` int(11) NOT NULL,
  `date_of_visit` datetime NOT NULL,
  `schedule_date` datetime NOT NULL,
  `complete` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`account_id`),
  ADD UNIQUE KEY `account_ID_UNIQUE` (`account_id`),
  ADD KEY `fk_account_customer_45698_idx` (`customer_id`);

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`address_id`),
  ADD UNIQUE KEY `address_ID_UNIQUE` (`address_id`),
  ADD KEY `fk_address_customer_97657_idx` (`customer_id`);

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`bill_id`),
  ADD UNIQUE KEY `bill_ID_UNIQUE` (`bill_id`),
  ADD KEY `fk_bill_service_65388_idx` (`service_id`);

--
-- Indexes for table `complaint`
--
ALTER TABLE `complaint`
  ADD PRIMARY KEY (`complaint_id`),
  ADD UNIQUE KEY `complaint_ID_UNIQUE` (`complaint_id`),
  ADD KEY `fk_complaint_account_idx` (`account_id`);

--
-- Indexes for table `complaintvisit`
--
ALTER TABLE `complaintvisit`
  ADD PRIMARY KEY (`complaintvisit_id`),
  ADD KEY `fk_complaintvisit_visit_75689_idx` (`visit_id`),
  ADD KEY `fk_complaintvisit_complaint_75365_idx` (`complaint_id`);

--
-- Indexes for table `contactnum`
--
ALTER TABLE `contactnum`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD UNIQUE KEY `customer_ID_UNIQUE` (`customer_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`emp_id`),
  ADD UNIQUE KEY `idemployee_UNIQUE` (`emp_id`);

--
-- Indexes for table `employeecomplaint`
--
ALTER TABLE `employeecomplaint`
  ADD PRIMARY KEY (`emp_complaint_id`),
  ADD UNIQUE KEY `emp_Complaint_ID_UNIQUE` (`emp_complaint_id`),
  ADD KEY `fk_employeecomplaint_complaint_85469_idx` (`emp_id`),
  ADD KEY `fk_employeecomplaint_employee_85469_idx` (`complaint_id`);

--
-- Indexes for table `employeevisit`
--
ALTER TABLE `employeevisit`
  ADD PRIMARY KEY (`employeevisit_id`),
  ADD KEY `fk_employeevisit_employee_85214_idx` (`emp_id`),
  ADD KEY `fk_employeevisit_vist_15469_idx` (`visit_id`);

--
-- Indexes for table `message`
--
ALTER TABLE `message`
  ADD UNIQUE KEY `message_ID_UNIQUE` (`message_id`),
  ADD KEY `fk_message_user_45698_idx` (`sender_id`),
  ADD KEY `fk_message_user_65878_idx` (`recipient_id`),
  ADD KEY `fk_message_complaint_15698_idx` (`complaint_id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`payment_id`),
  ADD UNIQUE KEY `payment_ID_UNIQUE` (`payment_id`),
  ADD KEY `fk_payment_account_67464_idx` (`account_id`);

--
-- Indexes for table `response`
--
ALTER TABLE `response`
  ADD PRIMARY KEY (`response_id`),
  ADD UNIQUE KEY `response_ID_UNIQUE` (`response_id`),
  ADD KEY `fk_response_complaint_47898_idx` (`complaint_id`);

--
-- Indexes for table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`service_id`),
  ADD UNIQUE KEY `service_ID_UNIQUE` (`service_id`),
  ADD KEY `fk_service_account_38481_idx` (`account_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  ADD UNIQUE KEY `username_unique_index_38455` (`username`);

--
-- Indexes for table `visit`
--
ALTER TABLE `visit`
  ADD PRIMARY KEY (`visit_id`),
  ADD UNIQUE KEY `visit_ID_UNIQUE` (`visit_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `account_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `address_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `bill_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `complaint`
--
ALTER TABLE `complaint`
  MODIFY `complaint_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `emp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `employeecomplaint`
--
ALTER TABLE `employeecomplaint`
  MODIFY `emp_complaint_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `message`
--
ALTER TABLE `message`
  MODIFY `message_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `response`
--
ALTER TABLE `response`
  MODIFY `response_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `service`
--
ALTER TABLE `service`
  MODIFY `service_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `visit`
--
ALTER TABLE `visit`
  MODIFY `visit_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `fk_account_customer_45698` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON UPDATE CASCADE;

--
-- Constraints for table `address`
--
ALTER TABLE `address`
  ADD CONSTRAINT `fk_address_customer_97657` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`);

--
-- Constraints for table `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `fk_bill_service_65388` FOREIGN KEY (`service_id`) REFERENCES `service` (`service_id`);

--
-- Constraints for table `complaint`
--
ALTER TABLE `complaint`
  ADD CONSTRAINT `fk_complaint_account_65563` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`);

--
-- Constraints for table `complaintvisit`
--
ALTER TABLE `complaintvisit`
  ADD CONSTRAINT `fk_complaintvisit_complaint_75365` FOREIGN KEY (`complaint_id`) REFERENCES `complaint` (`complaint_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_complaintvisit_visit_75689` FOREIGN KEY (`visit_id`) REFERENCES `visit` (`visit_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `contactnum`
--
ALTER TABLE `contactnum`
  ADD CONSTRAINT `fk_contactnum_user_12564` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `fk_customer_account_15648` FOREIGN KEY (`customer_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `fk_employee_user_45698` FOREIGN KEY (`emp_id`) REFERENCES `user` (`user_id`) ON UPDATE CASCADE;

--
-- Constraints for table `employeecomplaint`
--
ALTER TABLE `employeecomplaint`
  ADD CONSTRAINT `fk_employeecomplaint_employee_25154` FOREIGN KEY (`complaint_id`) REFERENCES `complaint` (`complaint_id`),
  ADD CONSTRAINT `fk_employeecomplaint_employee_85469` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `employeevisit`
--
ALTER TABLE `employeevisit`
  ADD CONSTRAINT `fk_employeevisit_employee_85214` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_employeevisit_vist_15469` FOREIGN KEY (`visit_id`) REFERENCES `visit` (`visit_id`);

--
-- Constraints for table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `fk_message_complaint_15698` FOREIGN KEY (`complaint_id`) REFERENCES `complaint` (`complaint_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_message_user_recipient_65878` FOREIGN KEY (`recipient_id`) REFERENCES `user` (`user_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_message_user_sender_45698` FOREIGN KEY (`sender_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `fk_payment_account_67464` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `response`
--
ALTER TABLE `response`
  ADD CONSTRAINT `fk_response_complaint_47898` FOREIGN KEY (`complaint_id`) REFERENCES `complaint` (`complaint_id`);

--
-- Constraints for table `service`
--
ALTER TABLE `service`
  ADD CONSTRAINT `fk_service_account_38481` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;
