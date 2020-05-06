-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2020 at 07:54 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospital`
--

-- --------------------------------------------------------

--
-- Table structure for table `hospital`
--

CREATE TABLE `hospital` (
  `hpID` int(11) NOT NULL,
  `hpCode` varchar(5) NOT NULL,
  `hpName` varchar(30) NOT NULL,
  `hpTp` varchar(10) NOT NULL,
  `hpAddress` varchar(50) NOT NULL,
  `hpDoc` varchar(30) NOT NULL,
  `hpDesc` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hospital`
--

INSERT INTO `hospital` (`hpID`, `hpCode`, `hpName`, `hpTp`, `hpAddress`, `hpDoc`, `hpDesc`) VALUES
(1, 'ddd', 'dddd', 'ddd', 'ddd', 'ddd', 'dd11'),
(5, 'ddd', 'dddd', 'ddd', 'dddd', 'ddd', 'iuh8h8'),
(6, 'ddd', 'dddd', 'ddd', 'dddd', 'ddd', 'dxqwdqwd'),
(7, 'ddd', 'dddd', 'ddd', 'ddd', 'ddd', 'dddd'),
(8, 'wq', 'qws', 'dwqdd', 'ddd', 'ddd', 'dddd');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hospital`
--
ALTER TABLE `hospital`
  ADD PRIMARY KEY (`hpID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hospital`
--
ALTER TABLE `hospital`
  MODIFY `hpID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
