CREATE SCHEMA IF NOT EXISTS `ReservaBus` DEFAULT CHARACTER SET utf8 ;
USE `ReservaBus` ;
CREATE TABLE IF NOT EXISTS `Autobus` (
  `idautobus` INT NOT NULL AUTO_INCREMENT,
  `Placa` VARCHAR(45) NOT NULL,
  `TipoDeBus` VARCHAR(45) NOT NULL,
  `NumeroDeSillas` INT NOT NULL,
  PRIMARY KEY (`idautobus`))
ENGINE = InnoDB;
insert into Autobus (Placa,TipoDeBus,NumeroDeSillas) values ("AAA111", "Prime",44);
insert into Autobus (Placa,TipoDeBus,NumeroDeSillas) values ("AAA112", "Prime",44);
insert into Autobus (Placa,TipoDeBus,NumeroDeSillas) values ("AAA113", "Prime",44);
insert into Autobus (Placa,TipoDeBus,NumeroDeSillas) values ("AAA114", "Prime",44);
insert into Autobus (Placa,TipoDeBus,NumeroDeSillas) values ("AAA115", "Prime",44);
CREATE TABLE IF NOT EXISTS `Ciudad` (
  `NombreCiudad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`NombreCiudad`))
ENGINE = InnoDB;
insert into Ciudad values ("Cartagena");
insert into Ciudad values ("Cali");
insert into Ciudad values ("Santa Marta");
insert into Ciudad values ("Tumaco");
insert into Ciudad values ("Bogota");
insert into Ciudad values ("Valledupar");
insert into Ciudad values ("Barranquilla");
insert into Ciudad values ("Medellin");
CREATE TABLE IF NOT EXISTS `Empleado` (
  `idempleado` VARCHAR(10) NOT NULL,
  `CedulaEmpleado` BIGINT NOT NULL,
  `NombreEmpleado` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idempleado`, `CedulaEmpleado`))
