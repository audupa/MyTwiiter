SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `testdb` DEFAULT CHARACTER SET latin1 ;
USE `testdb` ;

-- -----------------------------------------------------
-- Table `testdb`.`users`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `testdb`.`users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `user_name` VARCHAR(100) NOT NULL ,
  `password` VARCHAR(60) NULL DEFAULT NULL ,
  `email_id` VARCHAR(100) NULL DEFAULT NULL ,
  `created_time` DATETIME NULL DEFAULT NULL ,
  `updated_time` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `testdb`.`followers`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `testdb`.`followers` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `user_id` INT(11) NULL DEFAULT NULL ,
  `follower_id` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `followerId_idx` (`follower_id` ASC) ,
  INDEX `userId_idx` (`user_id` ASC) ,
  CONSTRAINT `followerId`
    FOREIGN KEY (`follower_id` )
    REFERENCES `testdb`.`users` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `userId`
    FOREIGN KEY (`user_id` )
    REFERENCES `testdb`.`users` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `testdb`.`tweet_comments`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `testdb`.`tweet_comments` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `comment_description` VARCHAR(200) NULL DEFAULT NULL ,
  `created_date` DATETIME NULL DEFAULT NULL ,
  `user_id` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `user_id` (`user_id` ASC) ,
  CONSTRAINT `tweet_comments_ibfk_1`
    FOREIGN KEY (`user_id` )
    REFERENCES `testdb`.`users` (`id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `testdb`.`tweets`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `testdb`.`tweets` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `tweet_message` VARCHAR(200) NULL DEFAULT NULL ,
  `created_date` DATETIME NULL DEFAULT NULL ,
  `user_id` INT(11) NOT NULL ,
  `updated_date` DATETIME NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `user_id_idx` (`user_id` ASC) ,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id` )
    REFERENCES `testdb`.`users` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 41
DEFAULT CHARACTER SET = latin1;

USE `testdb` ;
USE `testdb`;

DELIMITER $$
USE `testdb`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `testdb`.`tweets_OnInsert`
BEFORE INSERT ON `testdb`.`tweets`
FOR EACH ROW
SET NEW.created_date = IFNULL(NEW.created_date, NOW())$$

USE `testdb`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `testdb`.`tweets_OnUpdate`
BEFORE UPDATE ON `testdb`.`tweets`
FOR EACH ROW
SET NEW.updated_date = IFNULL(NEW.updated_date, NOW())$$


DELIMITER ;

DELIMITER $$
USE `testdb`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `testdb`.`users_OnInsert`
BEFORE INSERT ON `testdb`.`users`
FOR EACH ROW
SET NEW.created_date = IFNULL(NEW.created_date, NOW())$$

USE `testdb`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `testdb`.`users_OnUpdate`
BEFORE UPDATE ON `testdb`.`users`
FOR EACH ROW
SET NEW.updated_time = IFNULL(NEW.updated_time, NOW())$$


DELIMITER ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
