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
  `self_care_hours` INT NULL,
  `image_url` VARCHAR(100) NULL,
  `video_url` VARCHAR(100) NULL,
  `notes` VARCHAR(500) NULL,
  `mood_before` VARCHAR(45) NULL,
  `mood_after` VARCHAR(45) NULL,
  `activity_day` INT NULL,
  `activity_month` INT NULL,
  `activity_year` INT NULL,
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
INSERT INTO `wellness` (`id`, `activity`, `self_care_minutes`, `self_care_hours`, `image_url`, `video_url`, `notes`, `mood_before`, `mood_after`, `activity_day`, `activity_month`, `activity_year`) VALUES (1, 'Meditation', 20, NULL, NULL, NULL, NULL, NULL, NULL, 10, 9, 2021);
INSERT INTO `wellness` (`id`, `activity`, `self_care_minutes`, `self_care_hours`, `image_url`, `video_url`, `notes`, `mood_before`, `mood_after`, `activity_day`, `activity_month`, `activity_year`) VALUES (2, 'Hiking', 5, 2, NULL, NULL, NULL, 'blah', 'clear', 12, 9, 2021);
INSERT INTO `wellness` (`id`, `activity`, `self_care_minutes`, `self_care_hours`, `image_url`, `video_url`, `notes`, `mood_before`, `mood_after`, `activity_day`, `activity_month`, `activity_year`) VALUES (3, 'Reading', 40, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

COMMIT;

