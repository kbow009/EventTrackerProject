-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema wellnessdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `wellnessdb` ;

-- -----------------------------------------------------
-- Schema wellnessdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `wellnessdb` DEFAULT CHARACTER SET utf8 ;
USE `wellnessdb` ;

-- -----------------------------------------------------
-- Table `wellness`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wellness` ;

CREATE TABLE IF NOT EXISTS `wellness` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `activity` VARCHAR(45) NOT NULL,
  `self_care_minutes` INT NULL,
  `notes` VARCHAR(500) NULL,
  `mood_before` VARCHAR(45) NULL,
  `mood_after` VARCHAR(45) NULL,
  `date` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS wellnessuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'wellnessuser'@'localhost' IDENTIFIED BY 'wellnessuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'wellnessuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `wellness`
-- -----------------------------------------------------
START TRANSACTION;
USE `wellnessdb`;
INSERT INTO `wellness` (`id`, `activity`, `self_care_minutes`, `notes`, `mood_before`, `mood_after`, `date`) VALUES (1, 'Meditation', 20, NULL, NULL, NULL, '2021-10-03');
INSERT INTO `wellness` (`id`, `activity`, `self_care_minutes`, `notes`, `mood_before`, `mood_after`, `date`) VALUES (2, 'Hiking', 5, NULL, 'blah', 'clear', '2021-10-01');
INSERT INTO `wellness` (`id`, `activity`, `self_care_minutes`, `notes`, `mood_before`, `mood_after`, `date`) VALUES (3, 'Reading', 40, NULL, NULL, NULL, '2021-10-05');

COMMIT;

