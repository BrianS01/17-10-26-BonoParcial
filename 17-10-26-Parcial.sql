SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP DATABASE IF EXISTS `mydb`;
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb`;
-- -----------------------------------------------------
-- Table `mydb`.`parafiscales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`parafiscales` (
  `idParafiscales` INT NOT NULL,
  `sena` INT NULL,
  `icbf` INT NULL,
  `cajaCompensacion` INT NULL,
  PRIMARY KEY (`idParafiscales`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`salario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`salario` (
  `idSalario` INT NOT NULL,
  `auxilio` INT NULL,
  `prima` INT NULL,
  `cesantias` INT NULL,
  `interes` INT NULL,
  `vacasiones` INT NULL,
  `salud` INT NULL,
  `pension` INT NULL,
  `idParafiscales` INT NULL,
  `salario` INT NULL,
  `pago` INT NULL,
  PRIMARY KEY (`idSalario`),
  INDEX `idParafiscales_idx` (`idParafiscales` ASC),
  CONSTRAINT `idParafiscales`
    FOREIGN KEY (`idParafiscales`)
    REFERENCES `mydb`.`parafiscales` (`idParafiscales`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`departamento` (
  `idDepartamento` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `puesto` VARCHAR(45) NULL,
  PRIMARY KEY (`idDepartamento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`contrato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`contrato` (
  `idContrato` INT NOT NULL,
  `tipoContrato` VARCHAR(45) NULL,
  `turno` VARCHAR(45) NULL,
  PRIMARY KEY (`idContrato`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`empleado` (
  `cedula` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `lugarNacimiento` VARCHAR(45) NULL,
  `estatus` VARCHAR(45) NULL,
  `fechaIngreso` DATE NULL,
  `idSalario` INT NULL,
  `idDepartamento` INT NULL,
  `idContrato` INT NULL,
  PRIMARY KEY (`cedula`),
  INDEX `idSueldo_idx` (`idSalario` ASC),
  INDEX `idDepartamento_idx` (`idDepartamento` ASC),
  INDEX `idContrato_idx` (`idContrato` ASC),
  CONSTRAINT `idSalario`
    FOREIGN KEY (`idSalario`)
    REFERENCES `mydb`.`salario` (`idSalario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idDepartamento`
    FOREIGN KEY (`idDepartamento`)
    REFERENCES `mydb`.`departamento` (`idDepartamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idContrato`
    FOREIGN KEY (`idContrato`)
    REFERENCES `mydb`.`contrato` (`idContrato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

insert into empleado(cedula,nombre,lugarNacimiento,estatus,fechaIngreso) values ('12','jose rojas' ,'culiacan','activo','2012-07-01');
select * from empleado;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

insert into empleado(cedula,nombre,lugarNacimiento,estatus,fechaIngreso) values ('12','jose rojas' ,'culiacan','activo','2012-07-01');
select * from empleado;