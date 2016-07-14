USE hotels;
INSERT INTO `booking` VALUES
  (3, 3, '2016-07-20 00:00:00', '2016-07-23 00:00:00', 'Denis', 'Obodzinskiy', '380502838571'),
  (4, 1, '2016-07-24 00:00:00', '2016-07-31 00:00:00', 'Denis', 'Obodzinskiy', '380502838571'),
  (5, 4, '2016-07-20 00:00:00', '2016-07-31 00:00:00', 'Vlad', 'Yevlakov', '38050234234');

INSERT INTO `check_in` VALUES
  (1, '2016-07-10'),
  (1, '2016-07-17'),
  (1, '2016-07-24'),
  (1, '2016-07-31');

INSERT INTO `hotel` VALUES
  (1,'Hotel1','CHECK_IN','on','off','off'),
  (2,'Hotel2','DAILY','on','on','on'),
  (3,'Hotel3','DAILY','off','on','off');

INSERT INTO `room` VALUES
  (1,1,'SINGLE',100,'on','on','on','SEA','\0',400.00),
  (2,1,'DOUBLE',101,'on','off','on','SEA','',400.00),
  (3,2,'DOUBLE',103,'off','off','on','SEA','\0',200.00),
  (4,2,'TWIN',105,'false','true','true','POOL','\0',400.00),
  (5,1,'SINGLE',106,'on','on','off','SEA','',400.00),
  (6,1,'SINGLE',107,'on','on','off','SEA','',400.00);
