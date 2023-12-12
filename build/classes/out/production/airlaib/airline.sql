SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+05:00";

--
-- Database: `airline`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `nic` varchar(255) NOT NULL,
  `passport` varchar(255) NOT NULL,
  `address` text NOT NULL,
  `dob` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `contact` varchar(255) NOT NULL,
  `photo` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `flight`
--

CREATE TABLE `flight` (
  `id` varchar(255) NOT NULL,
  `flightname` varchar(255) NOT NULL,
  `source` varchar(255) NOT NULL,
  `depart` varchar(255) NOT NULL,
  `deptime` varchar(255) NOT NULL,
  `arrtime` varchar(255) NOT NULL,
  `flightcharge` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `flight`
--

INSERT INTO `flight` (`id`, `flightname`, `source`,`depart`, `deptime`, `arrtime`, `flightcharge`) VALUES
('FO004', 'JetLine', 'Pakistan', 'Uk', '8.00AM', '10.00PM', '50000'),
('FO005', 'Marine', 'Pakistan', 'China', '8.00PM', '2.00AM', '15000'),	
('FO006', 'Melanka', 'Pakistan', 'Srilanka', '9.00AM', '10.00AM', '9000'),
('FO007', 'JetLine', 'Pakistan', 'USA', '8.00AM', '10.00PM', '50000'),
('FO008', 'Marine', 'Pakistan', 'Canada', '8.00PM', '2.00AM', '15000'),	
('FO009', 'Melanka', 'UK', 'Srilanka', '9.00AM', '10.00AM', '9000'),
('FO010', 'JetLine', 'UK', 'Pakistan', '8.00AM', '10.00PM', '50000'),
('FO011', 'Marine', 'UK', 'China', '8.00PM', '2.00AM', '15000'),	
('FO012', 'Melanka', 'UK', 'Canada', '9.00AM', '10.00AM', '9000'),
('FO013', 'Melanka', 'UK', 'Srilanka', '9.00AM', '10.00AM', '9000'),
('FO014', 'JetLine', 'UK', 'Pakistan', '8.00AM', '10.00PM', '50000'),
('FO015', 'Marine', 'UK', 'USA', '8.00PM', '2.00AM', '15000'),	
('FO016', 'Melanka', 'USA', 'UK', '9.00AM', '10.00AM', '9000'),
('FO017', 'Melanka', 'USA', 'Srilanka',  '9.00AM', '10.00AM', '9000'),
('FO018', 'JetLine', 'USA', 'Pakistan', '8.00AM', '10.00PM', '50000'),
('FO019', 'Marine', 'USA', 'China',  '8.00PM', '2.00AM', '15000'),	
('FO020', 'Melanka', 'USA', 'Canada',  '9.00AM', '10.00AM', '9000'),
('FO021', 'Melanka', 'China', 'UK',  '9.00AM', '10.00AM', '9000'),
('FO022', 'Melanka', 'China', 'Srilanka',  '9.00AM', '10.00AM', '9000'),
('FO023', 'JetLine', 'China', 'Pakistan', '8.00AM', '10.00PM', '50000'),
('FO024', 'Marine', 'China', 'USA', '8.00PM', '2.00AM', '15000'),	
('FO025', 'Melanka', 'China', 'Canada', '9.00AM', '10.00AM', '9000'),
('FO026', 'Melanka', 'Canada', 'UK','9.00AM', '10.00AM', '9000'),
('FO027', 'Melanka', 'Canada', 'Srilanka','9.00AM', '10.00AM', '9000'),
('FO028', 'JetLine', 'Canada', 'Pakistan','8.00AM', '10.00PM', '50000'),
('FO029', 'Marine', 'Canada', 'China', '8.00PM', '2.00AM', '15000'),	
('FO030', 'Melanka', 'Canada', 'USA','9.00AM', '10.00AM', '9000'),
('FO031', 'Melanka', 'Srilanka', 'UK','9.00AM', '10.00AM', '9000'),
('FO032', 'Melanka', 'Srilanka', 'USA', '9.00AM', '10.00AM', '9000'),
('FO033', 'JetLine', 'Srilanka', 'Pakistan','8.00AM', '10.00PM', '50000'),
('FO034', 'Marine', 'Srilanka', 'China', '8.00PM', '2.00AM', '15000'),	
('FO035', 'Melanka', 'Srilanka', 'Canada','9.00AM', '10.00AM', '9000');

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `id` varchar(255) NOT NULL,
  `flightid` varchar(255) NOT NULL,
  `flightname` varchar(255) NOT NULL,
  `custid` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `passport` varchar(255) NOT NULL,
  `class` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `seats` int(11) NOT NULL,
  `date` varchar(255) NOT NULL,
  `deptime` varchar(255) NOT NULL,
  `arrtime` varchar(255) NOT NULL,
  `source` varchar(255) NOT NULL,
  `depart` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `firstname`, `lastname`, `username`, `password`) VALUES
('UO001', 'Abdullah', 'Tahir', 'abdullah', '123'),
('UO002', 'Imaan', 'Ibrar', 'imaan', '123'),
('UO003', 'Laiba', 'Atiq', 'laiba', '123');
INSERT INTO `user` (`id`, `firstname`, `lastname`, `username`, `password`) VALUES
('UO004', 'Ahsan', 'Saadat', 'ahsan', '123');


COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
Select * from user;
Select * from flight;

DROP table `flight`;

Select * from customer;