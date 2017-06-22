--
-- Скрипт сгенерирован Devart dbForge Studio for MySQL, Версия 7.2.58.0
-- Домашняя страница продукта: http://www.devart.com/ru/dbforge/mysql/studio
-- Дата скрипта: 17.05.2017 22:22:32
-- Версия сервера: 5.7.18-log
-- Версия клиента: 4.1
--


-- 
-- Отключение внешних ключей
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

-- 
-- Установить режим SQL (SQL mode)
-- 
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 
-- Установка базы данных по умолчанию
--
USE test;

--
-- Описание для таблицы user
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
-- Вывод данных для таблицы user
--
INSERT INTO user VALUES
(7, 'Ivanov Petr Sergeevich', 33, False, '2017-05-17 22:12:40'),
(8, 'Panin Sergej Anatolevich', 32, False, '2017-05-17 22:12:00'),
(9, 'Lakina Irina Vladimirovna', 14, False, '2017-05-17 22:13:00'),
(10, 'Lavrov Petr Anatolevich', 43, True, '2017-05-17 22:13:00'),
(11, 'Kodin Danila Ivanovich', 23, False, '2017-05-17 22:13:00'),
(12, 'Federov Ivan Anatolevich', 0, False, '2017-05-17 22:13:41'),
(13, 'Sanin Petr Ignatevich', 54, True, '2017-05-17 22:15:10'),
(14, 'Kodin Evgenij Ivanovich', 32, False, '2017-05-17 22:15:28'),
(15, 'Kodin Aleksej Ivanovich', 23, False, '2017-05-17 22:15:38'),
(16, 'Lakina ZHanna Vladimirovna', 43, False, '2017-05-17 22:15:55'),
(17, 'Petrov Petr Ivanovich', 24, True, '2017-05-17 22:16:16'),
(18, 'Petrov Stas Ivanovich', 45, False, '2017-05-17 22:16:36'),
(19, 'Lakin Anton Pavlovich', 16, False, '2017-05-17 22:16:58');

-- 
-- Восстановить предыдущий режим SQL (SQL mode)
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- Включение внешних ключей
-- 
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;