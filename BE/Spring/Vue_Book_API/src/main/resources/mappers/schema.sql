create database if not exists ssafyshop;
use ssafyshop;

drop table book;

CREATE TABLE `book` (
  `isbn` char(12) NOT NULL,
  `title` varchar(100) NOT NULL,
  `author` varchar(50) NOT NULL,
  `price` int NOT NULL,
  `content` text,
  `img` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;