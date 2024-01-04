-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 23, 2021 at 05:45 PM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventory_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `inventories`
--

CREATE TABLE `inventories` (
  `inventory_id` int(11) NOT NULL,
  `inventory_name` int(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `manager_id` int(45) DEFAULT NULL,
  `supplier_id` int(45) DEFAULT NULL,
  `warehouse_id` int(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `order_details`
--

CREATE TABLE `order_details` (
  `order_detail_id` int(11) NOT NULL,
  `order_detail_quantity` int(11) DEFAULT NULL,
  `inventory_id` int(45) DEFAULT NULL,
  `order_id` int(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `stocks`
--

CREATE TABLE `stocks` (
  `stock_id` int(11) NOT NULL,
  `inventory_id` int(45) DEFAULT NULL,
  `warehouse_id` int(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` varchar(10) NOT NULL,
  `user_username` varchar(45) DEFAULT NULL,
  `user_password` varchar(100) DEFAULT NULL,
  `user_email` varchar(45) DEFAULT NULL,
  `user_role` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `user_username`, `user_password`, `user_email`, `user_role`) VALUES
('US36a2a217', 'sricomputer', '34892d7f124bf9302d26270c256fbb77179525b48763b9bff53b4b2fa9374288', 'allit@gmail.com', 'SUPPLIER'),
('US4cea6497', 'allit', '9b421fdd12b57c57f37cacebabd7162370acc8590aa0ed124ce6b6f2a423f6ce', 'allit@gmail.com', 'SUPPLIER'),
('US5168b0e7', 'peach2', '85356064d03872ac4bed179b8bbe8318ab67a9626be55d0d72288ee14e165265', 'peach@gmail.com', 'STAFF'),
('US7a1a7b32', 'eli2', '27037fccea3062ee8ebaea07a9e2bf8dcb6511fd860ae993442aee0c512b8bbf', 'eee', 'STAFF'),
('US91375c5d', 'peach', '27037fccea3062ee8ebaea07a9e2bf8dcb6511fd860ae993442aee0c512b8bbf', 'eee', 'SUPPLIER'),
('US9f16f937', 'kim', '26ae784d194a5760464348329af4eb9fca2b27bbf823742c968a61543e3a1153', 'kim@gmail.com', 'MANAGER'),
('UScb7b15dd', 'eli', '27037fccea3062ee8ebaea07a9e2bf8dcb6511fd860ae993442aee0c512b8bbf', 'eliwoo@gmail.com', 'MANAGER'),
('USd4c19c3d', 'peach3', '85356064d03872ac4bed179b8bbe8318ab67a9626be55d0d72288ee14e165265', 'peach@gmail.com', 'SUPPLIER');

-- --------------------------------------------------------

--
-- Table structure for table `warehouses`
--

CREATE TABLE `warehouses` (
  `warehouse_id` int(11) NOT NULL,
  `warehouse_location` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `inventories`
--
ALTER TABLE `inventories`
  ADD PRIMARY KEY (`inventory_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `manager_id` (`manager_id`),
  ADD KEY `supplier_id` (`supplier_id`),
  ADD KEY `warehouse_id` (`warehouse_id`);

--
-- Indexes for table `order_details`
--
ALTER TABLE `order_details`
  ADD PRIMARY KEY (`order_detail_id`),
  ADD KEY `inventory_id` (`inventory_id`),
  ADD KEY `order_id` (`order_id`);

--
-- Indexes for table `stocks`
--
ALTER TABLE `stocks`
  ADD PRIMARY KEY (`stock_id`),
  ADD KEY `inventory_id` (`inventory_id`),
  ADD KEY `warehouse_id` (`warehouse_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `warehouses`
--
ALTER TABLE `warehouses`
  ADD PRIMARY KEY (`warehouse_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouses` (`warehouse_id`);

--
-- Constraints for table `order_details`
--
ALTER TABLE `order_details`
  ADD CONSTRAINT `order_details_ibfk_1` FOREIGN KEY (`inventory_id`) REFERENCES `inventories` (`inventory_id`),
  ADD CONSTRAINT `order_details_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`);

--
-- Constraints for table `stocks`
--
ALTER TABLE `stocks`
  ADD CONSTRAINT `stocks_ibfk_1` FOREIGN KEY (`inventory_id`) REFERENCES `inventories` (`inventory_id`),
  ADD CONSTRAINT `stocks_ibfk_2` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouses` (`warehouse_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
