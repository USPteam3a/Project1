-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 13 дек 2018 в 12:20
-- Версия на сървъра: 10.1.34-MariaDB
-- PHP Version: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `anika`
--

-- --------------------------------------------------------

--
-- Структура на таблица `registration`
--

CREATE TABLE `registration` (
  `reg_id` int(11) NOT NULL,
  `name` text NOT NULL,
  `phone` text NOT NULL,
  `country` text NOT NULL,
  `city` text NOT NULL,
  `date` text NOT NULL,
  `nights` int(11) NOT NULL,
  `room_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Схема на данните от таблица `registration`
--

INSERT INTO `registration` (`reg_id`, `name`, `phone`, `country`, `city`, `date`, `nights`, `room_id`) VALUES
(1, 'Anika Peneva', '+359 000000000', 'Bulgaria', 'Varna', '02-03-2017', 5, 5),
(2, 'Ivan Ivanov', '+359 000000000', 'Bulgaria', 'Plovdiv', '02-03-2017', 2, 15),
(3, 'Mladen Mladenov', '089 0000000', 'Bulgaria', 'Pleven', '02-03-2017', 5, 6),
(4, 'Yoana Ivanova', '+359895232222', 'Bulgaria', 'Ruse', '01-01-2018', 5, 14),
(5, 'Bojidar Stoyanov', '+359896222222', 'Bulgaria', 'Gorna Oryahovica', '10-05-2017', 6, 1),
(6, 'Kaloyan Ivanov', '+359789222269', 'Bulgaria', 'Popovo', '10-05-2018', 3, 18),
(7, 'Polina Andreeva', '+359899111111', 'Bulgaria', 'Shumen', '12-05-2018', 3, 2),
(8, 'Denica Svilenova', '+359899666666', 'Bulgaria', 'Shumen', '03-08-2018', 6, 3),
(9, 'Kristina Topal', '+359789666333', 'Ukraine', 'Odessa', '10-12-2018', 4, 10),
(10, 'Ognyan Dosev', '+359888444444', 'Bulgaria', 'Varna', '05-10-2017', 10, 3);

-- --------------------------------------------------------

--
-- Структура на таблица `room`
--

CREATE TABLE `room` (
  `room_id` int(11) NOT NULL,
  `room_number` int(11) NOT NULL,
  `type_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Схема на данните от таблица `room`
--

INSERT INTO `room` (`room_id`, `room_number`, `type_id`) VALUES
(1, 101, 1),
(2, 102, 1),
(3, 103, 1),
(4, 104, 1),
(5, 105, 2),
(6, 106, 2),
(7, 107, 2),
(8, 108, 2),
(9, 109, 3),
(10, 110, 3),
(11, 201, 2),
(12, 202, 2),
(13, 203, 2),
(14, 204, 2),
(15, 205, 3),
(16, 206, 3),
(17, 207, 3),
(18, 208, 3),
(19, 209, 4),
(20, 210, 4),
(21, 301, 2),
(22, 302, 2),
(23, 303, 3),
(24, 304, 3),
(25, 305, 3),
(26, 306, 3),
(27, 307, 3),
(28, 308, 3),
(29, 309, 4),
(30, 310, 4);

-- --------------------------------------------------------

--
-- Структура на таблица `roomtype`
--

CREATE TABLE `roomtype` (
  `type_id` int(11) NOT NULL,
  `room_type` text NOT NULL,
  `room_price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Схема на данните от таблица `roomtype`
--

INSERT INTO `roomtype` (`type_id`, `room_type`, `room_price`) VALUES
(1, 'Single room', 50),
(2, 'Double room', 80),
(3, 'Triple room', 110),
(4, 'Apartment', 150);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `registration`
--
ALTER TABLE `registration`
  ADD PRIMARY KEY (`reg_id`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`room_id`);

--
-- Indexes for table `roomtype`
--
ALTER TABLE `roomtype`
  ADD PRIMARY KEY (`type_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `registration`
--
ALTER TABLE `registration`
  MODIFY `reg_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `room_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `roomtype`
--
ALTER TABLE `roomtype`
  MODIFY `type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
