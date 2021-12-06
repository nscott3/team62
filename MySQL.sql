SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema team062
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema team062
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `team062` DEFAULT CHARACTER SET latin1 ;
USE `team062` ;

-- -----------------------------------------------------
-- Table `team062`.`Address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `team062`.`Address` (
  `houseName` VARCHAR(45) NOT NULL,
  `streetName` VARCHAR(45) NOT NULL,
  `placeName` VARCHAR(45) NOT NULL,
  `postcode` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`houseName`, `postcode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `team062`.`Person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `team062`.`Person` (
  `email` VARCHAR(30) NOT NULL,
  `title` VARCHAR(5) NOT NULL,
  `forename` VARCHAR(11) NOT NULL,
  `surname` VARCHAR(11) NOT NULL,
  `mobileNumber` VARCHAR(20) NOT NULL,
  `password` VARBINARY(64) NOT NULL,
  `salt` VARBINARY(64) NOT NULL,
  `houseName` VARCHAR(45) NOT NULL,
  `postcode` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`email`),
  INDEX `Person_ibfk_1` (`houseName` ASC, `postcode` ASC),
  CONSTRAINT `Person_ibfk_1`
    FOREIGN KEY (`houseName` , `postcode`)
    REFERENCES `team062`.`Address` (`houseName` , `postcode`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `team062`.`Host`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `team062`.`Host` (
  `hostID` VARCHAR(30) NOT NULL,
  `hostName` VARCHAR(11) NOT NULL,
  `isSuperhost` TINYINT(1) NOT NULL,
  PRIMARY KEY (`hostID`),
  CONSTRAINT `hostID`
    FOREIGN KEY (`hostID`)
    REFERENCES `team062`.`Person` (`email`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `team062`.`Property`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `team062`.`Property` (
  `propertyID` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  `location` VARCHAR(30) NOT NULL,
  `isBreakfast` TINYINT(1) NOT NULL,
  `maxGuests` INT(11) NOT NULL,
  `reviewRating` FLOAT NOT NULL,
  `hostID` VARCHAR(30) NOT NULL,
  `houseName` VARCHAR(45) NOT NULL,
  `postcode` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`propertyID`),
  INDEX `houseName` (`houseName` ASC, `postcode` ASC),
  INDEX `hostID_idx` (`hostID` ASC),
  CONSTRAINT `address`
    FOREIGN KEY (`houseName` , `postcode`)
    REFERENCES `team062`.`Address` (`houseName` , `postcode`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `host`
    FOREIGN KEY (`hostID`)
    REFERENCES `team062`.`Host` (`hostID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `team062`.`Bathing`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `team062`.`Bathing` (
  `bathingID` INT(11) NOT NULL AUTO_INCREMENT,
  `hasHairDryer` TINYINT(1) NOT NULL,
  `hasShampoo` TINYINT(1) NOT NULL,
  `hasToiletpaper` TINYINT(1) NOT NULL,
  `bathroomNum` INT(11) NOT NULL,
  `propertyID` INT(11) NOT NULL,
  PRIMARY KEY (`bathingID`),
  INDEX `bathingFK_idx` (`propertyID` ASC),
  CONSTRAINT `bathingFK`
    FOREIGN KEY (`propertyID`)
    REFERENCES `team062`.`Property` (`propertyID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `team062`.`Bathroom`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `team062`.`Bathroom` (
  `bathroomID` INT(11) NOT NULL AUTO_INCREMENT,
  `hasToilet` TINYINT(1) NOT NULL,
  `hasBath` TINYINT(1) NOT NULL,
  `hasShower` TINYINT(1) NOT NULL,
  `isShared` TINYINT(1) NOT NULL,
  `bathingID` INT(11) NOT NULL,
  PRIMARY KEY (`bathroomID`),
  INDEX `bathroomFK_idx` (`bathingID` ASC),
  CONSTRAINT `bathroomFK`
    FOREIGN KEY (`bathingID`)
    REFERENCES `team062`.`Bathing` (`bathingID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `team062`.`Sleeping`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `team062`.`Sleeping` (
  `sleepingID` INT(11) NOT NULL AUTO_INCREMENT,
  `hasBedLinen` TINYINT(1) NOT NULL,
  `hasTowel` TINYINT(1) NOT NULL,
  `bedroomsNum` TINYINT(1) NOT NULL,
  `bedsNum` TINYINT(1) NOT NULL,
  `sleepersNum` TINYINT(1) NOT NULL,
  `propertyID` INT(11) NOT NULL,
  PRIMARY KEY (`sleepingID`),
  INDEX `property_idx` (`propertyID` ASC),
  INDEX `sleepingFK_idx` (`propertyID` ASC),
  CONSTRAINT `sleepingFK`
    FOREIGN KEY (`propertyID`)
    REFERENCES `team062`.`Property` (`propertyID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `team062`.`Bedroom`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `team062`.`Bedroom` (
  `bedroomID` INT(11) NOT NULL AUTO_INCREMENT,
  `bedType1` VARCHAR(45) NOT NULL,
  `bedType2` VARCHAR(45) NULL DEFAULT NULL,
  `bedsNum` INT(11) NOT NULL,
  `sleepersNum` INT(11) NOT NULL,
  `sleepingID` INT(11) NOT NULL,
  PRIMARY KEY (`bedroomID`),
  INDEX `bedroomFK_idx` (`sleepingID` ASC),
  CONSTRAINT `bedroomFK`
    FOREIGN KEY (`sleepingID`)
    REFERENCES `team062`.`Sleeping` (`sleepingID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `team062`.`Guest`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `team062`.`Guest` (
  `guestID` VARCHAR(30) NOT NULL,
  `guestName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`guestID`),
  CONSTRAINT `guestID`
    FOREIGN KEY (`guestID`)
    REFERENCES `team062`.`Person` (`email`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `team062`.`Booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `team062`.`Booking` (
  `bookingID` INT(11) NOT NULL AUTO_INCREMENT,
  `startDate` DATE NOT NULL,
  `endDate` DATE NOT NULL,
  `isAccepted` TINYINT(1) NOT NULL,
  `isRejected` TINYINT(1) NOT NULL,
  `propertyID` INT(11) NOT NULL,
  `guestID` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`bookingID`),
  INDEX `propertyID_idx` (`propertyID` ASC),
  INDEX `guestID_idx` (`guestID` ASC),
  CONSTRAINT `guest`
    FOREIGN KEY (`guestID`)
    REFERENCES `team062`.`Guest` (`guestID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `property`
    FOREIGN KEY (`propertyID`)
    REFERENCES `team062`.`Property` (`propertyID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `team062`.`ChargeBand`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `team062`.`ChargeBand` (
  `propertyID` INT(11) NOT NULL,
  `startDate` DATE NOT NULL,
  `endDate` DATE NOT NULL,
  `pricePerNight` FLOAT NOT NULL,
  `serviceCharge` FLOAT NOT NULL,
  `cleaningCharge` FLOAT NOT NULL,
  PRIMARY KEY (`propertyID`, `startDate`, `endDate`),
  INDEX `startDate_idx` (`startDate` ASC),
  INDEX `endDate_idx` (`endDate` ASC),
  INDEX `propertyID` (`propertyID` ASC),
  CONSTRAINT `propertyID`
    FOREIGN KEY (`propertyID`)
    REFERENCES `team062`.`Property` (`propertyID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `team062`.`Kitchen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `team062`.`Kitchen` (
  `kitchenID` INT(11) NOT NULL AUTO_INCREMENT,
  `hasRefrigerator` TINYINT(1) NOT NULL,
  `hasMicrowave` TINYINT(1) NOT NULL,
  `hasOven` TINYINT(1) NOT NULL,
  `hasStove` TINYINT(1) NOT NULL,
  `hasDishwasher` TINYINT(1) NOT NULL,
  `hasTableware` TINYINT(1) NOT NULL,
  `hasCookware` TINYINT(1) NOT NULL,
  `hasBasicProvisions` TINYINT(1) NOT NULL,
  `propertyID` INT(11) NOT NULL,
  PRIMARY KEY (`kitchenID`),
  INDEX `kitchenFK_idx` (`propertyID` ASC),
  CONSTRAINT `kitchenFK`
    FOREIGN KEY (`propertyID`)
    REFERENCES `team062`.`Property` (`propertyID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `team062`.`Living`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `team062`.`Living` (
  `livingID` INT(11) NOT NULL AUTO_INCREMENT,
  `hasWifi` TINYINT(1) NOT NULL,
  `hasTV` TINYINT(1) NOT NULL,
  `hasSatellite` TINYINT(1) NOT NULL,
  `hasStreaming` TINYINT(1) NOT NULL,
  `hasDvdPlayer` TINYINT(1) NOT NULL,
  `hasBoardGames` TINYINT(1) NOT NULL,
  `propertyID` INT(11) NOT NULL,
  PRIMARY KEY (`livingID`),
  INDEX `livingFK_idx` (`propertyID` ASC),
  CONSTRAINT `livingFK`
    FOREIGN KEY (`propertyID`)
    REFERENCES `team062`.`Property` (`propertyID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `team062`.`Outdoor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `team062`.`Outdoor` (
  `outdoorID` INT(11) NOT NULL AUTO_INCREMENT,
  `hasFreeOnSiteParking` TINYINT(1) NOT NULL,
  `hasOnRoadParking` TINYINT(1) NOT NULL,
  `hasPaidParking` TINYINT(1) NOT NULL,
  `hasPatio` TINYINT(1) NOT NULL,
  `hasBarbeque` TINYINT(1) NOT NULL,
  `propertyID` INT(11) NOT NULL,
  PRIMARY KEY (`outdoorID`),
  INDEX `outdoorFK_idx` (`propertyID` ASC),
  CONSTRAINT `outdoorFK`
    FOREIGN KEY (`propertyID`)
    REFERENCES `team062`.`Property` (`propertyID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `team062`.`Review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `team062`.`Review` (
  `bookingID` INT(11) NOT NULL,
  `description` VARCHAR(200) NOT NULL,
  `scoreCleanliness` INT(1) UNSIGNED ZEROFILL NOT NULL,
  `scoreCommunication` INT(1) UNSIGNED ZEROFILL NOT NULL,
  `scoreCheckin` INT(1) UNSIGNED ZEROFILL NOT NULL,
  `scoreAccuracy` INT(1) UNSIGNED ZEROFILL NOT NULL,
  `scoreLocation` INT(1) UNSIGNED ZEROFILL NOT NULL,
  `scoreValue` INT(1) UNSIGNED ZEROFILL NOT NULL,
  `propertyID` INT(11) NOT NULL,
  PRIMARY KEY (`bookingID`),
  INDEX `property_idx` (`propertyID` ASC),
  CONSTRAINT `booking`
    FOREIGN KEY (`bookingID`)
    REFERENCES `team062`.`Booking` (`bookingID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `property_fk`
    FOREIGN KEY (`propertyID`)
    REFERENCES `team062`.`Property` (`propertyID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `team062`.`Utility`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `team062`.`Utility` (
  `utilityID` INT(11) NOT NULL AUTO_INCREMENT,
  `hasCentralHeating` TINYINT(1) NOT NULL,
  `hasWashingMachine` TINYINT(1) NOT NULL,
  `hasDryingMachine` TINYINT(1) NOT NULL,
  `hasFireExtinguisher` TINYINT(1) NOT NULL,
  `hasSmokeAlarm` TINYINT(1) NOT NULL,
  `hasFirstAidKit` TINYINT(1) NOT NULL,
  `propertyID` INT(11) NOT NULL,
  PRIMARY KEY (`utilityID`),
  INDEX `utilityID_idx` (`propertyID` ASC),
  CONSTRAINT `utilityID`
    FOREIGN KEY (`propertyID`)
    REFERENCES `team062`.`Property` (`propertyID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
