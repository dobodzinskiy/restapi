create DATABASE hotels;
use hotels;

DROP TABLE IF EXISTS `booking`;
CREATE TABLE `booking` (
  `booking_id` int(11) NOT NULL AUTO_INCREMENT,
  `room_id` int(11) NOT NULL,
  `booking_start` datetime NOT NULL,
  `booking_end` datetime NOT NULL,
  `booking_name` varchar(100) NOT NULL,
  `booking_last_name` varchar(100) NOT NULL,
  `booking_phone` varchar(100) NOT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `booking_room_room_id_fk` (`room_id`),
  CONSTRAINT `booking_room_room_id_fk` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `check_in`;
CREATE TABLE `check_in` (
  `hotel_id` int(11) NOT NULL,
  `check_in_date` date NOT NULL,
  KEY `check_in_hotel_hotel_id_fk` (`hotel_id`),
  CONSTRAINT `check_in_hotel_hotel_id_fk` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`hotel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `hotel_id` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_name` varchar(100) NOT NULL,
  `hotel_type` varchar(100) NOT NULL,
  `hotel_pool` varchar(5) NOT NULL DEFAULT '\0',
  `hotel_slides` varchar(5) NOT NULL DEFAULT '\0',
  `hotel_tennis` varchar(5) NOT NULL DEFAULT '\0',
  PRIMARY KEY (`hotel_id`),
  UNIQUE KEY `hotel_hotel_id_uindex` (`hotel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `room_id` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_id` int(11) NOT NULL,
  `room_type` varchar(100) NOT NULL,
  `room_number` int(11) NOT NULL,
  `room_tv` varchar(5) NOT NULL DEFAULT '\0',
  `room_balcony` varchar(5) NOT NULL DEFAULT '\0',
  `room_conditioner` varchar(5) NOT NULL DEFAULT '\0',
  `room_view` varchar(100) NOT NULL,
  `room_free` bit(1) NOT NULL DEFAULT b'1',
  `room_cost` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`room_id`),
  KEY `room_hotel_hotel_id_fk` (`hotel_id`),
  CONSTRAINT `room_hotel_hotel_id_fk` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`hotel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;