ENGINE = InnoDB;
insert into Empleado values ("emp01", 1112799681, "Arles Rodriguez");
insert into Empleado values ("emp02", 1112799682, "Camilo Cubides");
insert into Empleado values ("emp03", 1112799683, "Elizabeth Leon");
insert into Empleado values ("emp04", 1112799684, "Jonatan Gomez");
CREATE TABLE IF NOT EXISTS `Pasajero` (
  `Cedula` BIGINT NOT NULL,
  `Nombre` VARCHAR(100) NOT NULL,
  `TipoDeDocumento` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Cedula`))
ENGINE = InnoDB;
insert into Pasajero values (111542861, "Luis Fernandez","Cedula de ciudadanía");
insert into Pasajero values (111542862, "Pedro Rodriguez","Cedula de ciudadanía");
insert into Pasajero values (111542863, "Francisco Gutierrez","Cedula de ciudadanía");
insert into Pasajero values (111542864, "Jhon Lopez","Cedula de ciudadanía");
insert into Pasajero values (111542865, "Fredy Mercury","Cedula de ciudadanía");
CREATE TABLE IF NOT EXISTS `Turnos` (
  `autobus_idautobus` INT NOT NULL,
  `empleado_idempleado` VARCHAR(10) NOT NULL,
  `empleado_CedulaEmpleado` BIGINT NOT NULL,
  `FechaTurno` DATE NOT NULL,
  PRIMARY KEY (`autobus_idautobus`, `empleado_idempleado`, `empleado_CedulaEmpleado`),
  INDEX `fk_autobus_has_empleado_empleado1_idx` (`empleado_idempleado` ASC, `empleado_CedulaEmpleado` ASC) VISIBLE,
  INDEX `fk_autobus_has_empleado_autobus1_idx` (`autobus_idautobus` ASC) VISIBLE,
  CONSTRAINT `fk_autobus_has_empleado_autobus1`
    FOREIGN KEY (`autobus_idautobus`)
    REFERENCES `ReservaBus`.`Autobus` (`idautobus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_autobus_has_empleado_empleado1`
    FOREIGN KEY (`empleado_idempleado` , `empleado_CedulaEmpleado`)
    REFERENCES `Empleado` (`idempleado` , `CedulaEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
insert into Turnos values(1, "emp01", 1112799681, "2021/08/24");
insert into Turnos values(2, "emp02", 1112799682, "2021/08/24");
insert into Turnos values(3, "emp03", 1112799683, "2021/08/24");
insert into Turnos values(4, "emp04", 1112799684, "2021/08/24");
insert into Turnos values(5, "emp01", 1112799681, "2021/08/26");
insert into Turnos values(5, "emp02", 1112799682, "2021/08/28");
insert into Turnos values(5, "emp03", 1112799683, "2021/08/29");
insert into Turnos values(5, "emp04", 1112799684, "2021/08/30");
CREATE TABLE IF NOT EXISTS `Rutas` (
  `idrutas` INT NOT NULL AUTO_INCREMENT,
  `CiudadOrigen` VARCHAR(45) NOT NULL,
  `CiudadDestino` VARCHAR(45) NOT NULL,
  `Autobus_idautobus` INT NOT NULL,
  `FechaViaje` DATE NOT NULL,
  `HoraViaje` TIME NOT NULL,
  `Precio` INT NOT NULL,
  `SillasDisponibles` INT NOT NULL,
  PRIMARY KEY (`idrutas`, `CiudadOrigen`, `CiudadDestino`, `Autobus_idautobus`),
  INDEX `fk_Ciudad_has_Ciudad_Ciudad2_idx` (`CiudadDestino` ASC) VISIBLE,
  INDEX `fk_Ciudad_has_Ciudad_Ciudad1_idx` (`CiudadOrigen` ASC) VISIBLE,
  INDEX `fk_Ciudad_has_Ciudad_Autobus1_idx` (`Autobus_idautobus` ASC) VISIBLE,
  CONSTRAINT `fk_Ciudad_has_Ciudad_Ciudad1`
    FOREIGN KEY (`CiudadOrigen`)
    REFERENCES `Ciudad` (`NombreCiudad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ciudad_has_Ciudad_Ciudad2`
    FOREIGN KEY (`CiudadDestino`)
    REFERENCES `Ciudad` (`NombreCiudad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ciudad_has_Ciudad_Autobus1`
    FOREIGN KEY (`Autobus_idautobus`)
    REFERENCES `Autobus` (`idautobus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
insert into Rutas (CiudadOrigen, CiudadDestino, Autobus_idautobus, FechaViaje, HoraViaje, Precio, SillasDisponibles) values("Santa Marta", "Cartagena", 1, "2021/08/28", "12:00", "15000", 44);
insert into Rutas (CiudadOrigen, CiudadDestino, Autobus_idautobus, FechaViaje, HoraViaje, Precio, SillasDisponibles) values("Santa Marta", "Cartagena", 1, "2021/08/29", "13:00", "15000", 44);
insert into Rutas (CiudadOrigen, CiudadDestino, Autobus_idautobus, FechaViaje, HoraViaje, Precio, SillasDisponibles) values("Bogota", "Cali", 2, "2021/08/20", "14:00", "15000", 44);
insert into Rutas (CiudadOrigen, CiudadDestino, Autobus_idautobus, FechaViaje, HoraViaje, Precio, SillasDisponibles) values("Cali", "Tumaco", 3, "2021/08/20", "15:00", "15000", 44);
insert into Rutas (CiudadOrigen, CiudadDestino, Autobus_idautobus, FechaViaje, HoraViaje, Precio, SillasDisponibles) values("Bogota", "Medellin", 2, "2021/08/31", "16:00", "15000", 44);
insert into Rutas (CiudadOrigen, CiudadDestino, Autobus_idautobus, FechaViaje, HoraViaje, Precio, SillasDisponibles) values("Bogota", "Cali", 3, "2021/08/29", "17:00", "15000", 44);
insert into Rutas (CiudadOrigen, CiudadDestino, Autobus_idautobus, FechaViaje, HoraViaje, Precio, SillasDisponibles) values("Valledupar", "Barranquilla", 2, "2021/08/28", "18:00", "15000", 44);
insert into Rutas (CiudadOrigen, CiudadDestino, Autobus_idautobus, FechaViaje, HoraViaje, Precio, SillasDisponibles) values("Bogota", "Cali", 3, "2021/08/29", "16:00", "15000", 44);
insert into Rutas (CiudadOrigen, CiudadDestino, Autobus_idautobus, FechaViaje, HoraViaje, Precio, SillasDisponibles) values("Bogota", "Cali", 3, "2021/08/01", "16:00", "15000", 44);
CREATE TABLE IF NOT EXISTS `Reserva` (
  `idreserva` VARCHAR(6) NOT NULL,
  `TipoDePago` VARCHAR(45) NOT NULL,
  `Puesto` INT NOT NULL,
  `FechaViaje` DATE NOT NULL,
  `HoraSalida` TIME NOT NULL,
  `Precio` INT NOT NULL,
  `Pasajero_Cedula` BIGINT NOT NULL,
  `CiudadOrigen` VARCHAR(45) NOT NULL,
  `CiudadDestino` VARCHAR(45) NOT NULL,
  `Autobus_idautobus` INT NOT NULL,
  `idrutas` INT NOT NULL,
  PRIMARY KEY (`idreserva`, `Pasajero_Cedula`, `CiudadOrigen`, `CiudadDestino`, `Autobus_idautobus`, `idrutas`),
  INDEX `fk_Reserva_Pasajero1_idx` (`Pasajero_Cedula` ASC) VISIBLE,
  INDEX `fk_Reserva_Rutas1_idx` (`idrutas` ASC, `CiudadOrigen` ASC, `CiudadDestino` ASC, `Autobus_idautobus` ASC) VISIBLE,
  CONSTRAINT `fk_Reserva_Pasajero1`
    FOREIGN KEY (`Pasajero_Cedula`)
    REFERENCES `Pasajero` (`Cedula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Rutas1`
    FOREIGN KEY (`idrutas` , `CiudadOrigen` , `CiudadDestino` , `Autobus_idautobus`)
    REFERENCES `Rutas` (`idrutas` , `CiudadOrigen` , `CiudadDestino` , `Autobus_idautobus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
insert into Reserva values("Arr323", "Efectivo", "1", "2021/08/28", "11:00", "15000", 111542861, "Santa Marta", "Cartagena", 1, 1);
insert into Reserva values("Elv452", "Efectivo", "1", "2021/08/29", "12:00", "15000", 111542862, "Santa Marta", "Cartagena", 1, 2);
insert into Reserva values("Fri981", "Efectivo", "2", "2021/08/28", "13:00", "15000", 111542863, "Santa Marta", "Cartagena", 1, 1);
insert into Reserva values("Glo438", "Efectivo", "2", "2021/08/29", "14:00", "15000", 111542864, "Santa Marta", "Cartagena", 1, 2);
insert into Reserva values("Int187", "Efectivo", "3", "2021/08/29", "15:00", "15000", 111542862, "Santa Marta", "Cartagena", 1, 1);
insert into Reserva values("Lac375", "Efectivo", "3", "2021/08/28", "16:00", "15000", 111542865, "Santa Marta", "Cartagena", 1, 2);
insert into Reserva values("LoV422", "Efectivo", "4", "2021/08/29", "17:00", "15000", 111542861, "Santa Marta", "Cartagena", 1, 1);
insert into Reserva values("Mas874", "Efectivo", "5", "2021/08/28", "18:00", "15000", 111542862, "Santa Marta", "Cartagena", 1, 2);
insert into Reserva values("Par414", "Efectivo", "5", "2021/08/29", "19:00", "15000", 111542863, "Santa Marta", "Cartagena", 1, 1);
insert into Reserva values("The853", "Efectivo", "5", "2021/08/28", "11:00", "15000", 111542864, "Santa Marta", "Cartagena", 1, 2);
insert into Reserva values("Twa398", "Efectivo", "6", "2021/08/29", "12:00", "15000", 111542865, "Santa Marta", "Cartagena", 1, 1);
insert into Reserva values("Via725", "Efectivo", "6", "2021/08/28", "13:00", "15000", 111542861, "Santa Marta", "Cartagena", 1, 2);
insert into Reserva values("Vik782", "Efectivo", "7", "2021/08/28", "14:00", "15000", 111542861, "Santa Marta", "Cartagena", 1, 1);
insert into Reserva values("Aaa123", "Efectivo", "1", "2021/08/31", "16:00", "15000", 111542861, "Bogota", "Medellin", 2, 5);
insert into Reserva values("Aab121", "Efectivo", "1", "2021/08/29", "16:00", "15000", 111542861, "Bogota", "Cali", 3, 8);
insert into Reserva values("Aab122", "Efectivo", "2", "2021/08/29", "16:00", "15000", 111542862, "Bogota", "Cali", 3, 8);
insert into Reserva values("Aab123", "Efectivo", "3", "2021/08/29", "16:00", "15000", 111542863, "Bogota", "Cali", 3, 8);
insert into Reserva values("Aab124", "Efectivo", "4", "2021/08/29", "16:00", "15000", 111542864, "Bogota", "Cali", 3, 8);
insert into Reserva values("Aab125", "Efectivo", "5", "2021/08/29", "16:00", "15000", 111542865, "Bogota", "Cali", 3, 8);
CREATE TABLE IF NOT EXISTS `Equipaje` (
  `idequipaje` VARCHAR(5) NOT NULL,
  `Peso` INT NOT NULL,
  `TipoDeEquipaje` VARCHAR(45) NOT NULL,
  `Estado` VARCHAR(45) NOT NULL,
  `Reserva_idreserva` VARCHAR(6) NOT NULL,
  `Reserva_Pasajero_Cedula` BIGINT NOT NULL,
  `Reserva_CiudadOrigen` VARCHAR(45) NOT NULL,
  `Reserva_CiudadDestino` VARCHAR(45) NOT NULL,
  `Reserva_Autobus_idautobus` INT NOT NULL,
  `Reserva_idrutas` INT NOT NULL,
  PRIMARY KEY (`idequipaje`, `Reserva_idreserva`, `Reserva_Pasajero_Cedula`, `Reserva_CiudadOrigen`, `Reserva_CiudadDestino`, `Reserva_Autobus_idautobus`, `Reserva_idrutas`),
  INDEX `fk_Equipaje_Reserva1_idx` (`Reserva_idreserva` ASC, `Reserva_Pasajero_Cedula` ASC, `Reserva_CiudadOrigen` ASC, `Reserva_CiudadDestino` ASC, `Reserva_Autobus_idautobus` ASC, `Reserva_idrutas` ASC) VISIBLE,
  CONSTRAINT `fk_Equipaje_Reserva1`
    FOREIGN KEY (`Reserva_idreserva` , `Reserva_Pasajero_Cedula` , `Reserva_CiudadOrigen` , `Reserva_CiudadDestino` , `Reserva_Autobus_idautobus` , `Reserva_idrutas`)
    REFERENCES `Reserva` (`idreserva` , `Pasajero_Cedula` , `CiudadOrigen` , `CiudadDestino` , `Autobus_idautobus` , `idrutas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
insert into Equipaje values ("R51v6", 10, "Maleta", "Perdido", "Aaa123", 111542861, "Bogota", "Medellin", 2, 5);
insert into Equipaje values ("R51v7", 5, "Maleta", "Entregado", "Aaa123", 111542861, "Bogota", "Medellin", 2, 5);