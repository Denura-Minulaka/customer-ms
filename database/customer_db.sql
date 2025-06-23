-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:4306
-- Generation Time: Jun 23, 2025 at 11:21 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `customer_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `contact` varchar(10) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `fname`, `lname`, `contact`, `username`, `password`) VALUES
(6, 'ransilu', 'ranasingha', '0748979981', 'Ransilu', '$2a$10$eyRaQXr3qZATbk93vuLkhOg0AyA5mcRNjmvS7l6gw4sq8S06XaaR2'),
(7, 'senan', 'thenuka', '0788979981', 'Sthenuka000', '$2a$10$jQq2w0b3gSeNqfelXzBtyOBtHGffKBnLXq6rRIl/gtVzyJ/XqkU1O'),
(8, 'Hemantha', 'Sathpium', '0786666666', 'Hemantha', '$2a$10$59VdHOmzTsv4gZOCr8zGRetXJtJFmDMzJEwdbXthSrBHXeFW2GyhW'),
(9, 'akinda', 'nimdiya', '0776666666', 'Akinda', '$2a$10$ykJnjHAempPgKlkz2eVHKOC1xrgewYA42LqQBoej3l8vKLoLImqtW'),
(10, 'akinda', 'nimdiya', '0776666666', 'Akinda9', '$2a$10$GWjszVa9HXga2KAZGtFiSeGWJNr7eZcQpdtZhsBQrL9JxRF5JZhiW'),
(11, 'Supun', 'Kalhara', '0706666666', 'Supun', '$2a$10$N4waIxvMXShay0PZvfGsZux94oTPc18l6WBdFD8hYMVRMHOTXjYVK'),
(12, 'Supun', 'Kalhara', '0706666666', 'Supun1', '$2a$10$yWX3MnGz54ETJmjPc6KfPeSrZeG6mjBnjO2bwoXdKbSjAyAX5mCQe'),
(13, 'Supun', 'Kalhara', '0706666666', 'Supun123', '$2a$10$uXV5pPmN11Tddy2WQN2IxuRImSxMZJL6XHgX0wXrc8rZI19aFUXWq'),
(14, 'Supun', 'Kalhara', '0706666666', 'Supunjj11', '$2a$10$T99zBSsHdfrzrlwBfThWae1UWZiY7nGn2vwQzPlQWSEnjhdyXGxFu'),
(15, 'Vihanha', 'Sendanayaka', '0767666666', 'Viha', '$2a$10$2egszSoFtr9SWTn7PPGyreBT0Juo0O94Ryw1XmG92vHzz1CO0Vsau'),
(16, 'Hasindu', 'Eshan', '0788888888', 'Hasindu10', '$2a$10$r07qV642IELUbo8m8DH97OjLg74vFlHFiRUiLJQMuUmCxFx9eqQ12'),
(17, 'Kasun', 'Kalhara', '0788888888', 'Hiruna', '$2a$10$lNmoBS3RvAWvCT9elO6d2OWN9tFmzjYhIgNueg0m356OlpTg5TW5a'),
(18, 'Kasun', 'Kalhara', '0788888888', 'Kasun123', '$2a$10$JNGJRgb0SppMyUWb0w44XeUBZDC6c4YShVTeOr4zvPqc6J9eWqKpe'),
(19, 'Kasun', 'Kalhara', '0788808888', 'Kasun000000', '$2a$10$uXz7Tgh4LcXUi4lGtYWVDuBECSHbnVyjuIrDt7LtDFVQrlxo5CwpK'),
(20, 'Kasun', 'Kalhara', '0788808888', 'Kasun11111', '$2a$10$F5tTbQUYlr9YNGPMykIA5esZCb47tU6DvyoCJTNsNEidj8ZYkemOC'),
(21, 'Tharindu', 'Chamara', '0709999999', 'Tharindu', '$2a$10$XJ3BphwQRbfSdAV0uH37a.f89.gxkz6iD/oAr2C9YJlDqRcSuXb9i'),
(22, 'senan', 'thenuka', '0788979981', 'Sthenuka', '$2a$10$ymfYj4H8O4kqoDvbBIMd9ufE1TemKba.dRJ7Y4vnuN1qFMthoPbWu'),
(23, 'senan', 'thenuka', '0788979981', 'thenuka', '$2a$10$sn47j.f1urQEbfnWmSzYCOlRt5hIo2Dl9nvX.CQCX6dpmhnoyCOsm');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
