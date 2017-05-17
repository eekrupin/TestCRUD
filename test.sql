--
-- ������ ������������ Devart dbForge Studio for MySQL, ������ 7.2.58.0
-- �������� �������� ��������: http://www.devart.com/ru/dbforge/mysql/studio
-- ���� �������: 17.05.2017 22:22:32
-- ������ �������: 5.7.18-log
-- ������ �������: 4.1
--


-- 
-- ���������� ������� ������
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

-- 
-- ���������� ����� SQL (SQL mode)
-- 
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 
-- ��������� ���� ������ �� ���������
--
USE test;

--
-- �������� ��� ������� user
--
DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id INT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(25) NOT NULL,
  age INT(3) NOT NULL,
  isAdmin BIT(1) NOT NULL,
  createdDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  UNIQUE INDEX UK_user_id (id)
)
ENGINE = INNODB
AUTO_INCREMENT = 20
AVG_ROW_LENGTH = 1260
CHARACTER SET utf8
COLLATE utf8_general_ci
ROW_FORMAT = DYNAMIC;

-- 
-- ����� ������ ��� ������� user
--
INSERT INTO user VALUES
(7, 'Иванов Петр Сергеевич', 33, False, '2017-05-17 22:12:40'),
(8, 'Панин Сергей Анатольевич', 32, False, '2017-05-17 22:12:00'),
(9, 'Лакина Ирина Владимировна', 14, False, '2017-05-17 22:13:00'),
(10, 'Лавров Петр Анатольевич', 43, True, '2017-05-17 22:13:00'),
(11, 'Кодин Данила Иванович', 23, False, '2017-05-17 22:13:00'),
(12, 'Федеров Иван Анатольевич', 0, False, '2017-05-17 22:13:41'),
(13, 'Санин Петр Игнатьевич', 54, True, '2017-05-17 22:15:10'),
(14, 'Кодин Евгений Иванович', 32, False, '2017-05-17 22:15:28'),
(15, 'Кодин Алексей Иванович', 23, False, '2017-05-17 22:15:38'),
(16, 'Лакина Жанна Владимировна', 43, False, '2017-05-17 22:15:55'),
(17, 'Петров Петр Иванович', 24, True, '2017-05-17 22:16:16'),
(18, 'Петров Стас Иванович', 45, False, '2017-05-17 22:16:36'),
(19, 'Лакин Антон Павлович', 16, False, '2017-05-17 22:16:58');

-- 
-- ������������ ���������� ����� SQL (SQL mode)
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- ��������� ������� ������
-- 
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;